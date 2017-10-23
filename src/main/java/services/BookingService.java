package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;

@Path("/services/")
public class BookingService {

    public static Bord[] bord = {new Bord("0"), new Bord("1"), new Bord("2")};

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bord[] getBord() {
        return bord;
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void populateBord() {
        for (int i = 0; i < bord.length; i++) bord[i] = new Bord(String.valueOf(i));
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int addBooking(Bookings booking) {
        for (Bord bord: bord) if(bord.addBooking(booking)) return 1;
        return -1;
    }

    /*@GET
    @Path("/{dateToCheck}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Date> displayTest(@PathParam("dateToCheck") String date){
        ArrayList<Date> listeOverLedigeTidspunkt = new ArrayList<>();
        for (Bord bord :bord) {
            System.out.println(date);
            ArrayList<Date> ledigeForBord = bord.checkAvailability(date);
            for (Date ledig :ledigeForBord) {
                listeOverLedigeTidspunkt.add(ledig);
            }
        }
        return listeOverLedigeTidspunkt;
    }*/

    /*@GET
    @Path("/bookings")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<services.Bookings> display(){
        ArrayList<services.Bookings> bookings = new ArrayList<>();
        for (int i = 0; i < bord.length; i++){
            ArrayList<Bookings> temp = bord[i].getBookings();
            for (int j = 0; j < temp.size(); j++){
                bookings.add(temp.get(j));
            }
        }
        return bookings;
    }*/

    @DELETE
    @Path("/{bordId}/{bookingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteKunde(@PathParam("bordId") String bordId, @PathParam("bookingId") String bookingId) {
        this.bord[Integer.parseInt(bordId)].removeBooking(bookingId);
    }
}