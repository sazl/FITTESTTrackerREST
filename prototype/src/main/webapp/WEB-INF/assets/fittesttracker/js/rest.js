var ftRest = (function (global, $) {
  "use strict";
  var _restURI = "/fittesttracker/rest/hal/";
  var _Resource = new Hyperagent.Resource(_restURI);

  function _getConfirmedTypes() {
    return _Resource.fetch().then(function (root) {
        return root.links['confirmedTypes'].fetch();
      }).then(function (confirmedTypes) {
        return confirmedTypes.embedded['confirmedTypes'].map(function (ct) {
          return {
            confirmedType: ct.props.confirmedType,
            confirmedColorCode: ct.props.confirmedColorCode
          };
        });
      });
  }

  function _getActivitiesByConfirmedTypeId(confirmedType) {
    _getConfirmedTypes().then(function(confirmedTypes) {
      console.log(confirmedTypes);
    });
  }
  
  return {
    getConfirmedTypes: _getConfirmedTypes,
    getActivitiesByConfirmedTypeId: _getActivitiesByConfirmedTypeId
  };
}(window || this, jQuery));
