
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
        return top;
    }

    /**
     * Give the topcard, don't put it back.
     */
    public Card pop(){
        Card temp = top;
        top = null;
        return temp;
    }

    /**
     * Put a Card on this Stack.
     */
    public void push(Card c){
        if(c!=null)
            top = c;
        else
            System.out.println("Must be a card!");
    }
}
