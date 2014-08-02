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
  var staffTypesSelect = $('#staffTypes');
  var activitiesSelect = $('#activities');
  var showConfirmedOnlyCheckbox = $('#showConfirmedOnly');
  var showEventsCheckbox = $('#showEvents');
  var submitDeploymentButton = $('#submit-deployment');
  var clearDeploymentButton = $('#clear-deployment');
  
  ftRest.getStaffTypes().then(function(staffTypes) {
    $.each(staffTypes, function(idx, st) {
      staffTypesSelect.append(new Option(st.staffType, st.id));
    });
  }).then(function() {
    ftRest.getActivities().then(function(activities) {
      $.each(activities, function(idx, act) {
        activitiesSelect.append(new Option(act.description, act.id));
      });
    });
  });

  clearDeploymentButton.click(function(event) {
    timeline.clear();
  });

  submitDeploymentButton.click(function(event) {
    var startDate = startDateInput.val();
    var endDate = endDateInput.val();
    var staffTypes = staffTypesSelect.val();
    var activities = activitiesSelect.val();
    ftRest.getDeployments(startDate, endDate, staffTypes, activities).then(function(staffRoles) {
      if (staffRoles.length == 0) {
        alertify.alert('No staff roles found');
        return;
      }

      var staffIds = _.uniq(_.map(staffRoles, function(sr) { return sr.staffId; }));
      ftRest.getStaffByIds(staffIds).then(function(staff) {
        var groups = _.map(staff, function(s) {
          return {id: s.id, content: $('<b>').text(s.name)[0], value: s.id};
        });
        return groups;
      }).then(function(groups) {
        var items = _.map(staffRoles, function(sr) {
          var activityName = $('<b>').text(sr.activityRoleDescription)[0];
          var profileType = $('<b>').text('[' + sr.activityRoleProfileTypeDescription + ']')[0];
          var confirmedType = ftUtil.colorLabel(
            sr.confirmedTypeColorCode, sr.confirmedTypeDescription);
          var dates = ftUtil.simpleDate(sr.startDate) +' to ' + ftUtil.simpleDate(sr.endDate);
          var content = $('<div>')
                // .css('background-color', 'red')
                .append(activityName)
                .append('<br/>')
                .append(profileType)
                .append('  ')
                .append(confirmedType)
                .append('<br/>')
                .append(dates)[0];
          return {
            id: sr.id,
            group: sr.staffId,
            content: content,
            start: ftUtil.ISODateToDate(sr.startDate),
            end: ftUtil.ISODateToDate(sr.endDate)
          };
        });
        
        timeline.setGroups(new vis.DataSet(groups));
        timeline.setItems(new vis.DataSet(items));
        timeline.redraw();
      });
    });
    event.preventDefault();
  });
});
