import java.util.LinkedList;
public class Game{
    private LinkedList<Karte> sentence;
    private Karte currentCard;
    private int drawnCards, deletedCards;

    public Game(){
        this.sentence = new LinkedList<Karte>();
    }

    public void debugFillSentence(){
        for(int i=0; i<10; i++){
            sentence.add(new Karte());
        }
    }

    public void showCurrentCard(){
        if(currentCard != null)
            System.out.println(currentCard.getWort());
        else
            System.out.println("Empty");
    }

    public void drawCard(){ 
        currentCard = new Karte();
        drawnCards++;
    }

    public void putCard(int position){ 
        if(sentence.size()>position)
            sentence.add(position, currentCard);    
    }

    public void deleteCard(int position){
        if(sentence.size()>position){
            sentence.remove(position);
            deletedCards++;
        }
    }

    public void printInfo(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                          Word Scrabble");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Aktueller Satz: ");
        printSentence();
        System.out.println("Aktuelle Wortanzahl: " + sentence.size());
        System.out.println("Aktuelle Punktzahl: " + getScore());
        System.out.println("Aktuelle Karte: " + ((currentCard !=null) ? currentCard.getWort():"Keine vorhanden"));
    }

    public void printSentence(){
        if(sentence.size() != 0){
            for (Karte k : sentence) {
                System.out.print(k.getWort() + "(" + k.getWert() + ") ");
            }
        }else{
            System.out.println("Kein Satz vorhanden!");
        }
    }	

    public int getScore(){
        int score = 0;
        for (Karte k : sentence) {
            score += k.getWert();
        }
        return score;
    }
}
