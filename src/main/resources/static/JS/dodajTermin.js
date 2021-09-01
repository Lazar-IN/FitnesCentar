function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}
$(document).on("submit", "#dodajTerminForm", function (event) {
    event.preventDefault();
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');

    let datumIVreme = $("#datumIVreme").val();
    let cena = $("#cena").val();

    let newTermin = {
        datumIVreme,
        cena
    }

    let trenerId = getParameterByName('trenerId');

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termin/zaTrening/" + treningId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (res) {
            alert("Termin " + res.id + " je uspešno kreiran!");
            window.location.href = "pocetnaTrener.html?&trenerId=" + trenerId;
        },
        error: function () {
            alert("Greška prilikom dodavanja termina!");
        }
    });
});



