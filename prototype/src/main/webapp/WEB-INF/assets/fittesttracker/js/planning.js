$(document).ready(function() {
  var confirmedTypesSelect = $('#confirmedTypes');
  var activitiesSelect = $('#activities');
  var countriesList = $("#countries");
  var activityTypeLabel = $("#activityType");

  var planningPanelBody = $('#planning-panel-body');
  var planningPanelCollapseButton = $('#collapse-planning-panel');
  var planningTablePanelBody = $('#planning-table-panel-body');
  var planningTablePanelCollapseButton = $('#collapse-planning-table-panel');
  var planningTableBody = $('#planning-table-body');

  var staffRoleForm = $('#staff-role-form');
  var staffRoleStaffRoleId = $('#staff-role-id');
  staffRoleStaffRoleId.attr('disabled', true);
  
  var staffRoleStaff = $('#staff-role-staff');
  var staffRoleLocation = $('#staff-role-location');
  var staffRoleComments = $('#staff-role-comments');
  var staffRoleStartDate = $('#staff-role-startDate');
  var staffRoleEndDate = $('#staff-role-endDate');
  var staffRoleActivityRoles = $('#staff-role-activityRoles');
  staffRoleActivityRoles.attr('disabled', true);
  
  var staffRoleConfirmedTypes = $('#staff-role-confirmedTypes');
  var staffRoleSaveButton = $('#staff-role-save');
  var staffRoleClearButton = $('#staff-role-clear');

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
          'Staff Name', 'Staff Index',
          'Location',
          'Start Date', 'End Date',
          'Comments',
          'Confirmed Type'
        ];
        var header_widths = [
          20, 10,
          15,
          10, 10,
          25,
          10
        ];
        var thead = $('<thead>').append(function() {
          var trhd = $('<tr>').addClass("success");
          $.each(headers, function(idx, hdr) {
            trhd.append($('<th>').width(header_widths[idx] + '%').append(hdr));
          });
          return trhd;
        });
        
        var tbody = $('<tbody>');
        $.each(staffRoles, function(idx, sr) {
          var tr = $('<tr>').attr('id', sr.id);
          ftRest.getStaffByStaffRoleId(sr.id).then(function(staff) {
            tr.append($('<td>').append(staff.name));
            tr.append($('<td>')
                      .addClass('text-center')
                      .append(staff.id));
          }).then(function(){
            tr.append($('<td>').append(sr.location));
            tr.append($('<td>').append(ftUtil.simpleDate(sr.startDate)));
            tr.append($('<td>').append(ftUtil.simpleDate(sr.endDate)));
            tr.append($('<td>').append(sr.comments));
          }).then(function(){
            ftRest.getConfirmedTypeByStaffRoleId(sr.id).then(function(ct) {
              tr.append($('<td>')
                        .addClass('text-center')
                        .append(
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
                  .addClass('glyphicon glyphicon-arrow-up'))));
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

  function removeActiveStaffRoleRow() {
    $('.staff-role-table tr').removeClass('active');
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

  $('body').on('click', '#planning-table .collapse-button', function(event) {
    var button = $(this);
    var icon = button.children('span');
    var elem = $(this).closest('tr').next('tr');
    if (button.hasClass('btn-danger')) {
      button.switchClass('btn-danger', 'btn-success', 0);
      icon.switchClass('glyphicon-arrow-up', 'glyphicon-arrow-down', 0);
    }
    else {
      button.switchClass('btn-success', 'btn-danger', 0);
      icon.switchClass('glyphicon-arrow-down', 'glyphicon-arrow-up', 0);
    }
    elem.toggle({
      effect: 'highlight',
      duration: 150
    });
  });

  $('#planning-table-collapse-button').click(function() {
    var button = $(this);
    var icon = button.children('span');
    var toggleButtons = $('#planning-table .collapse-button');
    
    if (button.hasClass('btn-warning')) {
      button.switchClass('btn-warning', 'btn-success', 0);
      icon.switchClass('glyphicon-chevron-up', 'glyphicon-chevron-down', 0);
      icon.text(' Expand');
      $.each(toggleButtons, function(i, b) {
        var btn = $(b);
        if (btn.hasClass('btn-danger')) {
          btn.click();
        }
      });
    }
    else {
      button.switchClass('btn-success', 'btn-warning', 0);
      icon.switchClass('glyphicon-chevron-down', 'glyphicon-chevron-up', 0);
      icon.text(' Collapse');
      $.each(toggleButtons, function(i, b) {
        var btn = $(b);
        if (btn.hasClass('btn-success')) {
          btn.click();
        }
      });
    }
  });

  $('body').on('click', '.staff-role-table :not(thead) tr', function(event) {
    $('.staff-role-table tr').removeClass('active');
    var row = $(this);
    row.addClass('active');
    var staffRoleId = row.attr('id');
    ftRest.getStaffRoleById(staffRoleId).then(function(sr) {
      staffRoleStaffRoleId.val(staffRoleId);
      staffRoleStaff.val(sr.staffId);
      staffRoleStaff.select2();

      staffRoleLocation.val(sr.location);
      staffRoleComments.val(sr.comments);
      staffRoleStartDate.val(ftUtil.simpleDate(sr.startDate));
      staffRoleEndDate.val(ftUtil.simpleDate(sr.endDate));

      staffRoleConfirmedTypes.val(sr.confirmedTypeId);
      staffRoleConfirmedTypes.select2();

      staffRoleActivityRoles.empty();
      staffRoleActivityRoles.append(
        new Option(sr.activityRoleProfileTypeDescription, sr.activityRoleId));
      staffRoleActivityRoles.val(sr.activityRoleId);
      staffRoleActivityRoles.select2();
    });
    $("html, body").animate({ scrollTop: 0 }, "fast");
    staffRoleForm.effect('highlight', 1600);
  });

  staffRoleClearButton.click(function(event) {
    staffRoleStaffRoleId.empty();
    staffRoleActivityRoles.empty();
    staffRoleStaff.select2('data', null);
    staffRoleConfirmedTypes.select2('data', null);
    removeActiveStaffRoleRow();
  });

  staffRoleSaveButton.click(function(event) {
    var staffRole = {
      "id": staffRoleStaffRoleId.val(),
      "startDate": ftUtil.ISODate(staffRoleStartDate.val()),
      "endDate": ftUtil.ISODate(staffRoleEndDate.val()),
      "location": staffRoleLocation.val(),
      "comments": staffRoleComments.val(),
      "activityRoleId": staffRoleActivityRoles.val(),
      "confirmedTypeId": staffRoleConfirmedTypes.val(),
      "staffId": staffRoleStaff.val()
    };
    console.log(staffRole);
    ftRest.saveOrUpdateStaffRole(staffRole);
  });

  planningPanelCollapseButton.click(function(event) {
    var button = $(this);
    var icon = button.children('span');
    if (button.hasClass('btn-danger')) {
      button.switchClass('btn-danger', 'btn-success', 0);
      icon.switchClass('glyphicon-arrow-up', 'glyphicon-arrow-down', 0);
    }
    else {
      button.switchClass('btn-success', 'btn-danger', 0);
      icon.switchClass('glyphicon-arrow-down', 'glyphicon-arrow-up', 0);
    }
    planningPanelBody.toggle({
      effect: 'highlight',
      duration: 150
    });
  });
  
  planningTablePanelCollapseButton.click(function(event) {
    var button = $(this);
    var icon = button.children('span');
    if (button.hasClass('btn-danger')) {
      button.switchClass('btn-danger', 'btn-success', 0);
      icon.switchClass('glyphicon-arrow-up', 'glyphicon-arrow-down', 0);
    }
    else {
      button.switchClass('btn-success', 'btn-danger', 0);
      icon.switchClass('glyphicon-arrow-down', 'glyphicon-arrow-up', 0);
    }
    planningTablePanelBody.toggle({
      effect: 'highlight',
      duration: 150
    });
  });  
});
