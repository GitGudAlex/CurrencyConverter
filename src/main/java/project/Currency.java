package project;

public class Currency {

    private String name;
    private String rate;

    /**
     * Konstruktor der Klasse Currency
     * @param name
     * @param rate
     */
    public Currency(String name, String rate) {
        setName(name);
        setRate(rate);
    }

    /**
     * Gibt Name des Objekts (der Währung) zurück
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gibt SDR-Wert des Objekts (der Währung) zurück
     * @return rate: SDR-Wert des Objekts (der Währung)
     */
    public String getRate() {
        return rate;
    }

    /**
     * setzt die Variable name für das Objekt
     * @param name
     * @return
     */
    public String setName(String name){
        return this.name = name;
    }

    /**
     * setzt die Variable rate für das Objekt
     * @param rate
     * @return
     */
    public String setRate(String rate) {
        return this.rate = rate;
    }

    /**
     * Mathode zur Überprüfung ob die aus der Datei übergegebenen Werte echte Zahlen sind.
     * @param currency
     * @return boolean true: Werte sind echte Zahlen; false: Wert sind keine Zahlen
     */
    public static boolean korrekterSDRWert(String currency){
        int zaehler=0;

        for(int i = 0; i<currency.length(); i++){
            //Überprüfung ob übergebener Currency-Wert nicht aus Ziffern oder Punkt besteht
            if(!currency.substring(i,i+1).equals("0")&&!currency.substring(i,i+1).equals("1")&&!currency.substring(i,i+1).equals("2")&&
                    !currency.substring(i,i+1).equals("3")&&!currency.substring(i,i+1).equals("4")&&!currency.substring(i,i+1).equals("5")&&
                    !currency.substring(i,i+1).equals("6")&&!currency.substring(i,i+1).equals("7")&&!currency.substring(i,i+1).equals("8")&&
                    !currency.substring(i,i+1).equals("9")&&!currency.substring(i,i+1).equals(".")){
                //gebe false zurück, SDR-Wert ist nicht korrekt
                return false;
            }
            //falls mehrere Punkte in einer Zahl sind ist SDR-Wert nicht korrekt
            if (currency.substring(i,i+1).equals(".")){
                zaehler++;
                if(zaehler!=1){
                    return false;
                }
            }
        }
        //wenn keine der obrigen Bedingungen erfüllt ist, ist SDR-Wert korrekt. Gebe true zurück.
        return true;
    }
}
