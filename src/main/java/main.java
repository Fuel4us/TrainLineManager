import java.io.FileNotFoundException;
import java.util.ArrayList;

// MAIN CREATED FOR DEBUG PRUPORSES
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/**
 *
 * @author mAniaK
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException {

        Exercicios exercicios = new Exercicios();
        ReadTrip readTrip = new ReadTrip();
        ReadStations readStation = new ReadStations();

        TypeOfTicket type = new TypeOfTicket("Z2");

        // ex2
        ArrayList<Trip> boas = readTrip.ReadTrip("./trips.txt");
        exercicios.numUtilizadores(boas);

        // ex3
        DoublyLinkedList<Station> station = readStation.ReadStation("./stations.txt");
        exercicios.sequencia(station, type);

        // ex4
        //exercicios.transgressao(boas, station);

    }
}
