import java.util.Collections;
import java.util.List;

public class Sort{

    public Sort(){

    }

    public List<Schueler> sortAscending(List<Schueler> l){
        Collections.sort(l);
        return l;
    }

    public List<Schueler> sortAscendingName(List<Schueler> l){
        Collections.sort(l, Schueler.NAME_ORDER);
        return l;
    }

    public List<Schueler> sortAscendingAge(List<Schueler> l){
        Collections.sort(l, Schueler.AGE_ORDER);
        return l;
    }
    
    public List<Schueler> sortAscendingNameLength(List<Schueler> l){
        Collections.sort(l, Schueler.NAMELENGTH_ORDER);
        return l;
    }
    
    public List<Schueler> sortDescending(List<Schueler> l){
        sortAscending(l);
        Collections.reverse(l);
        return l;
    }
    
    public List<Schueler> sortDescendingName(List<Schueler> l){
        sortAscendingName(l);
        Collections.reverse(l);
        return l;
    }

    public List<Schueler> sortDescendingAge(List<Schueler> l){
        sortAscendingAge(l);
        Collections.reverse(l);
        return l;
    }
    
    public List<Schueler> sortDescendingNameLength(List<Schueler> l){
        sortAscendingNameLength(l);
        Collections.reverse(l);
        return l;
    }
    
    private void displayList(List<Schueler> l){
        for(Schueler s: l){
            System.out.println(s.toString());
        }
        
        System.out.println();
    }
    
    public static void main(String[] args){
        Sort s = new Sort();
        List<Schueler> st = SchuelerDB.getStudentsAsSchueler();
        System.out.println("Init");
        s.displayList(st);
        Collections.shuffle(st);
        System.out.println("Shuffle");
        s.displayList(st);
        s.sortAscending(st);
        System.out.println("Ascending");
        s.displayList(st);
        s.sortAscendingAge(st);
        System.out.println("AscendingAge");
        s.displayList(st);
        s.sortAscendingName(st);
        System.out.println("AscendingName");
        s.displayList(st);
        s.sortAscendingNameLength(st);
        System.out.println("AscendingNameLength");
        s.displayList(st);
        s.sortDescending(st);
        System.out.println("Descending");
        s.displayList(st);
        s.sortDescendingAge(st);
        System.out.println("DescendingAge");
        s.displayList(st);
        s.sortDescendingName(st);
        System.out.println("DescendingName");
        s.displayList(st);
        s.sortDescendingNameLength(st);
        System.out.println("DescendingNameLength");
        s.displayList(st);
    }
}
