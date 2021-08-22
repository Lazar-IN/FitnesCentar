$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    window.alert(trenerId);
    //sessionStorage.setItem('trenerId');
    //window.alert(sessionStorage);
    sessionStorage.setItem('trenerId', JSON.stringify(trenerId));
    //window.alert(sessionStorage.getItem('trenerId'));

    $('#tren').attr('href', 'treninziTrener.html?trenerId=' + trenerId);
});

