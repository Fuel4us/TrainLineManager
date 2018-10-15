
import java.util.ArrayList;

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

    //caso as esta�oes n�o estivessem todas preenchidas , seria possivel utilizar a lista de stations para percorrer a lista de esta��es (em vez de j--) , j-- parte do principio que todos os numeros estao preenchidos
    public ArrayList<Integer> numUtilizadores(ArrayList<Trip> list) {
        int i;
        int j;
        ArrayList<Integer> countList = new ArrayList<>(); //armazena o numero de pessoas que passaram em cada esta�ao , cada esta�ao � assinalada pela posi�ao no vetor

        for (int k = 0; k < 8; k++) {
            countList.add(k, 0);
        }

        for (i = 0; i < list.size(); i++) { //percorre a lista de trips
            if (list.get(i).getOriginStation() > list.get(i).getFinalStation()) { //confirma se a esta�ao de origem esta depois ou antes da esta��o final
                j = list.get(i).getOriginStation();
                countList.set(j, (countList.get(j) + 1));
                do {
                    j--; //passa para a esta�ao seguinte
                    countList.set(j, (countList.get(j) + 1));//adidiciona um na posi��o da station

                } while (list.get(i).getFinalStation() != j); //enquanto nao chegar a estacao final
            } else { //no caso da esta�ao de origem estar antes da estacao final
                j = list.get(i).getOriginStation();
                countList.set(j, (countList.get(j) + 1));
                do {
                    j++;
                    countList.set(j, (countList.get(j) + 1));

                } while (list.get(i).getFinalStation() != j);
            }
        }

        i = 0;
        for (Integer count : countList) {
            System.out.println("na station " + i++ + " passaram " + count + " pessoas");
        }

        return countList;

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
                } while (countList.size() < type.getNum() + 1); //repete ate ao maximo de esta�oes dentro do numero limite de zonas
                // --------------- x ----------------
                System.out.println(station.getPrev().getElement().toString());
                String temp = station.getElement().getZone(); // -> erro aqui pois esta no fim das stations
                do {
                    station = list.getNextNode(station); //volta a calcular a maior sequencia para a primeira esta�ao da proxima zona
                } while (station.getElement().getZone().compareTo(temp) != 0);
                if (stationList.size() > finalStationList.size()) { //guarda a sequencia maior em finalStationList
                    finalStationList = stationList;

                }
            }
            for (Integer count : finalStationList) { //imprime a maior sequencia
                System.out.println(count + "\n");
            }

        }
    }

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
                    System.out.println(countList);
                    for (String listaa : countList) {
                      // -------------x-----------
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
