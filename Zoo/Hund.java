public class Hund extends Tier implements Streicheltier
{
    public int getWert(){
        return 750;    
    }
    
    public void fressen ()
    {
        System.out.println("Schmatz, schmatz, schmatz");
    }

    public void laufen ()
    {
        System.out.println("trippeldi trapp, trippeldi trapp");
    }

    public void stöckchenHolen ()
    {
        System.out.println("Yippie, ya, yeah. Wirf das Ding, ich hol' es");
    }
}

