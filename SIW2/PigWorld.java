import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Der Weltall, unendliche Weiten...
 * 
 * @author (Thomas Karp) 
 * @version (8.1.2012)
 */
public class PigWorld  extends World
{
    public PigWorld()
    {    
        // Create a new world with 600x450 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 

        Greenfoot.setSpeed(50);
        
        addObject(new Twoplayer(), 100, 100);
    }

    }
