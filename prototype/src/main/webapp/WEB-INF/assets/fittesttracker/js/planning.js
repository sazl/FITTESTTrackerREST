$(document).ready(function() {
  var confirmedTypesSelect = $('#confirmedTypes');
  var activitiesSelect = $('#activities');
  var countriesList = $("#countries");
  var activityTypeLabel = $("#activityType");
  var planningTableBody = $('#planning-table-body');

  var staffRoleForm = $('#staff-role-form');
  var staffRoleStaff = $('#staff-role-staff');
  var staffRoleLocation = $('#staff-role-location');
  var staffRoleComments = $('#staff-role-comments');
  var staffRoleStartDate = $('#staff-role-startDate');
  var staffRoleEndDate = $('#staff-role-endDate');
  var staffRoleConfirmedTypes = $('#staff-role-confirmedTypes');

  ftRest.getConfirmedTypes().then(function(confirmedTypes) {
    $.each(confirmedTypes, function (idx, ct) {
      confirmedTypesSelect.append(
        new Option(ct.confirmedType, ct.id));
      staffRoleConfirmedTypes.append(
        new Option(ct.confirmedType, ct.id));
    });
    confirmedTypesSelect.append(new Option('All', 'All'));
  });

  ftRest.getStaff().then(function(staff) {
    $.each(staff, function(idx, s) {
      var opt = new Option(s.name, s.id);
      staffRoleStaff.append(opt);
    });
  });
  
  confirmedTypesSelect.change(function() {
    var activities;
    var confirmedTypeId = $(this).val();
    activitiesSelect.empty();
    
    if (confirmedTypeId === 'All') {
      activities = ftRest.getActivities();
    }
    else {
      activities = ftRest.getActivitiesByConfirmedTypeId(confirmedTypeId);
    }

    activities.then(function(acts) {
      if (acts.length == 0) {
        activitiesSelect.attr('disabled', true);
        countriesList.empty();
        activityTypeLabel.empty();
      }
      else {
        activitiesSelect.attr('disabled', false);
        activitiesSelect.append(new Option('-- Select an activity --', '', true));
        $.each(acts, function(idx, act) {
          activitiesSelect.append(
            new Option(act.description, act.id));
        });
      }
    });
  });

  function buildStaffRoleTable(activityRoleId) {
    return ftRest.getStaffRolesByActivityRoleId(activityRoleId)
      .then(function(staffRoles) {
        var tbl = $('<table>')
              .addClass('table table-bordered table-responsive' +
                        ' table-hover staff-role-table');

        var headers = [
          'Staff Name', 'Staff Index', 'Location',
          'Start Date', 'End Date', 'Comments', 'Confirmed Type'
        ];
        var thead = $('<thead>').append('<tr>').append(function() {
          var thd = $(this);
          $.each(headers, function(idx, hdr) {
            thd.append($('<th>').append(hdr));
          });
        });
        
        var tbody = $('<tbody>');
        $.each(staffRoles, function(idx, sr) {
          var tr = $('<tr>').attr('id', sr.id);
          ftRest.getStaffByStaffRoleId(sr.id).then(function(staff) {
            tr.append($('<td>').append(staff.name));
            tr.append($('<td>').append(staff.id));
          }).then(function(){
            tr.append($('<td>').append(sr.location));
            tr.append($('<td>').append(ftUtil.simpleDate(sr.startDate)));
            tr.append($('<td>').append(ftUtil.simpleDate(sr.endDate)));
            tr.append($('<td>').append(sr.comments));
          }).then(function(){
            ftRest.getConfirmedTypeByStaffRoleId(sr.id).then(function(ct) {
              tr.append($('<td>').append(
                ftUtil.colorLabel(ct.confirmedColorCode, ct.confirmedType)));
            });
          });
          tbody.append(tr);
        });

        tbl.append(thead);
        tbl.append(tbody);
        return tbl;
      });
  }

  function buildActivityRoleTable(activityId) {
    return ftRest.getActivityRolesByActivityId(activityId).then(function(activityRoles) {
      planningTableBody.empty();
      $.each(activityRoles, function(idx, ar) {
        var trinfo = $('<tr>').addClass('info');
        var trStaffRole = $('<tr>');
        var tdStaffRole = $('<td>').attr('colspan', 5);
        buildStaffRoleTable(ar.id).then(function(staffRoleTable) {
          tdStaffRole.append(staffRoleTable);
          trStaffRole.append(tdStaffRole);
        }).then(function() {
          trinfo.append($('<td>').append(
            $('<button>')
              .addClass('btn btn-sm btn-danger collapse-button')
              .append(
                $('<span>')
                  .addClass('glyphicon glyphicon-minus'))));
          trinfo.append($('<td>').addClass('warning').append(
            $('<b>').text(ar.profileTypeDescription)));
          trinfo.append($('<td>').append(ar.location));
          trinfo.append($('<td>').append(ftUtil.simpleDate(ar.startDate)));
          trinfo.append($('<td>').append(ftUtil.simpleDate(ar.endDate)));

        }).then(function() {
          planningTableBody.append(trinfo);
          planningTableBody.append(trStaffRole);
          return planningTableBody;
        });
      });
    });
  }
  
  activitiesSelect.change(function() {
    var activityId = $(this).val();
    ftRest.getCountriesByActivityId(activityId).then(function(cnts) {
      countriesList.empty();
      $.each(cnts, function(idx, cnt) {
        countriesList.append('<li>' + cnt.fullName + '</li>');
      });
    }).then(function() {
      ftRest.getActivityTypeByActivityId(activityId).then(function(at) {
        activityTypeLabel.text(at.activityType);
      });
    }).then(function() {
      buildActivityRoleTable(activityId);
    });
  });

  $('body').on('click', '#planning-table tr.info', function(event) {
    var elem = $(this).parent('tr').next('tr');
    elem.hide('highlight');
  });

  $('body').on('click', '.staff-role-table tr', function(event) {
    $('.staff-role-table tr').removeClass('active');
    var row = $(this);
    row.addClass('active');
    var staffRoleId = row.attr('id');
    ftRest.getStaffRoleById(staffRoleId).then(function(sr) {
      staffRoleStaff.val(sr.staffId);
      staffRoleLocation.val(sr.location);
      staffRoleComments.val(sr.comments);
      staffRoleStartDate.val(ftUtil.simpleDate(sr.startDate));
      staffRoleEndDate.val(ftUtil.simpleDate(sr.endDate));
      staffRoleConfirmedTypes.val(sr.confirmedTypeId);
    });
    alertify.success('Staff Role Selected');
    staffRoleForm.effect('highlight', 1000);
  });
  
});
