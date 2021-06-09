//prikaz svih trenera
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {
                let row = "<tr>";
                row += "<td>" + trener.id + "</td>";
                row += "<td>" + trener.korisnickoIme + "</td>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.email + "</td>";

                row += "</tr>";

                $('#treneri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});