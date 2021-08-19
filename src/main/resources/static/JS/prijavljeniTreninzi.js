$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let terminId = urlParams1.get('terminId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" + clanId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<th>" + res[i].tipTreninga + "</th>";
                row += "<th>" + res[i].datumIVreme + "</th>";
                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">Otkazi</button>";
                row += "<td>" + btn + "</td>";
                btn = "<button class='btnOdradjen' data-id=" + res[i].id + ">Odradjen</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let treningId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" + treningId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[dataId="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška!");
        }
    });
});

$(document).on('click', '.btnOdradjen', function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let terminId = urlParams1.get('terminId');
    let urlParams2 = new URLSearchParams(window.location.search);
    let treningId = urlParams2.get('treningId');
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/odradjeniTrening/zaTrening/" + treningId + "/termin/" + terminId + "/clan/" + clanId,
        dataType: "json",
        success: function (res) {
            alert("Termin " + res.id + " je uspešno prijavljen!");
            window.location.href = "odradjeniTreninzi.html?clanId=" + clanId;
        },
        error: function () {
            alert("Greška!");
        }
    });
    let prijavljeniId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/odradjeniTrening/zaClana/" + prijavljeniId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[dataId="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška!");
        }
    });
});