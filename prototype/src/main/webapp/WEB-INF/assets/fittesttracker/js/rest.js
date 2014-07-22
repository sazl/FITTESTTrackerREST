var ftRest = (function (global, $) {
  "use strict";

  var _restURI = "rest/";
  var _URI = {};
  var _URI_basic = {
    confirmedType: "confirmedTypes",
    staffRole: "staffRoles"
  };
  $.each(_URI_basic, function(k, v) {
    _URI[k] = _restURI + v;
  });

  function _getConfirmedTypes() {
    return $.getJSON(_URI.confirmedType, function(data) {
      return data;
    });
  }

  function _getActivityByConfirmedType() {

  }
  
  return {
    getConfirmedTypes: _getConfirmedTypes
  };
}(window || this, jQuery));
