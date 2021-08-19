$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let naziv = document.forms['dodavanjeFitnessCentra'].naziv.value;
    let adresa = document.forms['dodavanjeFitnessCentra'].adresa.value;
    let brojTelefonaCentrale = document.forms['dodavanjeFitnessCentra'].brojTelefonaCentrale.value;
    let email = document.forms['dodavanjeFitnessCentra'].email.value;

    let newFitnessCentar = {
        naziv,
        adresa,
        brojTelefonaCentrale,
        email
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fitnesscentar",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCentar),
        success: function (response) {
            console.log(response);

            alert("Fitnes centar " + response.naziv + " je uspešno kreiran!");
            //window.location.href = "index.html";
            //window.location.href = "pocetnaAdmin.html?adminId="+ adminId;
        },
        error: function () {
            alert("Greška pri dodavanju fitness centra!");
        }
    });
});

function goBack() {
    window.history.back();
}