import java.util.Comparator;

public class Schueler implements Comparable<Schueler>{
    private final String name,surname;
    private int age;
    static final Comparator<Schueler> AGE_ORDER =
        new Comparator<Schueler>(){
            @Override
            public int compare(Schueler s1, Schueler s2) {
                return new Integer(s2.getAge()).compareTo(new Integer(s1.getAge()));
            }
        };
   static final Comparator<Schueler> NAME_ORDER =
        new Comparator<Schueler>(){
            @Override
            public int compare(Schueler s1, Schueler s2){
                return s1.getName().compareTo(s2.getName());
            }
        };
        
        static final Comparator<Schueler> NAMELENGTH_ORDER =
        new Comparator<Schueler>(){
            @Override
            public int compare(Schueler s1, Schueler s2){
                Integer s1Length = s1.name.length() + s1.surname.length();
                Integer s2Length = s2.name.length() + s2.surname.length();
                return s2Length.compareTo(s1Length);
            }
        };
        
    public Schueler(String name, String surname, int age){
        if(name.isEmpty() || surname.isEmpty())
            throw new IllegalArgumentException("Everybody has a name. Empty String is not permitted");

        this.name = name;
        this.surname = surname;
        setAge(age);
    }

    public Schueler(String name, String surname){
        if(name.isEmpty() || surname.isEmpty())
            throw new IllegalArgumentException("Everybody has a name. Empty String is not permitted");

        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    private String getName(){
        return name;
    }

    private String getSurname(){
        return surname;
    }

    private int getAge(){
        return age;
    }

    private void setAge(int age){
        if(age >=0)
            this.age = age;
        else
            System.err.println("Cannot be negative");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Schueler))
            return false;
        Schueler s = (Schueler) o;
        return s.name.equals(name) && s.surname.equals(surname);
    }

    @Override
    public int hashCode() {
        return 31*name.hashCode() + surname.hashCode();
    }

    @Override
    public String toString(){
        return name + " " + surname + " (" + age + ")";
    }

    @Override
    public int compareTo(Schueler other){
        int res = this.surname.compareTo(other.surname);
        if(res !=0){
            return res;
        }

        return this.name.compareTo(other.name);
    }
}
