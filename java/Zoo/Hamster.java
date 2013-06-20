
public class Hamster extends Tier  implements Streicheltier
{
    private int preis;
    
    public int getWert(){
        return preis;
    }
    
    public void fressen ()
    {
        System.out.println("nack, nack, nack. Gib mir mehr Körner...");
    }

    public void laufen ()
    {
        System.out.println("trippeldi trapp, trippeldi trapp");
    }

    public void imRadSpielen ()
    {
        System.out.println("Huiuiui, schneller, jawohl, ... uups, ich glaub ich krieg'n Drehwurm!!!");
    }
}

