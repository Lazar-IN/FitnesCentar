$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $('#dodaj2').attr('href', 'prijavljeniTreninzi.html?clanId=' + clanId);
    $('#dodaj3').attr('href', 'odradjeniTreninzi.html?clanId=' + clanId);
    $('#dodaj4').attr('href', 'oceniTreninge.html?clanId=' + clanId);
    $('#dodaj5').attr('href', 'pregledProfila.html?clanId=' + clanId);
    $('#dodaj6').attr('href', 'treninzi.html?clanId=' + clanId);
});