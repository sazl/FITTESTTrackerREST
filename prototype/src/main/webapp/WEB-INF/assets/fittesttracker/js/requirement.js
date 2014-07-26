$(document).ready(function() {
  var timelineContainer = $('#timeline')[0];
  var timeline = new vis.Timeline(timelineContainer);

  var startDateInput = $('#startDate');
  var endDateInput = $('#endDate');
  var activitiesSelect = $('#activities');
  var showConfirmedOnlyCheckbox = $('#showConfirmedOnly');
  var showEventsCheckbox = $('#showEvents');
  var submitRequirementButton = $('#submit-requirement');

  ftRest.getActivities().then(function(activities) {
    $.each(activities, function(idx, act) {
      activitiesSelect.append(new Option(act.description, act.id));
    });
  });

  submitRequirementButton.click(function() {
    var startDate = startDateInput.val();
    var endDate = endDateInput.val();
    var activities = activitiesSelect.val();

    var activityRoles = ftRest.getRequirementsBlocking(startDate, endDate, activities);
    if (activityRoles.length == 0) {
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
        start: ar.startDate,
        end: ar.endDate
      };
    });
    timeline.setGroups(new vis.DataSet(groups));
    timeline.setItems(new vis.DataSet(items));
          
    $.each(activityRoles, function(idx, ar) {
      var staffRoles =  ftRest.getStaffRolesByIdsBlocking(ar.staffRoleIds);
      $.each(staffRoles, function(i, sr) {
        var item = {
          id: Math.floor(Math.random() * 100000000),
          group: ar.activityId,
          content: sr.staffName,
          start: sr.startDate,
          end: sr.endDate
        };
        items.push(item);            
      });
    });
    timeline.setItems(new vis.DataSet(items));
    timeline.redraw();
    return null;
  });
});
