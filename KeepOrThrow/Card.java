import java.util.Random;
public class Card
{
    private int value;
    private Card next;

    public Card(){
        value = new Random().nextInt(13);
        value += 2;
    }
}
