$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesscentar",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let fitnesscentar of response) {
                let row = "<tr>";
                row += "<td>" + fitnesscentar.id + "</td>";
                row += "<td>" + fitnesscentar.naziv + "</td>";
                row += "<td>" + fitnesscentar.adresa + "</td>";
                row += "<td>" + fitnesscentar.brojTelefonaCentrale + "</td>";
                row += "<td>" + fitnesscentar.email + "</td>";

                row += "</tr>";

                $('#lokacije').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
            alert("Greska pri dobavljanju");
        }
    });
});