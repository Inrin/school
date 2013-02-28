

public class Hausaufgaben implements Sortierbar{
    private int wert;
    private String a;

    public Hausaufgaben(String a, int wert){
        this.wert = wert;
        this.a = a;
    }

    public int getWert(){
        return wert;
    }
    
    public String toString(){
        return a;
    }
}
