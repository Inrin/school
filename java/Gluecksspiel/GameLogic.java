
public class GameLogic implements Spiel{
    private int kontostand;
    private int bank;
    private int getippteZahl;

    public GameLogic(){

    }

    public void gewinnAuszahlen(){
        if(getErmittelteZahl() == getippteZahl)
            kontostand += (bank*6);

        bank = 0;
    }

    public int getErmittelteZahl(){
        return new java.util.Random().nextInt(7);
    }

    public void einsatzZahlen(int beitrag){
        kontostand -= beitrag;
        bank += beitrag;
    }

    public void zahlErmitteln(){}

    public void zahlSetzen(int zahl){
        getippteZahl = zahl;
    }

    public int getKontostand(){
        return kontostand;
    }

}
