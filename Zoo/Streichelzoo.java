import java.util.*;

public class Streichelzoo
{
    private HashSet<Streicheltier> tiere;
    
    public int getGesamtWert()
    {
        int summe = 0;
        
        for(Streicheltier tier: tiere){
           summe += tier.getWert();
        }
        
        return summe;
    }
}
