import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Head  extends Actor
{
    // 0 f�r hoch, 1 f�r rechts, 2 f�r ab, 3 f�r links
    private int direction;
    private Tail first;

    public Head()
    {
        // Anfangsrichtung nach oben
        direction = 0;
    }

    public void addElement()
    {
        if(first!=null){
            first.create();
        }
        else{
            first = new Tail();
            getWorld().addObject(first, 0, 0);
        }
    }

    public void turn()
    {
        // �ndere Richtung, falls keine Wende
        if(Greenfoot.isKeyDown("left") && direction != 1)
        {
            direction = 3;
        }
        if(Greenfoot.isKeyDown("right") && direction != 3)
        {
            direction = 1;
        }
        if(Greenfoot.isKeyDown("up") && direction != 2)
        {
            direction = 0;
        }
        if(Greenfoot.isKeyDown("down") && direction != 0)
        {
            direction = 2;
        }
    }

    public void move()
    {
        // Gehe in aktuelle Richtung weiter
        if(direction == 0)
        {
            setLocation(getX(), getY()-1);
        }
        else if(direction == 1)
        {
            setLocation(getX() + 1, getY());
        }
        else if(direction == 2)
        {
            setLocation(getX(), getY() + 1);
        }
        else
        {
            setLocation(getX() - 1, getY());
        }
    }

    public void act() 
    {
        if(getOneIntersectingObject(Rand.class) != null || getOneIntersectingObject(Tail.class) != null)
        {
            Greenfoot.stop();
        }
        Actor apple = getOneIntersectingObject(Apple.class);
        if(apple != null)
        {
            getWorld().removeObject(apple);

            int xRange = new java.util.Random().nextInt(getWorld().getWidth()-2) + 1; 
            int yRange = new java.util.Random().nextInt(getWorld().getHeight()-2) + 1; 
            getWorld().addObject(new Apple(), xRange, yRange);
            addElement();
        }    
        turn();
        if(first!=null){
            first.follow(getX(), getY());
        }
        move();
        if(getOneIntersectingObject(Tail.class)!=null){
            Greenfoot.stop();
        }
    }

}
