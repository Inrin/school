import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Lupus extends MovingActor
{

    private int gestationtime = 1;

    public void movement(){
        if(!this.canMove()){
            if(new Random().nextInt(1) == 0)
                this.turnRight();
            else
                this.turnLeft();
        }

        if(new Random().nextInt(10) == 0)
            setDirection(new Random().nextInt(4));

        move();
    }

    private void breed(){
        if(gestationtime>0 && gestationtime<63)
            gestationtime++;
        else
            gestationtime = 0;

        if(new Random().nextInt(getWorld().getObjects(Lupus.class).size()) == 0){
            if(getOneIntersectingObject(Lupus.class)!= null && gestationtime == 0){
                SheepWorld w =(SheepWorld) getWorld();
                w.populateLupus(6);
                gestationtime++;
            }
        }
    }

    public void act(){
        breed();
        movement();
    }
}