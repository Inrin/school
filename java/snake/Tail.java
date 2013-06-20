import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tail extends Actor
{
	    private Tail next;

	        public void create(){
			        if(next == null){

					            getWorld().addObject((next = new Tail()), 0, 0);
						            }else{
								                next.create();
										        }
				    }

		    public void follow(int x, int y){
			            if(next !=null){
					                next.follow(getX(), getY());
							        }
				            setLocation(x, y);
					        }
}
