import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class StationTest {

    private Station station = new Station("Romadeu", 1, "C1");

    @Test
    public void ensureGetsWorkProperly() {
        assertEquals("Romadeu", station.getName());
        assertEquals(1, station.getNum());
        assertEquals("C1", station.getZone());
    }

    @Test
    public void toStringTest() {
        String expected = "Station{" +
                "name='" + station.getName() + '\'' +
                ", num=" + station.getNum() +
                '}';
        assertEquals(expected, station.toString());
    }
}