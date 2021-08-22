$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let fitnesId = urlParams.get('fitnesId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesscentar/" + fitnesId,
        dataType: "json",
        success: function (res) {
            $('#naziv').val(res.naziv);
            $('#adresa').val(res.adresa);
            $('#brojTelefonaCentrale').val(res.brojTelefonaCentrale);
            $('#email').val(res.email);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#izmenaFitnessCentra", function (event) {
        event.preventDefault();
        let naziv = $("#naziv").val();
        let adresa = $("#adresa").val();
        let brojTelefonaCentrale = $("#brojTelefonaCentrale").val();
        let email = $("#email").val();

        let newFitnesCentar = {
            naziv,
            adresa,
            brojTelefonaCentrale,
            email

        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/fitnesscentar/" + fitnesId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newFitnesCentar),
            success: function (res) {
                alert("Fitnes centar " + res.naziv + " je uspešno ispravljen!");
                window.location.href = "http://localhost:8080/pocetnaAdmin.html?adminId=1";
            },
            error: function () {
                alert("Greška prilikom izmene fitness centra!");
            }
        });
    });
});