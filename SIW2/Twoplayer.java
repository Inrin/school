import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Twoplayer extends Lebewesen
{
    //Zähler
    private int steps;
    private int spiderpig;

    //Die drei Spidermedaillen
    private Actor s1; 
    private Actor s2;
    private Actor s3;

    //Hintergrundmusik
    private GreenfootSound sound;

    public Twoplayer()
    {
        steps = 0;
        spiderpig = 4;
        s1 = new Spidermedal();
        s2 = new Spidermedal();
        s3 = new Spidermedal();
        sound = new GreenfootSound("sound.wav");
    }

    public void act() 
    {
        //Zähler für die Schritte
        steps++;

        //Methoden 
        move();
        controls();
        mouse();
        checkpoint();
        if(steps == 100)
        {
            sound.play();
        }
    }

    public void controls ()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(-90);
        }

        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
        }

        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
        }

        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
        }

        if(Greenfoot.getKey() == "space")
        {
            spiderpig -= 1;
            if(spiderpig != 0 && spiderpig > 0)
            {
                int x = new Random().nextInt(600);
                int y = new Random().nextInt(450);
                setLocation(x,y);

                switch(spiderpig)
                {
                    case 3:
                    getWorld().removeObject(s3);
                    break;

                    case 2:
                    getWorld().removeObject(s2);
                    break;

                    case 1:
                    getWorld().removeObject(s1);
                    setImage("Piggi.png");
                    break;
                }
            }
        }

    }

    public void checkpoint ()
    {
        if(spiderpig == 4)
        {
            getWorld().addObject(s1, 35, 36);
            getWorld().addObject(s2, 98, 36);
            getWorld().addObject(s3, 163, 36);
        }

        if (atWorldEdge())
        {
            int x = new Random().nextInt(600);
            int y = new Random().nextInt(450);
            setLocation(x,y);
        }

        if(steps > 1000)
        {
            setRotation(0);
            setImage("boom.png");
            sound.stop();
            Greenfoot.setWorld(new Spieler2Gewinnt());

        }
    }

    public void mouse ()
    {
        if (Greenfoot.mouseClicked(this))
        {

            if( steps <= 1000 && steps >= 800)
            {
                setImage("happy.png");
            }
            else if( steps <= 799 && steps >= 600)
            {
                setImage("ok.png");
            }
            else if( steps <= 599 && steps >= 400)
            {
                setImage("traurig.png");
            }
            else if( steps <= 399)
            {
                setImage("boom.png");
            }
            setRotation(0);
            sound.stop();
            Greenfoot.delay(100);
            Greenfoot.setWorld(new Spieler1Gewinnt());
        }
    }
}