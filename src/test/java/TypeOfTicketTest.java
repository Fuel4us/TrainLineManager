import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class TypeOfTicketTest {

    private TypeOfTicket typeOfTicket = new TypeOfTicket("z2");

    @Test
    public void returnNumber() {
        typeOfTicket.returnNumber("z2");
        assertEquals(2, typeOfTicket.getNum());
    }

    @Test
    public void getType() {
        assertEquals("z2", typeOfTicket.getType());
        assertEquals("TypeOfTicket{" +
                "type='" + typeOfTicket.getType() + '\'' +
                '}', typeOfTicket.toString());
    }
}