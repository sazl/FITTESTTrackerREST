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

    ftRest.getRequirements(startDate, endDate, activities).then(function(activityRoles) {
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
      return [activityRoles, items];
      
    }).then(function(data) {
      var activityRoles = data[0];
      var items = data[1];
      
      $.each(activityRoles, function(idx, ar) {
        ftRest.getStaffRolesByIds(ar.staffRoleIds).then(function(staffRoles) {
          $.each(staffRoles, function(i, sr) {
            var item = {
              id: sr.id*5 + ar.id*7 + (idx+1)*9 + (i+1)*43,
              group: ar.activityId,
              content: sr.staffName,
              start: sr.startDate,
              end: sr.endDate
            };
            items.push(item);            
          });
          return items;
        }).then(function (items) {
          console.log(items);
          timeline.setItems(new vis.DataSet(items));
        });
      });
    });
  });
});
