
/**
 * Stack of cards
 */
public class Stack
{
   private Card top;
   
   /**
    * Check emptiness.
    * 
    * @return true if empty
    */
   public boolean isEmpty(){
       if(top!=null)
       return false;
       else
       return true;
    }
   
    /**
     * Get the top card and put it back on this stack.
     * 
     * @return Topcard
     */
    public Card peek(){
        return null;
    }
    
    /**
     * Give the topcard, don't put it back.
     */
    public Card pop(){
        return null;
    }
    
    /**
     * Put a Card on this Stack.
     */
    public void push(Card c){
    }
}
