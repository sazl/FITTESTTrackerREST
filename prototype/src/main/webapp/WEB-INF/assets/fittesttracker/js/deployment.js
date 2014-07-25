$(document).ready(function() {
  var timelineContainer = $('#timeline')[0];
  var timeline = new vis.Timeline(timelineContainer, {}, {});

  var startDate = $('#startDate');
  var endDate = $('#endDate');
  var staffTypesSelect = $('#staffTypes');
  var activitiesSelect = $('#activities');
  var showToday = $('#showToday');
  var todaysDate = $('#todaysDate');
  var showWeeklyGrid = $('#showWeeklyGrid');
  var weekStartDate = $('#weekStartDate');
  var showDateBars = $('#showDateBars');
  var showConfirmedOnly = $('#showConfirmedOnly');
  var showEvents = $('#showEvents');
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
    console.log('clicked');
  });
  
});
