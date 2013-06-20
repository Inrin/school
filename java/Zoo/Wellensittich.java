public class Wellensittich extends Vogel implements Streicheltier
{
    private int alter = 0;
    private int preis = 10;

    public int getAlter(){
        return alter;
    }
    
    public int getWert(){
        return preis;
    }

    public void fressen ()
    {
        System.out.println("pick, pick, pick, pick");
    }

    public void laufen ()
    {
        System.out.println("tipp, tapp. Will wieder fliegen.");
    }

    public void fliegen ()
    {
        System.out.println("Flatter, flatter, flatter, will wieder sitzen ...");
    }
}

