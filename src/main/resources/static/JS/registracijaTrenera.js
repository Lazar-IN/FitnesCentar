$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['registracija'].korisnickoIme.value;
    let lozinka = document.forms['registracija'].password.value;
    let ime = document.forms['registracija'].ime.value;
    let prezime = document.forms['registracija'].prezime.value;
    let kontaktTelefon = document.forms['registracija'].kontaktTelefon.value;
    let email = document.forms['registracija'].email.value;
    let datumRodjena = $("#datumRodjena").val();

    let newTrener = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        email,
        datumRodjena
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/trener",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrener),
        success: function (response) {
            console.log(response);

            alert("Korisnik " + response.id + " je uspešno kreiran!");
            window.location.href = "index.html";                // redirektujemo ga na index.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});