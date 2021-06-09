// Kreiranje novog zaposlenog
$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['registracija'].korisnickoIme.value;
    let lozinka = document.forms['registracija'].password.value;
    let ime = document.forms['registracija'].ime.value;
    let prezime = document.forms['registracija'].prezime.value;
    let kontaktTelefon = document.forms['registracija'].kontaktTelefon.value;
    let email = document.forms['registracija'].email.value;
    let datumRodjena = $("#datumRodjena").val();
    //let datumRodjenja = document.forms['registracija'].datumRodjenja.value;

    //let korisnickoIme = $("#korisnickoIme").val();
    //let password = $("#password").val();
    //let prezime = $("#prezime").val();
    //let kontaktTelefon = $("#kontaktTelefon").val();
    //let email = $("#email").val();
    //let datumRodjena = $("#datumRodjena").val();

    // kreiramo objekat clan
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newClan = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        email,
        datumRodjena
        //uloga: 1,
        //aktivan: false
    }

    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/clan",                   // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newClan),                          // u body-ju šaljemo novog clana (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);

            //sessionStorage.setItem("id", data["id"]);
            //sessionStorage.setItem("uloga", data["uloga"]);

            alert("Korisnik " + response.korisnickoIme + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "index.html";                // redirektujemo ga na index.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});