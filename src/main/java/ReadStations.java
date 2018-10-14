import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ReadStations {

    private static final int STATIONS_ARGUMENT = 3;
    public static DoublyLinkedList<Station> doubleLinkedList = new DoublyLinkedList<>();
    public static ArrayList<Station> stations = new ArrayList<>();


    public static void ReadStation(String filePath) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(filePath));

        while(scanner.hasNextLine()) {
            String[] aux = scanner.nextLine().split(";");

            if(aux.length==3) {
                int numStation = Integer.parseInt(aux[0]);
                String stationName = aux[1];
                String zoneName = aux[2];
                Station station = new Station(stationName, numStation,zoneName);
                stations.add(station);
            }
        }

        Collections.sort(stations,stationComp);

        int i;
        
        
        for(i=0;i<stations.size();i++){
        doubleLinkedList.addFirst(stations.get(i));
        }
        
        

    }
    
    public static Comparator<Station> stationComp = new Comparator<Station>() {

    @Override
    public int compare(Station station, Station station1)
        {
            return  station.getNum()-(station1.getNum());
        }
        };
}
