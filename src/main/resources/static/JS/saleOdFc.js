$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sala",
        dataType: "json",
        success: function (respond) {

            //let fitnesId = this.dataset.fitneId;
            var currentUrl = window.location.href;
            let params = (new URL(currentUrl)).searchParams;
            fitnesId = params.get('fitnesId') // broj

            for (i = 0; i < respond.length; i++) {
                if(currentUrl === "http://localhost:8080/salaOdFC.html?fitnesId="+fitnesId){
                    let row = "<tr>";
                    row += "<td>" + respond[i].id + "</td>";
                    row += "<td>" + respond[i].kapacitet + "</td>";
                    row += "<td>" + respond[i].oznaka + "</td>";
                    let btn = "<button class='btnIzmeni' data-id=" + respond[i].id + ">Izmeni</button>";
                    row += "<td>" + btn + "</td>";
                    btn = "<button class='btnDelete' data-id=" + respond[i].id + ">Obrisi</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";

                    $('#sale').append(row);
                }else{

                }
            }
        },
        error: function (respond) {
            console.log("ERROR:\n", respond);
            alert("Greska pri ucitavanje sala!");
        }
    });
});
$(document).on('click', '.btnDelete', function () {
    let salaId = this.dataset.id;

    //window.alert(salaId);
    //window.alert("http://localhost:8080/api/sala/" + salaId);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/sala/" + salaId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + salaId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja!");
        }
    });
});
$(document).on('click', '.btnIzmeni', function () {
    let salaId = this.dataset.id;
    window.location.href = "izmeniSalu.html?salaId=" + salaId;
});
