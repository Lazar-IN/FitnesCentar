// Kreiranje novog zaposlenog
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
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/fitnesscentar",                   // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newFitnessCentar),                          // u body-ju šaljemo novog clana (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);

            alert("Fitnes centar " + response.naziv + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "index.html";                // redirektujemo ga na index.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});