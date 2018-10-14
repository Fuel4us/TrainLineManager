import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class TripTest {

    private  Ticket ticket = new Ticket();
    private Trip trip = new Trip(ticket, 1, 2);

    @Test
    public void getTicket() {
        assertEquals(ticket, trip.getTicket());
        assertEquals(1, trip.getOriginStation());
        assertEquals(2, trip.getFinalStation());
        assertEquals("Trip{" +
                "ticket=" + trip.getTicket() +
                ", originStation=" + trip.getOriginStation() +
                ", finalStation=" + trip.getFinalStation() +
                '}', trip.toString());
    }
}