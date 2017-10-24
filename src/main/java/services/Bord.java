package services;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
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

    public ArrayList<Bookings> getBookingsByDate(String date){
        ArrayList<Bookings> bookingsByDate = new ArrayList<>();
        Date checkDate = new Date(date);
        for (Bookings booking : bookings) {
            if(booking.getBookingsTidspunkt().getDate() == checkDate.getDate()){
                bookingsByDate.add(booking);
            }
        }
        return bookingsByDate;
    }
    public boolean addBooking(Bookings nyBooking){
        LocalDateTime ldtTemp = LocalDateTime.ofInstant(nyBooking.getBookingsTidspunkt().toInstant(), ZoneId.systemDefault());
        int antRetter = 0;
        if(!nyBooking.getForrett().isEmpty()) antRetter++;
        if(!nyBooking.getHovedrett().isEmpty()) antRetter++;
        if(!nyBooking.getDessert().isEmpty()) antRetter++;
        int minutter =0;
        if (antRetter == 0 || antRetter == 1) minutter = 30;
        else if(antRetter == 2) minutter =60;
        else minutter = 90;
        LocalDateTime ldt = ldtTemp.plusMinutes(minutter);
        Date bookingExp = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        nyBooking.setUtlopsBookingsTidspunkt(bookingExp);

        if(bookings.isEmpty() && nyBooking.getBookingsTidspunkt() != null){
            System.out.println(ldtTemp);
            this.bookings.add(nyBooking);
            return true;
        }
        for(Bookings bookings: bookings){
            if(nyBooking.getBookingsTidspunkt().before(bookings.getUtlopsBookingsTidspunkt()) && nyBooking.getUtlopsBookingsTidspunkt().after(bookings.getBookingsTidspunkt())) return false;
        }
        this.bookings.add(nyBooking);

        sortBookings();
        return true;
    }

    private void sortBookings() {
        bookings.sort(new Comparator<Bookings>() {
            @Override
            public int compare(Bookings o1, Bookings o2) {
                return o1.getBookingsTidspunkt().compareTo(o2.getBookingsTidspunkt());
            }
        });
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

    /*public ArrayList<Date> checkAvailability(String date) {
        ArrayList<Date> existingDates = new ArrayList<>();
        Date checkDate = new Date(date);
        Date bookingFinishDate = new Date();
        bookingFinishDate.setTime(bookingFinishDate.getTime() + getDurationOfBooking(booking));
        for (int bookingIndex = 0; bookingIndex < bookings.size(); bookingIndex++) {

//            if(checkDate.before(booking.getUtlopsBookingsTidspunkt()) && checkDate.after(booking.getBookingsTidspunkt())) continue;
//
//            existingDates.add(booking.getBookingsTidspunkt());
        }
        return existingDates;
    }

    public long getDurationOfBooking(Bookings booking) {
        long antallMinutter = 0;
        if(!booking.getForrett().isEmpty()) antallMinutter += 30;
        if(!booking.getHovedrett().isEmpty()) antallMinutter += 30;
        if(!booking.getDessert().isEmpty()) antallMinutter += 30;
        if(!booking.getDrikke().isEmpty() && antallMinutter == 0) antallMinutter += 30;
        return antallMinutter;
    }*/
}
