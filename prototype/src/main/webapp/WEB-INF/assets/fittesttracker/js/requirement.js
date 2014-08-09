$(document).ready(function() {
  var timelineContainer = $('#timeline')[0];
  var timelineMarker = $('#timelineMarker')[0];
  var timelineOptions = {
    orientation: 'top',
    showCustomTime: true
  };
  var timeline = new vis.Timeline(timelineContainer);
  timeline.setOptions(timelineOptions);

  timeline.on('timechange', function (properties) {
    timelineMarker.innerHTML = ftUtil.simpleDate(properties.time);
  });
  
  var startDateInput = $('#startDate');
  var endDateInput = $('#endDate');
  var activitiesSelect = $('#activities');
  var showConfirmedOnlyCheckbox = $('#showConfirmedOnly');
  var showEventsCheckbox = $('#showEvents');
  var submitRequirementButton = $('#submit-requirement');
  var clearRequirementButton = $('#clear-requirement');

  ftRest.getActivities().then(function(activities) {
    $.each(activities, function(idx, act) {
      activitiesSelect.append(new Option(act.description, act.id));
    });
  });

  clearRequirementButton.click(function(event) {
    timeline.clear();
    $('select').select2('data', null);
  });

  submitRequirementButton.click(function(event) {
    var startDate = startDateInput.val();
    var endDate = endDateInput.val();
    var activities = activitiesSelect.val();
    timeline.setCustomTime(ftUtil.simpleDateToDate(startDate));

    ftRest.getRequirements(startDate, endDate, activities).then(function(activityRoles) {
      if (activityRoles == undefined || activityRoles.length == 0) {
        alertify.alert('No activity roles found');
        return null;
      }

      var groups = _.map(activityRoles, function(ar) {
        return {
          id: ar.id,
          content: $('<div>')
            .append($('<b>').text(ar.activityDescription))
            .append('<br/>')
            .append($('<b>').text('[' + ar.profileTypeDescription + ']'))[0],
          value: ar.activityId
        };
      });

      var items = _.map(activityRoles, function(ar) {
        return {
          id: ar.id,
          group: ar.id,
          className: 'green',
          content: $('<div>')
            .append($('<b>').text(ar.profileTypeDescription))[0],
          start: ftUtil.ISODateToDate(ar.startDate),
          end: ftUtil.ISODateToDate(ar.endDate)
        };
      });
      timeline.setGroups(new vis.DataSet(groups));
      timeline.setItems(new vis.DataSet(items));
      return [activityRoles, items, groups];
    }).then(function(data) {
      var activityRoles = data[0];
      var items = data[1];
      var groups = data[2];
      
      var staffRolesPromises = _.map(activityRoles, function(ar) {
        return ftRest.getStaffRolesByIds(ar.staffRoleIds);
      });

      $.when.apply($, staffRolesPromises).then(function() {
        var activityRolesStaffRoles = arguments;
        $.each(activityRolesStaffRoles, function(i, staffRoles) {
          var ar = activityRoles[i];
          $.each(staffRoles, function(j, sr) {
            var itemId = Math.floor(Math.random() * 100000000);
            var className = 'color' + itemId;
            ftUtil.timelineAppendColorClass(className, sr.staffColorCode);
            
            var item = {
              id: itemId,
              group: ar.id,
              className: className,
              content: $('<div>')
                .append($('<b>').text(sr.staffName))
                .append($('<br/>'))
                .append(ftUtil.simpleDate(sr.startDate) + ' to ' + ftUtil.simpleDate(sr.endDate))[0],
              start: ftUtil.ISODateToDate(sr.startDate),
              end: ftUtil.ISODateToDate(sr.endDate)
            };
            items.push(item);
          });
        });
      }).done(function() {
        timeline.setItems(new vis.DataSet(items));
        timeline.redraw();
      });
    });
  });
});
