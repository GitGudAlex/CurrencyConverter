package project;

import java.util.Scanner;

public class Eingabe {

    public static String getEingabe(){
        Scanner eingabe = new Scanner(System.in);
        return eingabe.next();
    }

    public static boolean EingabeHasNext(){
        Scanner eingabe = new Scanner(System.in);
        if (eingabe.hasNext()){
            return true;
        }else {
            return false;
        }
    }
}
