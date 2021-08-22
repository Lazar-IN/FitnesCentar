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
                row += "<td>" + res[i].id + "</td>";
                //row += "<td>" + res[i].termin.id + "</td>";
                //row += "<td>" + res[i].termin.trening.id + "</td>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].nivoTreninga + "</td>";
                row += "<td>" + res[i].danaUNedelji + "</td>";
                row += "<td>" + res[i].trajanjeUNedeljama + "</td>";
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
            window.alert("Greska  u prikazu");
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    //let urlParams1 = new URLSearchParams(window.location.search);
    //let terminId = urlParams1.get('terminId');
    let treningId = this.dataset.id;


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" +treningId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[dataId="' + treningId + '"]').parent().parent().remove();
            window.location.href = "http://localhost:8080/pocetnaClan.html?clanId=" + clanId;

        },
        error: function () {
            alert("Greška u brisanju!");
        }
    });
});

$(document).on('click', '.btnOdradjen', function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    //let urlParams1 = new URLSearchParams(window.location.search);
    //let terminId = urlParams1.get('terminId');
    //let urlParams2 = new URLSearchParams(window.location.search);
    //let treningId = urlParams2.get('treningId');
    let treningId = this.dataset.id;
    let terminId = this.dataset.id;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/odradjeniTrening/odClana/" + clanId + "/termin/" + terminId ,
        dataType: "json",
        success: function (res) {
            alert("Termin  je uspešno odradjen!");
            window.location.href = "http://localhost:8080/pocetnaClan.html?clanId=" + clanId;
        },
        error: function () {
            alert("Greška u POST-ovanju u odradjeniTrening!");
        }
    });
    let prijavljeniId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" + prijavljeniId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[dataId="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška u brisanju sa prijavljeniTreing!");
        }
    });
});