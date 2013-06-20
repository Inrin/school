import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends World
{

    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 
    }
    
    public void act()
    {
         if(Greenfoot.isKeyDown("enter"))
         Greenfoot.setWorld(new PigWorld());
         
         if(Greenfoot.isKeyDown("space"))
         Greenfoot.setWorld(new Singleplayer());
    }
}
