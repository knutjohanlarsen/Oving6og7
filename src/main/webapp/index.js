$(document).ready(function(){
    console.log(document);
    document.getElementById("date").min = new Date().toISOString().slice(0,19);
    $.ajax({
        url: 'rest/services',
        type: 'POST',
        success: function () {
        }
    });



// + new Date($("#date").val()),
    /*function getBooking() {
        return booking;
    }*/

    $("#add").click(function () {
            var booking = JSON.stringify({
            bookingId: $("#navn").val(),
            bookingsTidspunkt: new Date($("#date").val()).toJSON(),
            antallGjester: $("#antGjester").val(),
            forrett: $("#forrett option:selected").text(),
            hovedrett: $("#hovedrett option:selected").text(),
            dessert: $("#dessert option:selected").text(),
            drikke: $("#drikke option:selected").text()
        });
        localStorage.setItem("booking", booking);
        window.open ('payment.html','_self',false);
    });


});