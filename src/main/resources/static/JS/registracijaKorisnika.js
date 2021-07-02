$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['registracija'].korisnickoIme.value;
    let lozinka = document.forms['registracija'].password.value;
    let ime = document.forms['registracija'].ime.value;
    let prezime = document.forms['registracija'].prezime.value;
    let kontaktTelefon = document.forms['registracija'].kontaktTelefon.value;
    let email = document.forms['registracija'].email.value;
    let datumRodjenja = document.forms['registracija'].datumRodjenja.value;

    let newClan = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        email,
        datumRodjenja
        //uloga: 1,
        //aktivan: false
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/clan",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newClan),
        success: function (response) {
            console.log(response);

            alert("Korisnik " + response.korisnickoIme + " je uspešno kreiran!");
            window.location.href = "index.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});