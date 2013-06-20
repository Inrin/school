import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spieler2Gewinnt extends World
{
    public Spieler2Gewinnt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 300, 1); 
    }
    
    public void act()
    {       
         Greenfoot.delay(200);
         Greenfoot.setWorld(new Startgame());
    }
}
