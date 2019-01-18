package project;

public class Helper {

    /**
     *
     * @param eingabe
     * @return
     */
    public static boolean EingabeKorrekt(String eingabe) {
        boolean test=true;
        //falls "xxx" eingegeben wurde, ist Eingabe korrekt
        if (eingabe.equals("xxx")){
            //gebe true zurück
            return true;
        }
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String zwischenspeicher = Main.currencylist.get(i).getName();
            if (zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                return true;
            } else {
                test=false;
            }
        }
        return test;
    }
}
