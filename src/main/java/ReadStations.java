import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadStations {

    private static final int STATIONS_ARGUMENT = 3;

    public static void ReadStation(String filePath, Line line) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(filePath));

        while(scanner.hasNextLine()) {
            String[] aux = scanner.nextLine().split(";");

            if(aux.length==3) {
                int numStation = Integer.parseInt(aux[0]);
                String stationName = aux[1];
                String zoneName = aux[2];
                Station station = new Station(stationName, numStation,zoneName);
            }
        }


    }
}
