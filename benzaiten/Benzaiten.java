import java.util.LinkedList;

public class Benzaiten{
    private LinkedList<Song> songs;

    public Benzaiten(){
        songs = new LinkedList<Song>();
    }

    public void add(String name, String interpreter, boolean isCopyOfCD, int duration){
        songs.add(new Song(name,interpreter,isCopyOfCD,duration));
    }

    public void remove(int position){
        songs.remove(position);
    }

    public int getNumberOfSongs(){
        return songs.size();
    }

    public void printInfo(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("+                            Benzai                                +");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("");
        for(String str: getInterpreters()){
            System.out.println(str + ":");
            for(Song s: songs){
                System.out.println("\tName: " + s.getName());
                System.out.println("\tDauer: " + s.getDauer());
            }
            System.out.println("____________________________________________________________________");
            System.out.println("Anzahl Songs: " + getNumberOfSongsByInterpreter(str));
        }
        System.out.println("____________________________________________________________________");
        System.out.println("Gesmamtanzahl Songs: " + getNumberOfSongs());
    }

    private LinkedList<String> getInterpreters(){
        LinkedList<String> interpreters = new LinkedList<String>();
        for(Song s: songs){
            if(!interpreters.equals(s.getInterpret()))
                interpreters.add(s.getInterpret());
        }
        return interpreters;
    }

    public int getNumberOfSongsByInterpreter(String interpreter){
        int numberOfSongs = 0;
        for(Song s: songs){
            if(s.getInterpret().equals(interpreter))
                numberOfSongs++;
        }
        return numberOfSongs;
    }

    public LinkedList<Song> getSongsByInterpreter(String interpreter){
        LinkedList<Song> songsByInterpreter = new LinkedList<Song>();
        for(Song s: songs){
            if(s.getInterpret().equals(interpreter))
                songsByInterpreter.add(s);
        }

        return songsByInterpreter;
    }

    public LinkedList<Song> getSongsByString(String searchterm){
        LinkedList<Song> songsByString = new LinkedList<Song>();
        for(Song s: songs){
            if(s.getName().contains(searchterm))
                songsByString.add(s);
        }

        return songsByString;
    }
}
