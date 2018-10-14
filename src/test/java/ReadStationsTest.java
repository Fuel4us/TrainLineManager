import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * @author Gonçalo Fonseca (1150503@isep.ipp.pt)
 */
public class ReadStationsTest {

    private ReadStations readStations = new ReadStations();
    private DoublyLinkedList<Station> doublyLinkedList = new DoublyLinkedList<>();

    @Test
    public void readStation() throws FileNotFoundException {
        Station expected = new Station("Casa da Musica", 7, "C1");
        doublyLinkedList = readStations.ReadStation("./stations.txt");
        assertEquals(expected.toString(), doublyLinkedList.getFirstNode().getElement().toString());
    }
}