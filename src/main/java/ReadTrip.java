import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTrip {

        public static ArrayList<Trip> tripList = new ArrayList<>();


        public ArrayList<Trip> ReadTrip(String filePath) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(filePath));

        while(scanner.hasNextLine()) {
            String[] aux = scanner.nextLine().split(",");

            if(aux.length==4) {
                int numTrip = Integer.parseInt(aux[0]);
                int original = Integer.parseInt(aux[2]) ;
                int destination = Integer.parseInt(aux[3]);
                TypeOfTicket type = new TypeOfTicket(aux[1]);
                Ticket ticket = new Ticket(numTrip,type);
                Trip trip = new Trip(ticket, original,destination);
                tripList.add(trip);
            }
        }

        return tripList;
        }
        }
