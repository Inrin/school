import java.util.ArrayList;
import java.util.Arrays;

public class SchuelerDB{
    private static final String[] students = {
            "Luca Carotenuto 16",
            "Christoph Dres",
            "Christian Heupel",
            "Andrey Ivashutin 17",
            "Tim Königs",
            "Ian Nivala 18",
            "Anton Rieger 19",
            "Steffen Schön",
            "Joshua Theis 17",
            "Jonas Treibel"};

    public static String[] getStudents(){
        return students;
    }
    
    public static ArrayList<Schueler> getStudentsAsSchueler(){
        ArrayList<Schueler> studentsList = new ArrayList<Schueler>();
        for(String s: students){
            String[] sArray = s.split(" ");
            if(sArray.length == 3)
            studentsList.add(new Schueler(sArray[0], sArray[1], Integer.parseInt(sArray[2])));
            else
                studentsList.add(new Schueler(sArray[0], sArray[1]));
        }
        return studentsList;
    }
}
