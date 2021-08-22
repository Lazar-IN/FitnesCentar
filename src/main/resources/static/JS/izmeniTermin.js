$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let terminId = urlParams.get('terminId');
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin/" + terminId,
        dataType: "json",
        success: function (res) {
            $('#cena').val(res.cena);
            $('#datumIVreme').val(res.datum_vreme);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajTerminForm", function (event) {
        event.preventDefault();

        let cena = $("#cena").val();
        let datumIVreme = $("#datumIVreme").val();

        let newTermin = {
            cena,
            datumIVreme
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/termin/" + terminId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
            success: function (res) {

                alert("Termin " + res.id + " je uspešno ispravljen!");
                window.location.href ="http://localhost:8080/pocetnaTrener.html?trenerId=" + trenerId;
            },
            error: function () {
                alert("Greška prilikom ispravljanja termina!");
            }
        });
    });
});