import java.util.LinkedList;
public class Game{
    private LinkedList<Karte> sentence;
    private Karte currentCard;
    private int drawnCards, deletedCards;

    public Game(){
        LinkedList<Karte> sentence = new LinkedList<Karte>();
    }

    public void debugFillSentence(){
        for(int i=0; i<10; i++){
            sentence.add(new Karte());
        }
    }

    public void showCurrentCard(){
        sentence.getLast();
    }

    public void drawCard(){ 
        sentence.add(new Karte());
    }

    public void putCard(int position){ 
        
    }

    public void deleteCard(int position){
    }

    public void printInfo(){
    }

    public void printSentence(){
    }

    public int getScore(){
        return 0;
    }
}

