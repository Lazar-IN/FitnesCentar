
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/clan",                   // URL na koji se šalju podaci
        //dataType: "json",                                           // tip povratne vrednosti
        //contentType: "application/json",                            // tip podataka koje šaljemo
        data: {
            korisnickoIme: $("#korisnickoIme").val(),
            lozinka: $("#lozinka").val()
        },
        success: function (response){
            var data = response;
            clanData = JSON.parse(data);
                console.log("id:"+clanData.id);
                console.log("korisnickoIme"+clanData.korisnickoIme);
                console.log("lozinka"+clanData.lozinka);
        },
        failure: function (data){
            alert('Server connection failed');
        },
        error: function (request, error){
            alert(error);
        }
    });






