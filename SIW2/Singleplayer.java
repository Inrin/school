import java.util.Random;
import greenfoot.*;

public class Singleplayer  extends World
{
    private int pigs, ppigs, actCounter; //pigs and preveouis pigs
    private Pig realPig;

    public Singleplayer()
    {    
        // Create a new world with 600x450 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 
        realPig = new Pig();

        Greenfoot.setSpeed(50);
        ppigs = 0;
        addObject(realPig, 100, 100);
        pigs = 1;
        actCounter = 0;
    }

    public void act() {
        actCounter++;
        
        if(Greenfoot.mouseClicked(this))
            fibonacci();
        if(actCounter == 1000)
            endgame();
    }

    public void endgame() {
        if(realPig.getState().equals("boom"))
            javax.swing.JOptionPane.showMessageDialog(null, "The Pig is dead! \n You have lost.");
        else if(realPig.getState().equals("sad"))
            javax.swing.JOptionPane.showMessageDialog(null, "You have won. \n But the Pig died due to depressions!");
        else if(realPig.getState().equals("ok"))   
            javax.swing.JOptionPane.showMessageDialog(null, "You have won. \n But the Pig is not happy! \n Try again!");
        else if(realPig.getState().equals("happy"))
            javax.swing.JOptionPane.showMessageDialog(null, "Well done! \n The Pig is happy. \n You have won!");
        Greenfoot.setWorld(new Startgame());
    }

    public void fibonacci() {
        addPigs(ppigs);
        ppigs = pigs;
        pigs = getObjects(Pig.class).size();
    }

    public void addPigs(int howMany) {
        Random rand = new Random();
        for (int i=0; i< howMany; i++) 
            addObject(new Pig(), rand.nextInt(getWidth()), rand.nextInt(getHeight()));
    }
}