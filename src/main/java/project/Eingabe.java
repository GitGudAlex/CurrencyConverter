package project;

import java.util.Scanner;

public class Eingabe {

    static Scanner eingabe = new Scanner(System.in);

    public static String getEingabe(){
        return eingabe.next();
    }

    public static boolean EingabeHasNext(){
        if (eingabe.hasNext()){
            return true;
        }else {
            return false;
        }
    }
}
