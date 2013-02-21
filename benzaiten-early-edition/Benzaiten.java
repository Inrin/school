import java.util.LinkedList;

public class Benzaiten{
    /** Song library (basically */
    private LinkedList<Song> songs;
    
    /**
     * Creates a new simple musicmanagement.
     */
    public Benzaiten(){
        songs = new LinkedList<Song>();
    }
    
    /**
     * Adds a new Song.
     * 
     * All tags are needed, but can be blank.
     * 
     * @param name of added
     * @param interpreter of added
     * @param isCopyOfCD true if a CD exists with the Song
     * @param duration of added
     */
    public void add(String name, String interpreter, boolean isCopyOfCD, int duration){
        songs.add(new Song(name,interpreter,isCopyOfCD,duration));
    }

    /**
     * Remove Song at specific position in the library.
     * 
     * @param position is the index in this.
     */
    public void remove(int position){
        songs.remove(position);
    }

    /**
     * Count and give the songs.
     * 
     * @return number of all songs
     */
    public int getNumberOfSongs(){
        return songs.size();
    }

    
    /**
     * Prints a nice command-line info.
     */
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

    
    /**
     * Collects and returns all Interpreters in this.
     * 
     * Just needed for the printInfo
     * @see printInfo()
     */
    public LinkedList<String> getInterpreters(){
        LinkedList<String> interpreters = new LinkedList<String>();
        for(Song s: songs){
            if(!interpreters.equals(s.getInterpret()))
                interpreters.add(s.getInterpret());
        }
        return interpreters;
    }

    /**
     * Get number of songs by exact interpreter.
     * 
     * @return number of songs by exact String
     */
    public int getNumberOfSongsByInterpreter(String interpreter){
        int numberOfSongs = 0;
        for(Song s: songs){
            if(s.getInterpret().equals(interpreter))
                numberOfSongs++;
        }
        return numberOfSongs;
    }

    
    /**
     * Get all songs by exact given interpreter.
     * 
     * @return songs by interpreter
     */
    public LinkedList<Song> getSongsByInterpreter(String interpreter){
        LinkedList<Song> songsByInterpreter = new LinkedList<Song>();
        for(Song s: songs){
            if(s.getInterpret().equals(interpreter))
                songsByInterpreter.add(s);
        }

        return songsByInterpreter;
    }

    
    /**
     * Get all songs which match given searchterm.(not exact).
     * 
     * @return songs matched the searchterm.
     */
    public LinkedList<Song> getSongsByString(String searchterm){
        LinkedList<Song> songsByString = new LinkedList<Song>();
        for(Song s: songs){
            if(s.getName().contains(searchterm))
                songsByString.add(s);
        }

        return songsByString;
    }
}
