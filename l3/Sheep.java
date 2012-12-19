import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sheep extends MovingActor
{
    private int energy,score;

    public Sheep(){
        sheepInit();
    }

    private void sheepInit(){
        energy=10;
        score=0;
    }

    public void movement(){
        if(Greenfoot.isKeyDown("left"))
            this.turnLeft();

        if(Greenfoot.isKeyDown("right"))
            this.turnRight();
        move();
    }

    public void counter(){
        score++;
        energy--;
    }

    private void notifyDeath(){
        Actor lupus = getOneIntersectingObject(Lupus.class);
        if(lupus != null || energy == 0)
            Greenfoot.stop();
    }

    private void printStats(){
        this.getImage().clear();
        this.getImage().drawString(""+energy, 38,38);
        this.getImage().drawString(""+score ,  0,38);
    }

    private void eatFlower(){
        Actor f = getOneIntersectingObject(Flower.class);
        if(f != null){
            getWorld().removeObject(f);
            energy++;
        }
    }

    public void sheepLogic(){
        eatFlower();
        printStats();
        notifyDeath();
    }

    public void act(){
        sheepLogic();
        counter();
        movement();
    }
}
