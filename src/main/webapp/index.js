$(document).ready(function(){
    $.ajax({
        url: 'rest/services',
        type: 'POST',
        success: function () {
        }
    });


// + new Date($("#date").val()),
    function getBooking() {
        var booking = JSON.stringify({
            bookingId: $("#navn").val(),
            bookingsTidspunkt: new Date($("#date").val()).toJSON(),
            antallGjester: $("#antGjester").val(),
            forrett: $("#forrett option:selected").text(),
            hovedrett: $("#hovedrett option:selected").text(),
            dessert: $("#dessert option:selected").text(),
            drikke: $("#drikke option:selected").text()
        });
        return booking;
    }

    $("#add").click(function () {
        $.ajax({
            url: 'rest/services/bookings',
            type: 'POST',
            data: getBooking(),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(data) {
                if (data == -1) alert("Bord opptatt");
                else alert("Success")
            }
        });
    });
});