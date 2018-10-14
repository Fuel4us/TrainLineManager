import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mAniaK
 */
public class main {
    
    public static void main(String [] args) throws FileNotFoundException{
         
        Exercicios exercicios = new Exercicios();
        ReadTrip readTrip = new ReadTrip();
        
        ArrayList<Trip> list = readTrip.ReadTrip("./trips.txt");
        exercicios.numUtilizadores(list);
    }
    }
    
