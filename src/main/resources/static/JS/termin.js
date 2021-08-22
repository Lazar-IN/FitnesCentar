$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin/zaTrening/" +treningId ,
        dataType: "json",
        success: function (response) {
            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                row += "<th>" + response[i].datumIVreme + "</th>";
                row += "<td>" + response[i].cena + "</td>";
                let btn = "<button class='btnPrijavi' data-id=" + response[i].id + ">Prijavi se</button>";
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

$(document).on('click', '.btnPrijavi', function () {
    let terminId = this.dataset.id;
    let urlParams1 = new URLSearchParams(window.location.search);
    let clanId = urlParams1.get('clanId');
    let urlParams2 = new URLSearchParams(window.location.search);
    let treningId = urlParams2.get('treningId');
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" + clanId + "/termin/" + terminId,
        dataType: "json",
        success: function (response) {
            alert("Termin " + response.id + " je prijavljen");
            window.location.href = "http://localhost:8080/pocetnaClan.html?clanId=" + clanId ;
        },
        error: function () {
            alert("Greška prilikom prijave");
        }
    });
});

function sortTable() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("termini");
    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

$(document).ready(function(){
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#termini tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

///////////////////////////////////////////////////////////////////////
/*
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

 */
