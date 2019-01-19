package project;

public class Helper {

    /**
     *
     * @param input
     * @return
     */
    public static boolean EingabeKorrekt(String input) {
        boolean test = true;
        //falls "xxx" eingegeben wurde, ist input korrekt
        if (input.equals("xxx")){
            //gebe true zurück
            return true;
        }
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String cache = Main.currencylist.get(i).getName();
            if (cache.toLowerCase().contains(input.toLowerCase())) {
                return true;
            } else {
                test = false;
            }
        }
        return test;
    }
}
