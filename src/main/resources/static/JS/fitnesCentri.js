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
                btn = "<button class='btnDelete' data-id=" + respond[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnIzmeni' data-id=" + respond[i].id + ">Izmeni</button>";
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

$(document).on('click', '.btnDelete', function () {
    let fitnesCentarId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnesscentar/" + fitnesCentarId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitnesCentarId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja fitnes centra!");
        }
    });
});

$(document).on('click', '.btnSala', function () {
    let salaId = this.dataset.id;
    let fitnesId = this.dataset.id;
    window.location.href = "salaOdFC.html?fitnesId=" + fitnesId;
});

$(document).on('click', '.btnIzmeni', function () {
    let fitnesId = this.dataset.id;
    window.location.href = "izmeniFC.html?fitnesId=" + fitnesId;
});