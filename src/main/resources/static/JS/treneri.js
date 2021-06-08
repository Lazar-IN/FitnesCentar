$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trener.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trener.korisnickoIme + "</td>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.email + "</td>";

                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treneri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});