//prikaz svih trenera
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",
        success: function (respond) {
            console.log("SUCCESS:\n", respond);

            for (i = 0; i < respond.length; i++) {
                let row = "<tr>";
                if (respond[i].aktivan == true){
                    row += "<td>" + respond[i].id + "</td>";
                    row += "<td>" + respond[i].korisnickoIme + "</td>";
                    row += "<td>" + respond[i].ime + "</td>";
                    row += "<td>" + respond[i].prezime + "</td>";
                    row += "<td>" + respond[i].email + "</td>";
                    let btn = "<button class='btnDelete' data-id=" + respond[i].id + ">Obrisi</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";
                }else {
                }
                $('#treneri').append(row);
            }
        },
        error: function (respond) {
            console.log("ERROR:\n", respond);
            alert("Greska pri ucitavanje trenera!");
        }
    });
});


$(document).on('click', '.btnDelete', function () {
    let fitnesCentarId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/trener/" + fitnesCentarId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitnesCentarId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja trenera!");
        }
    });
});