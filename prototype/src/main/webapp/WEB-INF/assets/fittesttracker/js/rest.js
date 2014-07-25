
var ftRest = (function (global, $) {
  "use strict";
  var _restURI = "/fittesttracker/rest/";
  var _URI = {};
  var _entityURI = {
    activities     : 'activities',
    activityTypes  : 'activityTypes',
    activityRoles  : 'activityRoles',
    confirmedTypes : 'confirmedTypes',
    profileTypes   : 'profileTypes',
    staff          : 'staff',
    staffTypes     : 'staffTypes',
    staffRoles     : 'staffRoles',
    countries      : 'countries',
    languages      : 'languages'
  };
  $.each(_entityURI, function(k, v) {
    _URI[k] = _restURI + v;
  });


  function _findAll(entity) {
    return $.getJSON(_URI[entity]).then(function(data) {
      return data._embedded[entity];
    });
  }

  function _findAllFunc(entity) {
    return function () { return _findAll(entity); };
  }
  
  function _findById(entity, id) {
    var uri = _URI[entity] + '/search/findById?id=' + id;
    return $.getJSON(uri).then(function(data) {
      return data._embedded[entity][0];
    });
  }

  function _findByIdFunc(entity) {
    return function (id) { return _findById(entity, id); };
  }

  function _getActivitiesByConfirmedTypeId(confirmedTypeId) {
    var uri = _URI.activities + '/search/findByConfirmedType_Id?confirmedTypeId=' + confirmedTypeId;
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? [] : data._embedded['activities'];
    });
  }

  function _getActivityTypeByActivityId(activityId) {
    var uri = _URI.activityTypes + '/search/findByActivities_Id?activityId=' + activityId;
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? [] : data._embedded['activityTypes'][0];
    });
  }

  function _getActivityRolesByActivityId(activityId) {
    var uri = _URI.activities + '/' + activityId + '/activityRoles';
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? [] : data._embedded['activityRoles'];
    });
  }

  function _getProfileTypeByActivityRoleId(activityRoleId) {
    var uri = _URI.profileTypes + '/search/findByActivityRole_Id?activityRoleId=' + activityRoleId;
    
  }

  function _getStaffRolesByActivityRoleId(activityRoleId) {
    var uri = _URI.activityRoles + '/' + activityRoleId + '/staffRoles';
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? [] : data._embedded['staffRoles'];
    });
  }

  function _getStaffByStaffRoleId(staffRoleId) {
    var uri = _URI.staff + '/search/findByStaffRoles_Id?staffRoleId=' + staffRoleId;
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? null : data._embedded['staff'][0];
    });
  }

  function _getCountriesByActivityId(activityId) {
    var uri = _URI.activities + '/' + activityId + '/countries';
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? [] : data._embedded['countries'];
    });
  }

  function _getConfirmedTypeByActivityId(activityId) {
    var uri = _URI.confirmedTypes + '/search/findByActivities_Id?activityId=' + activityId;
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? null : data._embedded['confirmedTypes'][0];
    });
  }

  function _getConfirmedTypeByStaffRoleId(staffRoleId) {
    var uri = _URI.confirmedTypes + '/search/findByStaffRoles_Id?staffRoleId=' + staffRoleId;
    return $.getJSON(uri).then(function(data) {
      return $.isEmptyObject(data) ? null : data._embedded['confirmedTypes'][0];
    });
  }
  
  return {
    getConfirmedTypes: _findAllFunc('confirmedTypes'),
    getConfirmedTypeById: _findByIdFunc('confirmedTypes'),
    getConfirmedTypeByActivityId: _getConfirmedTypeByActivityId,
    getConfirmedTypeByStaffRoleId: _getConfirmedTypeByStaffRoleId,
    
    getActivities: _findAllFunc('activities'),
    getActivityById: _findByIdFunc('activities'),
    getActivitiesByConfirmedTypeId: _getActivitiesByConfirmedTypeId,

    getActivityRoles: _findAllFunc('activityRoles'),
    getActivityRoleById: _findByIdFunc('activityRoles'),
    getActivityRolesByActivityId: _getActivityRolesByActivityId,
    
    getActivityTypes: _findAllFunc('activityTypes'),
    getActivityTypeById: _findByIdFunc('activityTypes'),
    getActivityTypeByActivityId: _getActivityTypeByActivityId,

    getProfileTypes: _findAllFunc('profileTypes'),
    getProfileTypeById: _findByIdFunc('profileTypes'),
    getProfileTypeByActivityRoleId: _getProfileTypeByActivityRoleId,

    getStaff: _findAllFunc('staff'),
    getStaffById: _findByIdFunc('staff'),
    getStaffByStaffRoleId: _getStaffByStaffRoleId,

    getStaffTypes: _findAllFunc('staffTypes'),
    getStaffTypeById: _findByIdFunc('staffTypes'),
    
    getStaffRoles: _findAllFunc('staffRoles'),
    getStaffRoleById: _findByIdFunc('staffRoles'),
    getStaffRolesByActivityRoleId: _getStaffRolesByActivityRoleId,
    
    getCountries: _findAllFunc('countries'),
    getCountryById: _findByIdFunc('countries'),
    getCountriesByActivityId: _getCountriesByActivityId
  };
}(window || this, jQuery));
