$(document).ready(function() {
  var confirmedTypesSelect = $('#confirmedTypes');
  var activitiesSelect = $('#activities');
  var countriesList = $("#countries");
  var activityTypeLabel = $("#activityType");

  confirmedTypesSelect.change(function() {
    var activities;
    var confirmedType = $(this).val();
    console.log(confirmedType);
    activitiesSelect.empty();
    
    if (confirmedType === 'All') { activities = ftRest.getActivities(); }
    else { activities = ftRest.getActivitiesByConfirmedType(confirmedType); }

    activities.then(function(acts) {
      console.log(typeof acts);
      if (acts.length == 0) {
        activitiesSelect.attr('disabled', true);
      }
      else {
        activitiesSelect.attr('disabled', false);
        $.each(acts, function(idx, act) {
          activitiesSelect.append(
            new Option(act.description, act.description));
        });
      }
    });
  });
  
  ftRest.getConfirmedTypes().then(function(confirmedTypes) {
    $.each(confirmedTypes, function (idx, ct) {
      confirmedTypesSelect.append(
        new Option(ct.confirmedType, ct.confirmedType));
    });
    confirmedTypesSelect.append(new Option('All', 'All'));
  });

  activitiesSelect.change(function() {
    
  });
  
});
