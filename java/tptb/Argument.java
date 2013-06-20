public class Argument{
    private String argument;
    private int relevance;

    /** 
     * Creates this with an argument and it's relevance.
     */
    public Argument(String argument, int relevance){
        setArgument(argument);
        setRelevance(relevance);
    }

    /**
     * Set argument of this.
     * 
     * @param argument must not be empty
     */
    private void setArgument(String argument){
        if(argument != null && !argument.isEmpty())
            this.argument = argument;
        else
            System.err.println("null or \"\" is not permitted");
    }

    /**
     * Set relevance of this.
     * 
     * @param relevance is between 1(smallest) to 10(biggest) relevance
     */
    private void setRelevance(int relevance){
        if(relevance > 0 && relevance < 11)
            this.relevance = relevance;
        else
            System.err.println("Relevance must be between 1-10");
    }

    /**
     * Get this argument
     * 
     * @return argument
     */
    public String getArgument(){
        return argument;
    }

    /**
     * Get the importance
     * 
     * @return relevance
     */
    public int getRelevance(){
        return relevance;
    }
}
