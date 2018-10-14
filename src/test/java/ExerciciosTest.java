/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciciosTest {

    private Exercicios exercicios = new Exercicios();
    private ReadTrip readTrip = new ReadTrip();

    /**
     * Test of numUtilizadores method, of class Exercicios.
     */
    @Test
    public void testNumUtilizadores() throws FileNotFoundException {
        System.out.println("numUtilizadores");
        ArrayList<Trip> list = readTrip.ReadTrip("./trips.txt");
        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> result = exercicios.numUtilizadores(list);
        expected.add(0,0);
        expected.add(1,3);
        expected.add(2,4);
        expected.add(3,3);
        expected.add(4,3);
        expected.add(5,3);
        expected.add(6,3);
        expected.add(7,1);
        exercicios.numUtilizadores(list);
        assertEquals(expected, result);
    }

    /**
     * Test of sequencia method, of class Exercicios.
     */
    @Test
    public void testSequencia() {
        System.out.println("sequencia");
        DoublyLinkedList<Station> list = null;
        TypeOfTicket type = null;
        Exercicios instance = new Exercicios();
        instance.sequencia(list, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of transgressao method, of class Exercicios.
//     */
//    @Test
//    public void testTransgressao() {
//        System.out.println("transgressao");
//        ArrayList<Trip> list = null;
//        DoublyLinkedList<Station> lista = null;
//        Exercicios instance = new Exercicios();
//        instance.transgressao(list, lista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
