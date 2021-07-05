//prikaz termina
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {
                let row = "<tr>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.tip + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.datum + "</td>";

                row += "</tr>";

                $('#termin').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});