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
}
