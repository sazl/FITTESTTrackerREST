jQuery(document).ready(function($) {
  var active_page = window.location.pathname.split('/')[2];
  if (active_page) {
    $('#sidebar li.active').removeClass('active');
    $('#sidebar a[href$="' + active_page + '"]').parents('li:first').addClass('active');
  }
  
  var hash = window.location.hash;
  hash && $('ul.nav a[href="' + hash + '"]').tab('show');

  $('.nav-tabs a').click(function (e) {
    $(this).tab('show');
    var scrollmem = $('body').scrollTop();
    window.location.hash = this.hash;
    $('html,body').scrollTop(scrollmem);
    e.preventDefault();
  });

  $('select').select2();
  $('.default-dataTable').dataTable();
});
