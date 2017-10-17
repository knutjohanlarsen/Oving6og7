package services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Bord {

    private String bordId;
    private ArrayList<Bookings> bookings = new ArrayList<>();

    public Bord(String bordId){
        this.bordId = bordId;
    }

    public String getBordId() {
        return bordId;
    }

    public void setBordId(String bordId) {
        this.bordId = bordId;
    }

    public ArrayList<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Bookings> bookings) {
        this.bookings = bookings;
    }

    public boolean addBooking(Bookings nyBooking){
        LocalDateTime ldtTemp = LocalDateTime.ofInstant(nyBooking.getBookingsTidspunkt().toInstant(), ZoneId.systemDefault());
        int antRetter = 3;
        if(nyBooking.getDessert().isEmpty()) antRetter--;
        if(nyBooking.getHovedrett().isEmpty()) antRetter --;
        if(nyBooking.getDessert().isEmpty()) antRetter --;
        int minutter =0;
        if (antRetter == 0 || antRetter == 1) minutter = 30;
        else if(antRetter == 2) minutter =60;
        else minutter = 90;
        LocalDateTime ldt = ldtTemp.plusMinutes(minutter);
        Date bookingExp = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        nyBooking.setUtløpsBookingsTidspunkt(bookingExp);

        if(bookings.isEmpty() && nyBooking.getBookingsTidspunkt() != null){
            this.bookings.add(nyBooking);
            return true;
        }
        for(Bookings bookings: bookings){
            if(nyBooking.getBookingsTidspunkt().after(bookings.getBookingsTidspunkt()) && nyBooking.getBookingsTidspunkt().before(bookings.getUtløpsBookingsTidspunkt())){
                return false;
            } else if (nyBooking.getBookingsTidspunkt().equals(bookings.getBookingsTidspunkt())){
                return false;
            } else{
                this.bookings.add(nyBooking);
                return true;
            }
        }
        return false;
    }

    public boolean removeBooking(String bookingId){
        for (Bookings booking: bookings) {
            if(booking.getBookingId().equals(bookingId)){
                bookings.remove(booking);
                return true;
            }

        }
        return false;
    }
}
