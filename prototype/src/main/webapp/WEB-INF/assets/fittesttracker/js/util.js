var ftUtil = (function (global, $) {

  function _colorLabel(color, text) {
    return $('<label>')
      .addClass('label label-default')
      .css('background-color', '#' + color)
      .text(text);
  }

  function _simpleDate(date) {
    if (date === null) { return ''; }
    else { return moment(date).format('DD/MM/YYYY'); }
  }

  return {
    colorLabel: _colorLabel,
    simpleDate: _simpleDate
  };  
}(window || this, jQuery));
