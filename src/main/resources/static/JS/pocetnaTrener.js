$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);
    //sessionStorage.setItem('trenerId', JSON.stringify(trenerId));

    $('#tren').attr('href', 'treninziTrener.html?trenerId=' + trenerId);
});

