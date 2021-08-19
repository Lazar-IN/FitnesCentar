$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let salaId = urlParams.get('salaId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sala/" + salaId,
        dataType: "json",
        success: function (res) {
            $('#fitnesCentar').val(res.idFC);
            $('#kapacitet').val(res.kapacitet);
            $('#oznaka').val(res.oznaka);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajSaluForm", function (event) {
        event.preventDefault();
        let idFC = $("#fitnesCentar").val();
        let kapacitet = $("#kapacitet").val();
        let oznaka = $("#oznaka").val();

        let newSala = {
            idFC,
            kapacitet,
            oznaka
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/sala/" + salaId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newSala),
            success: function (res) {
                alert("Sala " + res.id + " je uspešno ispravljena!");
                window.location.href = "http://localhost:8080/pocetnaAdmin.html";
            },
            error: function () {
                alert("Greška prilikom izmene sale!");
            }
        });
    });
});