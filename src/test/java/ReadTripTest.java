import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class ReadTripTest {

    private ReadTrip readTrip = new ReadTrip();
    private ArrayList<Trip> arrayList = new ArrayList<>();

    @Test
    public void readStation() throws FileNotFoundException {
        TypeOfTicket type = new TypeOfTicket("Z2");
        Ticket ticket = new Ticket(111222333, type);
        Trip expected = new Trip(ticket, 1, 7);
        arrayList = readTrip.ReadTrip("./trips.txt");
        assertEquals(expected.toString(), arrayList.get(0).toString());
    }
}
