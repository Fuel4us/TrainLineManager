
import java.util.ArrayList;
import javafx.scene.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miura
 */
public class Exercicios {

    public void numUtilizadores(ArrayList<Trip> list) {
        int i;
        int j;
        ArrayList<Integer> countList = new ArrayList<>();

        for (i = 0; i < list.size(); i++) {
            countList.clear();
            if (list.get(i).getOriginStation() > list.get(i).getFinalStation()) {
                j = list.get(i).getOriginStation();
                do {
                    countList.set(j, (countList.get(j) + 1));
                    j--;

                } while (list.get(i).getFinalStation() == j);
            } else {
                j = list.get(i).getOriginStation();
                do {
                    countList.set(j, (countList.get(j) + 1));
                    j++;

                } while (list.get(i).getFinalStation() == j);
            }
        }

        for (Integer count : countList) {
            System.out.println("na estação " + i++ + " passaram " + count + " pessoas");
        }

    }

    public void sequencia(DoublyLinkedList<Station> list, TypeOfTicket type) {
        ArrayList<String> countList = new ArrayList<>();
        ArrayList<Integer> stationList = new ArrayList<>();
        ArrayList<Integer> finalStationList = new ArrayList<>();

        DoublyLinkedList.Node<Station> station = list.getFirstNode();
        int i;
        int flag = 0;
        for (i = 0; i < list.size(); i++) {
            countList.clear();
        }
        stationList.clear();
        {

            do {
                flag = 0;
                stationList.add(station.getElement().getNum());
                for (String lista : countList) {
                    if (station.getElement().getZone().compareTo(lista) == 0) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    countList.add(station.getElement().getZone()); //ou um contador simples
                }
                station = list.getNextNode(station);
            } while (countList.size() < type.getNum() + 1);
            station = list.getNextNode(station);
            if (stationList.size() > finalStationList.size()) {
                finalStationList = stationList;
            }
        }
        for (Integer count : finalStationList) {
            System.out.println(count + "\n");
        }

    }

    public void transgressao(ArrayList<Trip> list, DoublyLinkedList<Station> lista) {
        DoublyLinkedList.Node<Station> station = lista.getFirstNode().getPrev();
        ArrayList<String> countList = new ArrayList<>();
        int i;
        int flag;
        for (i = 0; i < list.size(); i++) {
            countList.clear();
            if (list.get(i).getOriginStation() > list.get(i).getFinalStation()) {

                do {
                    station = lista.getNextNode(station);
                } while (station.getElement().getNum() != list.get(i).getFinalStation());
                countList.add(station.getElement().getZone());
                do {
                    station = lista.getNextNode(station);

                    flag = 0;
                    for (String listaa : countList) {
                        if (station.getElement().getZone().compareTo(listaa) == 0) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        countList.add(station.getElement().getZone()); //ou um contador simples
                    }

                } while (station.getElement().getNum() != list.get(i).getOriginStation());
            } else {
                do {
                    station = lista.getNextNode(station);
                } while (station.getElement().getNum() != list.get(i).getOriginStation());
                countList.add(station.getElement().getZone());
                do {
                    station = lista.getNextNode(station);

                    flag = 0;
                    for (String listaa : countList) {
                        if (station.getElement().getZone().compareTo(listaa) == 0) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        countList.add(station.getElement().getZone()); //ou um contador simples
                    }

                } while (station.getElement().getNum() != list.get(i).getFinalStation());
            }
            if (countList.size() > list.get(i).getTicket().getType().getNum()) {
                System.out.println("o ticket" + list.get(i).getTicket().getNum() + "esta em transgressao");
            }
        }

    }

}
