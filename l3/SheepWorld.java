import greenfoot.*;  
import java.util.Random;

public class SheepWorld extends World
{
    public SheepWorld()
    {    
        // Erzeuge eine neue Welt mit 15x12 Zellen und einer Zellengröße von 30x30 Pixeln.
        super(15, 12, 30);
        gameInit();
    }

    private void gameInit(){
        populateLupus(2);
        addObject(new Sheep(), (getWidth()/2), (getHeight()/2));
        for(int i=0; i<5; i++)
            addObject(new Flower(), new Random().nextInt(getWidth()), new Random().nextInt(getHeight()));
    }

    private void populateFlora(){
        if(new Random().nextInt(5) == 0)
            addObject(new Flower(), new Random().nextInt(getWidth()), new Random().nextInt(getHeight()));
    }

    public void populateLupus(int howMany){
        for(int i=0; i<howMany; i++)
            addObject(new Lupus(), new Random().nextInt(getWidth()), new Random().nextInt(getHeight()));
    }

    public void act(){
        populateFlora();
    }
}
