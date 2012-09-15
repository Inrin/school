import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startgame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startgame extends World
{
    /**
     * Constructor for objects of class Startgame.
     * 
     */
    public Startgame()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 
    }

    public void act()
    {

        if(Greenfoot.getKey() == ("enter"))
            Greenfoot.setWorld(new PigWorld());

        if(Greenfoot.isKeyDown("h"))
            Greenfoot.setWorld(new Help());
        
        if(Greenfoot.isKeyDown("space")) 
        Greenfoot.setWorld(new Singleplayer());

    }
}
