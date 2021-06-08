// Prikaz svih treninga
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening",
        dataType: "json",
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trening of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trening.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.nivoTreninga + "</td>";
                row += "<td>" + trening.trajanjeUNedeljama + "</td>";
                row += "<td>" + trening.danaUNedelji + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";

                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treninzi').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});