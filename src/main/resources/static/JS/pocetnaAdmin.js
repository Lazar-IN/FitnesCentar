$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let adminId = urlParams.get('adminId');
    $('#dodaj4').attr('href', 'odobravanjeZahtevaZaRegistracijuTrenera.html?adminId=' + adminId);
});