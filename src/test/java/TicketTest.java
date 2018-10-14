import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class TicketTest {

    private TypeOfTicket typeOfTicket = new TypeOfTicket("z2");
    private Ticket ticket = new Ticket(111333, typeOfTicket);

    @Test
    public void ensureGetsReturnSuccesfully() {

        assertEquals(111333, ticket.getNum());
        assertEquals(typeOfTicket, ticket.getType());
        assertEquals("Ticket{" +
                "num=" + ticket.getNum() +
                ", type=" + ticket.getType() +
                '}', ticket.toString());
    }
}