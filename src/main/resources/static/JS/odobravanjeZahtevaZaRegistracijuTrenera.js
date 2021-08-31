//prikaz svih trenera
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                if(response[i].aktivan == null){
                    row += "<td>" + response[i].id + "</td>";
                    row += "<td>" + response[i].korisnickoIme + "</td>";
                    row += "<td>" + response[i].ime + "</td>";
                    row += "<td>" + response[i].prezime + "</td>";
                    row += "<td>" + response[i].email + "</td>";
                    row += "<td>" + response[i].datumRodjenja + "</td>";
                    let btn = "<button class='btnPrihvati' data-id=" + response[i].id + ">Vise</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";
                } else {
                }


                $('#treneri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
            alert("Greska pri dobavljanju");
        }
    });
});
$(document).on('click', '.btnPrihvati', function () {
    let urlParams = new URLSearchParams(window.location.search);
    let adminId = urlParams.get('adminId');
    //let urlParams1 = new URLSearchParams(window.location.search);
    //let terminId = urlParams1.get('terminId');
    let trenerId = this.dataset.id;
    //window.alert(trenerId);
    window.location.href= "prihvati.html?trenerId="+trenerId;


});
/*

$(document).on('click', '.btnOdbij', function () {
    let urlParams = new URLSearchParams(window.location.search);
    let adminId = urlParams.get('clanId');
    //let urlParams1 = new URLSearchParams(window.location.search);
    //let terminId = urlParams1.get('terminId');
    let trenerId = this.dataset.id;


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/trener/" +trenerId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[dataId="' + trenerId + '"]').parent().parent().remove();
            window.location.href = "pocetnaAdmin.html?admin=" + adminId;

        },
        error: function () {
            alert("Greška!");
        }
    });
});

 */
