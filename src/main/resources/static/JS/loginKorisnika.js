/*
$(document).ready(function () {
    let uloga = localStorage.getItem("uloga");
    if (uloga == null){
        localStorage.setItem("uloga", "null");
    }
    if (uloga === "admin") {
        alert("Vec ste se prijavili.");
        window.location.href = "../index.html";
    } if (uloga=="clan"){
        alert("Vec ste se prijavili.");
        window.location.href = "../index.html";
    } if (uloga=="trener"){
        alert("Vec ste se prijavili.");
        window.location.href = "../index.html";
    }
});

$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['login'].username.value;
    let lozinka = document.forms['login'].password.value;
    let uloga = document.forms['login'].uloga.value;

    let login1 = {
        korisnickoIme,
        lozinka,
        uloga
    }

    console.log(login1);
    $.ajax({
        type: "POST",
        url: "http://loclahost:8080/api/"+uloga,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(login1),

        success: function (login1) {
            console.log(prijava);
            if(prijava.allert == true){
                console.log(uloga);
                alert(prijava.poruka);
            } else if(prijava.uloga == 2){
                console.log(uloga);
                localStorage.setItem("uloga", "clan");
                alert(prijava.poruka);
                window.location.href = "../pocetnaClan.html";
            } else if (prijava.uloga == 3){
                localStorage.setItem("uloga","trener");
                alert(prijava.poruka);
                window.location.href = "../pocetnaTrener.html";
            } else {
                localStorage.setItem("uloga","admin");
                alert(prijava.poruka);
                window.location.href = "../pocetnaAdmin.html";
            }
        }
    })
})

 */


$(document).on("submit", "#login", function (event) {
    event.preventDefault();


    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();


    let newClan = {
        korisnickoIme,
        lozinka
    }

    console.log(korisnickoIme);
    console.log(lozinka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/clan",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newClan),
        success: function (response) {
            console.log("SUCCESS:\n", response);

            localStorage.setItem('user', JSON.stringify(response));

            window.location.href = "profil";
        },
        error: function (response) {
            console.log("ERROR:\n", response);
            alert("Clan ne postoji");
        }
    });
});