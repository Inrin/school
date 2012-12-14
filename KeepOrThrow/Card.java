import java.util.Random;
/**
 * Do what a card can do.
 */
public class Card
{
    private int value;
    private Card next;
    
    /**
     * Generate a card with random value.
     */
    public Card(){
        value = (new Random().nextInt(13)) +2;
    }
    
    /**
     * (debugging) Generate a card with specific value.
     * 
     * @param value of new created card.
     */
    public Card(int value){
        this.setValue(value);
    }
    
    /**
     * Return card beneath this on stack.
     * 
     * @return next as Card
     */
    public Card getNext(){
        return next;
    }
    
    /**
     * Return value of this.
     * 
     * return value as int
     */
    public int getValue(){
        return value;
    }
    
    /**
     * Set next card
     * 
     * @param next card beneath this
     */
    public void setNext(Card next){
        this.next = next;
    }
    
    /**
     * (debugging) Set value of this.
     * 
     * The value must be between 14-2(As normal playing cards).
     * Else sets a value of 0.
     * 
     * @param value to be set as int.
     */
    public void setValue(int value){
        if(value >1 && value <15)
        this.value = value;
        else
        this.value = 0;
    }
}
