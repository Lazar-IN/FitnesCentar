$(document).on("submit", "#dodajSaluForm", function (event) {
    event.preventDefault();

    //let urlParams = new URLSearchParams(window.location.search);

    //let salaId = urlParams.get('salaId');


    let kapacitet = $("#kapacitet").val();
    let oznaka = $("#oznaka").val();

    let newSala = {
        kapacitet,
        oznaka
    }
    //window.alert(salaId);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sala/zaFitnessCentar/1",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (res) {
            console.log(res);

            alert("Sala " + res.id + " je uspešno kreirana!");
            window.location.href = "http://localhost:8080/pocetnaAdmin.html?adminId=1";
        },
        error: function () {
            alert("Greška prilikom dodavanja sale!");
        }
    });
});