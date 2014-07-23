/*
 FITTEST Tracker REST API
 */

var ftRest = (function (global, $) {
  "use strict";
  var _restURI = "/fittesttracker/rest/hal/";
  var _Resource = new Hyperagent.Resource(_restURI);

  function __resourceId(resource) {
    var link = resource.url();
    return parseInt(link.split('/').splice(-1)[0]);
  }

  function __getEmbeddedResource(embedded, promise) {
    return promise.then(function(x) {
      return x.embedded[embedded];
    });
  }

  function __getLinkedResource(link, promise) {
    return promise.then(function(x) {
      return x.links[link].fetch();
    });
  }

  function __getLinkedEmbeddedResource(resource, promise) {
    return __getEmbeddedResource(
      resource,
      __getLinkedResource(resource, promise)
    );
  }

  function __logPromiseFetched(promise) {
    promise.then(function(x) {
      console.log(x.fetch());
    });
  }

  function __logFetchedPromise(promise) {
    promise.fetch().then(function(x) {
      console.log(x);
    });
  }
  
  function __logPromise(promise) {
    promise.then(function(x) {
      console.log(x);
    });
  }
  
  function _getConfirmedTypes() {
    return _Resource.fetch().then(function (root) {
      return root.links['confirmedTypes'].fetch();
    }).then(function (confirmedTypes) {
      return confirmedTypes.embedded['confirmedTypes'].map(function (ct) {
        return {
          id: __resourceId(ct),
          confirmedType: ct.props.confirmedType,
          confirmedColorCode: ct.props.confirmedColorCode
        };
      });
    });
  }

  function _getActivities() {
    return _Resource.fetch().then(function (root) {
      return root.links['activities'].fetch();
    }).then(function (activities) {
      return activities.embedded['activities'].map(function (act) {
        return {
          id: __resourceId(act),
          description: act.props.description,
          etcServiceMap: act.props.etcServiceMap
        };
      });
    });
  }

  function _getActivityById(activityId) {
    return _Resource.fetch().then(function (root) {
      return root.links['activities'].fetch();
    }).then(function(activities) {
      return activities.links['search'].fetch();
    }).then(function(search) {
      return search.link(
        'findById',{ id: activityId }).fetch();
    }).then(function(activities) {
      var acts = activities.embedded['activities'];
      if (acts == undefined) { return null; }
      return acts.map(function(act) {
        return {
          id: __resourceId(act),
          description: act.props.description,
          etcServiceMap: act.props.etcServiceMap
        };
      })[0];
    });
  }

  function _getActivityPromiseById(activityId) {
    return _Resource.fetch().then(function (root) {
      return root.links['activities'].fetch();
    }).then(function(activities) {
      return activities.links['search'].fetch();
    }).then(function(search) {
      return search.link(
        'findById',{ id: activityId }).fetch();
    }).then(function(activities) {
      return activities.embedded['activities'][0];
    });
  }
  
  function _getActivitiesByConfirmedType(confirmedType) {
    return _Resource.fetch().then(function (root) {
      return root.links['activities'].fetch();
    }).then(function(activities) {
      return activities.links['search'].fetch();
    }).then(function(search) {
      return search.link(
        'findByConfirmedType_ConfirmedType',{ confirmedType: confirmedType }).fetch();
    }).then(function(activities) {
      var acts = activities.embedded['activities'];
      if (acts == undefined) { return []; }
      return acts.map(function(act) {
        return {
          id: __resourceId(act),
          description: act.props.description,
          etcServiceMap: act.props.etcServiceMap
        };
      });
    });
  }
  
  return {
    resource: _Resource,
    getEmbeddedResource: __getEmbeddedResource,
    getLinkedResource: __getLinkedResource,
    getLinkedEmbeddedResource: __getLinkedEmbeddedResource,
    
    logPromise: __logPromise,
    logFetchedPromise: __logFetchedPromise,
    logPromiseFetched: __logPromiseFetched,
    
    getConfirmedTypes: _getConfirmedTypes,
    getActivityById: _getActivityById,
    getActivityPromiseById: _getActivityPromiseById,
    getActivities: _getActivities,
    getActivitiesByConfirmedType: _getActivitiesByConfirmedType
  };
}(window || this, jQuery));
