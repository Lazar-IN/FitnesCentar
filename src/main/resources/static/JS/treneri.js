$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + employee.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + employee.korisnickoIme + "</td>";
                row += "<td>" + employee.ime + "</td>";
                row += "<td>" + employee.prezime + "</td>";
                row += "<td>" + employee.email + "</td>";

                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treners').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});