function getText() {
    $.get('rest/services', function (data) {
        console.log(data);
        console.log(data.length);
        console.log(data[0]);
        console.log(data[0].bookings)
        console.log(data[0].bookings.length)
        console.log();
        var html = "";
        for (var bordId = 0; bordId < data.length; bordId++){
            for (var bookingId = 0; bookingId < data[bordId].bookings.length; bookingId++) {
                html += "<tr>";
                html += "<td>" + data[bordId].bookings[bookingId].bookingId + "</td>";
                html += "<td>" + data[bordId].bordId + "</td>";
                html += "<td>" + new Date(data[bordId].bookings[bookingId].bookingsTidspunkt).toLocaleDateString() + "</td>";
                html += "<td>" + new Date(data[bordId].bookings[bookingId].bookingsTidspunkt).toLocaleTimeString() + "</td>";
                html += "<td>" + data[bordId].bookings[bookingId].forrett + "</td>";
                html += "<td>" + data[bordId].bookings[bookingId].hovedrett + "</td>";
                html += "<td>" + data[bordId].bookings[bookingId].dessert + "</td>";
                html += "<td>" + data[bordId].bookings[bookingId].drikke + "</td>";
                html += "</tr>";
            }

        }
        $("#tabell").html(html);
    });
}

$(document).ready(function() {
    getText();
    setInterval(getText, 30000);
});