import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Pig extends Lebewesen
{
    private int angle, steps;
    private boolean moveing;
    private GreenfootSound sound;

    public Pig() {
        angle =  0;
        steps = 0;
        moveing = true;
        sound = new GreenfootSound("sound.wav");
    }

    public void act() 
    {
        int angle = new Random().nextInt(11) - 5;

        clickedPig();

        if(moveing){
            move();
            steps++;
            turn (angle);
        }

        if (atWorldEdge())
        {
            int x = new Random().nextInt(600);
            int y = new Random().nextInt(450);
            setLocation(x,y);
        }

        if(steps == 100){
            if(getWorld().getObjects(Pig.class).size() <= 1)
                sound.play();
        }

        if(steps == 1000) {
            setRotation(0);
            setImage("boom.png");
            moveing = false;
        }
    }

    public String getState() {
        if(!moveing){
            if( steps < 1000 && steps >= 800)
                return "happy";
            else if( steps <= 799 && steps >= 600)
                return "ok";
            else if( steps <= 599 && steps >= 400)
                return "sad";
            else if( steps == 1000 ^ steps < 399)
                return "boom";
            else return "Error undefined Error";
        }
        else {
            return "movingstate";
        }
    }

    public void clickedPig() {
        if (Greenfoot.mouseClicked(this))
        {
            moveing = false;
            setRotation(0);
            if(getState().equals("happy"))
                setImage("happy.png");
            else if(getState().equals("ok"))
                setImage("ok.png");
            else if(getState().equals("sad"))
                setImage("traurig.png");
            else if(getState().equals("boom"))
                setImage("boom.png");
        }
    }

    public void escape() {
        if(getState().equals("boom"))
            teleport(1000);
        else if(getState().equals("sad"))
            teleport(600);
        else if(getState().equals("ok"))
            teleport(400);
        else if(getState().equals("happy"))
            teleport(200);
    }

    public void teleport(int wahrscheinlichkeit) {
        if(new Random().nextInt(wahrscheinlichkeit) == 0) {
            int x = new Random().nextInt(getWorld().getWidth());
            int y = new Random().nextInt(getWorld().getHeight());
            setLocation(x,y);
        }
    }

}