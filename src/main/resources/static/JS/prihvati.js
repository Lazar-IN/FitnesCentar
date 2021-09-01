$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener/" + trenerId,
        dataType: "json",
        success: function (res) {
            $('#korisnickoIme').val(res.korisnickoIme);
            $('#lozinka').val(res.lozinka);
            $('#ime').val(res.ime);
            $('#prezime').val(res.prezime);
            $('#kontaktTelefon').val(res.kontaktTelefon);
            $('#email').val(res.email);
            $('#datumRodjenja').val(res.datumRodjenja);
            $('').val(res.aktivan);

        },
        error: function (res) {
            console.log("ERROR:\n", res);
            window.alert("Greska(GET)")
        }
    });

    $(document).on("submit", "#prikaz", function (event) {
        event.preventDefault();
        let korisnickoIme = $("#korisnickoIme").val();
        let lozinka = $("#lozinka").val();
        let ime = $("#ime").val();
        let prezime = $("#prezime").val();
        let kontaktTelefon = $("#kontaktTelefon").val();
        let email = $("#email").val();
        let datumRodjenja = $("#datumRodjenja").val();
        let aktivan = true;

        let newTermin = {
            korisnickoIme,
            lozinka,
            ime,
            prezime,
            kontaktTelefon,
            email,
            datumRodjenja,
            aktivan
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/trener/" + trenerId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
            success: function (res) {
                alert("Profil je aktiviran!");
                window.location.href = "pocetnaAdmin.html?adminId=1" ;
            },
            error: function () {
                alert("Greška prilikom aktivacije(PUT)!");
            }
        });
    });

    $(document).on('click', ".cancelbtn", function (event) {
        //event.preventDefault();
        let urlParams = new URLSearchParams(window.location.search);
        let adminId = urlParams.get('adminId');
        //let urlParams1 = new URLSearchParams(window.location.search);
        //let terminId = urlParams1.get('terminId');
        //let trenerId = this.dataset.id;
        window.alert(trenerId);


        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/trener/" +trenerId,
            dataType: "json",
            success: function () {
                console.log("SUCCESS");
                $('[dataId="' + trenerId + '"]').parent().parent().remove();
                window.location.href = "pocetnaAdmin.html?admin=1"; //+ adminId;
                alert("Zahtev je odbijen!");

            },
            error: function () {
                alert("Greška!");
            }
        });
    });
});