package project;

public class Currency {

    private  String name;
    private  String rate;

    public Currency(String name, String rate) {
        setName(name);
        setRate(rate);
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }

    public String setName(String name){
        return this.name = name;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public static boolean korrekterSDRWert(String currency){
        int zaehler=0;
        for(int i = 0; i<currency.length(); i++){
            if(!currency.substring(i,i+1).equals("0")&&!currency.substring(i,i+1).equals("1")&&!currency.substring(i,i+1).equals("2")&&
                    !currency.substring(i,i+1).equals("3")&&!currency.substring(i,i+1).equals("4")&&!currency.substring(i,i+1).equals("5")&&
                    !currency.substring(i,i+1).equals("6")&&!currency.substring(i,i+1).equals("7")&&!currency.substring(i,i+1).equals("8")&&
                    !currency.substring(i,i+1).equals("9")&&!currency.substring(i,i+1).equals(".")){
                return false;
            }
            if (currency.substring(i,i+1).equals(".")){
                zaehler++;
                if(zaehler!=1){
                    return false;
                }
            }

        }
        return true;
    }
}
