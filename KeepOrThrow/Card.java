import java.util.Random;
/**
 * Do what a card can do.
 */
public class Card
{
    private int value;
    private int suite;
    private Card next;

    /**
     * Generate a card with random value and suite.
     */
    public Card(){
        this.value = (new Random().nextInt(13)) +2;
        this.suite = (new Random().nextInt(4));
    }

    /**
     * (debugging) Generate a card with specific value.
     * 
     * @param value of new created card.
     * @param suite of new created card.
     */
    public Card(int value, int suite){
        this.setValue(value);
        this.setSuite(suite);
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
     * 11=J,12=Q,13=K=14=A
     * 
     * return value as int
     */
    public int getValue(){
        return value;
    }

    /**
     * Return suite of this.
     * 0=Spades,1=Hearts,2=Diamonds,3=Clubs
     * 
     * return suite as int
     */
    public int getSuite(){
        return suite;
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
     * The value must be between 2-14(As normal playing cards).
     * Otherwise sets a value of 0.
     *   
     * @param value to be set as int.
     */
    public void setValue(int value){
        this.value = (value >1 && value <15) ? value:0;     
    }

    /**
     * (debugging) Set suite of this.
     * 
     * 0=Spades,1=Hearts,2=Diamonds,3=Clubs
     * Otherwise sets a value of 0.
     * 
     * @param suite to be set as int
     */
    public void setSuite(int suite){
        this.suite = (suite >=0 && suite <4) ? suite:0;
    }
}