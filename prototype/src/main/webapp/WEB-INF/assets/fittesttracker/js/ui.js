var ftUI = (function (global, $) {
  var _appURI = '/fittesttracker/';
  function _deleteEntityDialog(entity, id) {
    var uri = _appURI + 'country/' + id + '/delete';
    var name = ftUtil.camelCaseToReadable(entity);
    alertify.confirm('Confirm Deletion of ' + name, function(e) {
      if (e) {
        
      }
      else {
        
      }
    });
  }
  
  return {
    deleteEntityDialog: _deleteEntityDialog
  };
}(window || this, jQuery));
