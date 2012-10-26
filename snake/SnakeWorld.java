import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnakeWorld extends World
{

    public SnakeWorld()
    {    
        super(10, 7, 80); 

        for(int i=0; i<=getWidth(); i++){
            addObject(new Rand(), i,0);
            addObject(new Rand(), i, getHeight());
        }
        for(int i=0; i<=getHeight(); i++){
            addObject(new Rand(), 0, i);
            addObject(new Rand(), getWidth(),i);
        }
        
        setPaintOrder(Apple.class,Head.class,Tail.class,Rand.class);
    }
    
    

    public void act(){
        int rx = Greenfoot.getRandomNumber(getWidth()-1);
        int ry = Greenfoot.getRandomNumber(getHeight()-1);
        if(getObjects(Apple.class).size() == 0)
            addObject(new Apple(), rx +1, ry+1);
    }
}
