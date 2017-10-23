var booking;

$(document).ready(function() {
    booking = JSON.parse(localStorage.getItem("booking"));
    document.getElementById("navn").innerHTML = booking['bookingId'];
    document.getElementById("antGjester").innerHTML = booking['antallGjester'];
    document.getElementById("date").innerHTML = new Date(booking['bookingsTidspunkt']).toLocaleString();
    if(booking['forrett'].localeCompare("") == 0){
        document.getElementById("forrett").innerHTML = "Ikke valgt";
    } else{
        document.getElementById("forrett").innerHTML = booking['forrett'];
    }
    if(booking['hovedrett'].localeCompare("") == 0) {
        document.getElementById("hovedrett").innerHTML = "Ikke valgt";
    } else{
        document.getElementById("hovedrett").innerHTML = booking['hovedrett'];
    }
    if(booking['dessert'].localeCompare("") == 0) {
        document.getElementById("dessert").innerHTML = "Ikke valgt";
    } else{
        document.getElementById("dessert").innerHTML = booking['dessert'];
    }
    if(booking['drikke'].localeCompare("") == 0) {
        document.getElementById("drikke").innerHTML = "Ikke valgt";
    } else{
        document.getElementById("drikke").innerHTML = booking['drikke'];
    }
    var date = new Date();
    var offset = date.getTimezoneOffset() * 60000;
    var rounded = new Date(Math.ceil(date.getTime() - offset));
    document.getElementById("utlopsdato").min = rounded.toISOString().slice(0,10);
    document.getElementById("utlopsdato").defaultValue = rounded.toISOString().slice(0,10);

});

function leggTilBestilling() {
    booking['kredittkort'] = $("#kortnummer").val();
    booking['utlopsdato'] = new Date($("#utlopsdato").val()).toJSON();
    booking['kontrollsiffer'] = $("#kontrollsiffer").val();
    booking = JSON.stringify(booking);
    $.ajax({
        url: 'rest/services',
        type: 'POST',
        data: booking,
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(data) {
            console.log(data);
            if (data == -1) alert("Alle bord opptatt på det valgte tidspunktet, men vi har fått kortinformasjonen din.... MOHAHAHAHA!!!!");
            else {
                localStorage.setItem("booking", booking);
                window.open('confirmation.html', '_self', false);
            }
        }
    });
}