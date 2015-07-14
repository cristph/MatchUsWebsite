$(function () {
  $('.settings-left li').click(function (e) {
    $('.settings-left li').removeClass('active');
    this.classList.add('active');
  });
});
