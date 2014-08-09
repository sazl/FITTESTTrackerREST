var ftUI = (function (global, $) {
  var _appURI = '/fittesttracker/';
  function _deleteEntityDialog(entity, id) {
    var uri = _appURI + entity + '/' + id + '/delete';
    var name = ftUtil.linkToReadable(entity);
    alertify.confirm('Confirm Deletion of ' + name, function(e) {
      if (e) {
        $.ajax({
          url: uri,
          type: 'POST'
        }).fail(function() {
          alertify.alert('Failed to delete ' + name);
        }).success(function() {
          window.location.reload();
          alertify.success('Deleted ' + name);
        });
      }
      else {
        
      }
    });
  }
  
  return {
    deleteEntityDialog: _deleteEntityDialog
  };
}(window || this, jQuery));
