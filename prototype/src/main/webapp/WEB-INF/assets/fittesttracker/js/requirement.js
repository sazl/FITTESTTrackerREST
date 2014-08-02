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
  });

  submitRequirementButton.click(function(event) {
    var startDate = startDateInput.val();
    var endDate = endDateInput.val();
    var activities = activitiesSelect.val();

    ftRest.getRequirements(startDate, endDate, activities).then(function(activityRoles) {
      if (activityRoles == undefined || activityRoles.length == 0) {
        alertify.alert('No activity roles found');
        return null;
      }

      var groups = _.map(activityRoles, function(ar) {
        return {id: ar.activityId, content: ar.activityDescription, value: ar.activityId};
      });

      groups = _.map(_.groupBy(groups, function(ar){
        return ar.id;
      }), function(grouped){
        return grouped[0];
      });

      var items = _.map(activityRoles, function(ar) {
        return {
          id: ar.id,
          group: ar.activityId,
          content: ar.profileTypeDescription,
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
            var item = {
              id: Math.floor(Math.random() * 100000000),
              group: ar.activityId,
              content: sr.staffName,
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
