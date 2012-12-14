
/**
 * Responsible for gamemanagement.
 * 
 */
public class GameLogic
{
    /** The three needed Stacks for playing KeepOrThrow */
    private Stack mixedStack, keepStack,throwStack;
    
    public GameLogic(){
        gameInit();
    }
    
    /**
     * View the current top card of mixedStack
     */
    public void view(){
    }
    
    /**
     * Keep the current top card on the mixedStack(Place it on keepStack).
     */
    public void keep(){
    }
    
    /**
     * Throw the current top card on the mixedStack away(Place it on throwStack).
     */
    public void dump(){
    }
    
    /**
     * Count cards on keepStack.
     */
    public void count(){
    }
    
    /**
     * Do all the things needed to start a new game.
     */
    private void gameInit(){
        mixedStack = new Stack();
        keepStack = new Stack();
        throwStack = new Stack();
        
        for(int i=1; i<53; i++){
            mixedStack.push(new Card());
        }
    }
}
