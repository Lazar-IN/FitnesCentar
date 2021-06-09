$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['registracija'].korisnickoIme.value;
    let lozinka = document.forms['registracija'].password.value;

    let korisnik = {
        korisnickoIme,
        lozinka,
    }

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/clan",                   // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newClan),                          // u body-ju šaljemo novog clana (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);

            localStorage.setItem("korisnickoIme", data["korisnickoIme"]);
            localStorage.setItem("lozinka", data["lozinka"]);
            localStorage.setItem("uloga", data["uloga"]);

            //alert("Korisnik " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            //window.location.href = "index.html";
            if (localStorage.getItem('uloga')==0){
                let reqUrl = new URL('http://localhost:8011/api/admin');
                reqUrl.searchParams.append('id', localStorage.getItem('id'));
                reqUrl.searchParams.append('uloga', localStorage.getItem('uloga'));

            } else if(localStorage.getItem('uloga')==1) {
                let reqUrl = new URL('http://localhost:8011/api/clan');
                reqUrl.searchParams.append('id', localStorage.getItem('id'));
                reqUrl.searchParams.append('uloga', localStorage.getItem('uloga'));
            } else{
                let reqUrl = new URL('http://localhost:8011/api/trener');
                reqUrl.searchParams.append('id', localStorage.getItem('id'));
                reqUrl.searchParams.append('uloga', localStorage.getItem('uloga'));
            }

        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });






});