$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesscentar",
        dataType: "json",
        success: function (respond) {

            for (i = 0; i < respond.length; i++) {
                let row = "<tr>";
                row += "<td>" + respond[i].id + "</td>";
                row += "<td>" + respond[i].naziv + "</td>";
                row += "<td>" + respond[i].adresa + "</td>";
                row += "<td>" + respond[i].email + "</td>";
                row += "<td>" + respond[i].brojTelefonaCentrale + "</td>";
                let btn = "<button class='btnSala' data-id=" + respond[i].id + ">Sale</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#fitnesCentri').append(row);
            }
        },
        error: function (respond) {
            console.log("ERROR:\n", respond);
            alert("Greska pri ucitavanje fitnes centara!");
        }
    });
});

$(document).on('click', '.btnSala', function () {
    let salaId = this.dataset.id;
    let fitnesId = this.dataset.id;
    window.location.href = "salaOdFC.html?fitnesId=" + fitnesId;
});
