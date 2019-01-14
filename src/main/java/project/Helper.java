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
    public static boolean EingabeKorrekt(String eingabe) {
        boolean test = true;

        for (int i = 0; i < Main.currencylist.size(); i++) {
            String zwischenspeicher = Main.currencylist.get(i).getName();
            if (zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                return test = true;
            } else if (!zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                test = false;
            }

        }

        return test;
    }
}
