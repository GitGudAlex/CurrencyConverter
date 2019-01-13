package project;

public class Helper {

    public static boolean bestehtAusZahlen (String s, int laenge){
        for(int i = 0; i < s.length(); i++){
            for(int j=0; j<laenge;j++)
            if(!(s.substring(i,i+1).equals(""+j))){
                return false;
            }
        }
        return true;

    }

}
