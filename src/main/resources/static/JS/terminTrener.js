$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin/zaTrening/"+treningId ,
        dataType: "json",
        success: function (response) {
            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                row += "<th>" + response[i].datumIVreme + "</th>";
                row += "<td>" + response[i].cena + "</td>";
                let btn = "<button class='btnIzmeni' data-id=" + response[i].id + ">Izmeni</button>";
                row += "<td>" + btn + "</td>"
                btn = "<button class='btnDelete' data-id=" + response[i].id + ">Obrisi</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let treningId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/termini/zaTrening/" + treningId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja termina!");
        }
    });
});

$(document).on('click', '.btnIzmeni', function () {
    let terminId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);
    let urlParams1 = new URLSearchParams(window.location.search);
    let treningId = urlParams1.get('treningId');
    window.location.href = "izmeniTermin.html?terminId=" + terminId + "?trenerId=" + trenerId + "&treningId=" + treningId;
});