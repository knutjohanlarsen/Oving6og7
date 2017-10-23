function getText() {
    $.get('rest/services', function (data) {
        console.log(data);
        console.log(data.length);
        console.log(data[0]);
        console.log(data[0].bookings);
        console.log(data[0].bookings.length);
        console.log();
        var bookingslist = [];
        for (var bordId = 0; bordId < data.length; bordId++){
            for (var bookingId = 0; bookingId < data[bordId].bookings.length; bookingId++){
                bookingId.bordId = bordId;
                bookingslist.push(bookingId);
            }
        }
        bookingslist.sort(function (a, b) {
            return a.bookingsTidspunkt - b.bookingsTidspunkt;
        });
        var html = "";
        for (var bookingId = 0; bookingId < bookingslist.length; bookingId++) {
            html += "<tr>";
            html += "<td>" + bookingslist[bookingId].bookingId + "</td>";
            html += "<td>" + bookingslist[bookingId].bordId + "</td>";
            html += "<td>" + new Date(bookingslist[bookingId].bookingsTidspunkt).toLocaleDateString() + "</td>";
            html += "<td>" + new Date(bookingslist[bookingId].bookingsTidspunkt).toLocaleTimeString() + "</td>";
            html += "<td>" + new Date(bookingslist[bookingId].utlopsBookingsTidspunkt).toLocaleTimeString() + "</td>";
            html += "<td>" + bookingslist[bookingId].forrett + "</td>";
            html += "<td>" + bookingslist[bookingId].hovedrett + "</td>";
            html += "<td>" + bookingslist[bookingId].dessert + "</td>";
            html += "<td>" + bookingslist[bookingId].drikke + "</td>";
            html += "</tr>";
        }
        $("#tabell").html(html);
    });
}

$(document).ready(function() {
    getText();
    setInterval(getText, 15000);
});