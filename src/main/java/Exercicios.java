
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
    
    //caso as estaçoes não estivessem todas preenchidas , seria possivel utilizar a lista de stations para percorrer a lista de estações (em vez de j--) , j-- parte do principio que todos os numeros estao preenchidos 
    public void numUtilizadores(ArrayList<Trip> list) {
        int i;
        int j;
        ArrayList<Integer> countList = new ArrayList<>(); //armazena o numero de pessoas que passaram em cada estaçao , cada estaçao é assinalada pela posiçao no vetor

        for (i = 0; i < list.size(); i++) { //percorre a lista de trips 
            countList.clear();
            if (list.get(i).getOriginStation() > list.get(i).getFinalStation()) { //confirma se a estaçao de origem esta depois ou antes da estação final
                j = list.get(i).getOriginStation();
                do {
                    countList.set(j, (countList.get(j) + 1));//adidiciona um na posição da station
                    j--; //passa para a estaçao seguinte

                } while (list.get(i).getFinalStation() == j); //enquanto nao chegar a estacao final
            } else { //no caso da estaçao de origem estar antes da estacao final
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

    //neste exercicio seria possivel utilizar um map ou uma matriz para guardar multiplas sequencias maximas 
    public void sequencia(DoublyLinkedList<Station> list, TypeOfTicket type) {
        ArrayList<String> countList = new ArrayList<>(); //contador de zonas percorridas
        ArrayList<Integer> stationList = new ArrayList<>(); //maior sequencia de estacoes possivel entre X zonas seguidas
        ArrayList<Integer> finalStationList = new ArrayList<>(); //maior sequencia possivel entre qualquer X zonas seguidas
        
        DoublyLinkedList.Node<Station> station = list.getFirstNode();
        int i;
        int flag = 0;
        for (i = 0; i < list.size(); i++) { //percorre a lista de stations
            countList.clear();
        stationList.clear();
        {
            do {
                flag = 0;
                stationList.add(station.getElement().getNum()); //adiciona uma station a sequencia presente
                for (String lista : countList) { //adiciona as zonas percorridas para o array
                    if (station.getElement().getZone().compareTo(lista) == 0) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    countList.add(station.getElement().getZone()); //ou um contador simples
                }
                station = list.getNextNode(station); 
            } while (countList.size() < type.getNum() + 1); //repete ate ao maximo de estaçoes dentro do numero limite de zonas
            String temp = station.getElement().getZone();
            do{
            station = list.getNextNode(station); //volta a calcular a maior sequencia para a primeira estaçao da proxima zona
            }while(station.getElement().getZone().compareTo(temp) != 0);
            if (stationList.size() > finalStationList.size()) { //guarda a sequencia maior em finalStationList
                                finalStationList = stationList;

            }
        }
        for (Integer count : finalStationList) { //imprime a maior sequencia 
            System.out.println(count + "\n");
        }

    }}

    public void transgressao(ArrayList<Trip> list, DoublyLinkedList<Station> lista) {
        DoublyLinkedList.Node<Station> station = lista.getFirstNode().getPrev(); 
        ArrayList<String> countList = new ArrayList<>(); 
        int i;
        int flag;
        for (i = 0; i < list.size(); i++) { //percorre a lista de trips
            countList.clear();
            if (list.get(i).getOriginStation() > list.get(i).getFinalStation()) { //verifica se a station de origem esta depois do destino 

                do {
                    station = lista.getNextNode(station);
                } while (station.getElement().getNum() != list.get(i).getFinalStation()); //percorre a lista de stations ate chegar ao destino 
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
                        countList.add(station.getElement().getZone()); //adiciona a zona da station presente se a zona ainda nao estiver na lista
                    }

                } while (station.getElement().getNum() != list.get(i).getOriginStation()); //percorre a lista de stations ate chegar a origem
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
                        countList.add(station.getElement().getZone());
                    }

                } while (station.getElement().getNum() != list.get(i).getFinalStation());
            }
            if (countList.size() > list.get(i).getTicket().getType().getNum()) { //se o tipo de bilhete for inferior ao numero de zonas percorridas o utilizador esta em transgressao
                System.out.println("o ticket" + list.get(i).getTicket().getNum() + "esta em transgressao");
            }
        }

    }

}
