$(document).ready(function() {
  var timelineContainer = $('#timeline')[0];
  var timeline = new vis.Timeline(timelineContainer);

  var startDateInput = $('#startDate');
  var endDateInput = $('#endDate');
  var staffTypesSelect = $('#staffTypes');
  var activitiesSelect = $('#activities');
  var showTodayCheckbox = $('#showToday');
  var todaysDateCheckbox = $('#todaysDate');
  var showWeeklyGridCheckbox = $('#showWeeklyGrid');
  var weekStartDateInput = $('#weekStartDate');
  var showDateBarsCheckbox = $('#showDateBars');
  var showConfirmedOnlyCheckbox = $('#showConfirmedOnly');
  var showEventsCheckbox = $('#showEvents');
  var submitDeploymentButton = $('#submit-deployment');
  
  ftRest.getStaffTypes().then(function(staffTypes) {
    staffTypesSelect.append(new Option('All', 'All'));
    $.each(staffTypes, function(idx, st) {
      staffTypesSelect.append(new Option(st.staffType, st.id));
    });
  });

  ftRest.getActivities().then(function(activities) {
    activitiesSelect.append(new Option('All', 'All'));
    $.each(activities, function(idx, act) {
      activitiesSelect.append(new Option(act.description, act.id));
    });
  });

  submitDeploymentButton.click(function() {
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
          var confirmedType = ftUtil.colorLabel(
            sr.confirmedTypeColorCode, sr.confirmedTypeDescription);
          console.log(confirmedType);
          var dates = ftUtil.simpleDate(sr.startDate) +' to ' + ftUtil.simpleDate(sr.endDate);
          var content = $('<div>')
                .append(activityName)
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
      });
    });
  });
});
