public class Argument{
    private String argument;
    private int relevance;

    public Argument(String argument, int relevance){
        setArgument(argument);
        setRelevance(relevance);
    }

    /**
     * Set argument of this.
     * 
     * @param argument as String must be not empty
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
     * @param relevance as int, between 1(smallest) to 10(biggest) relevance
     */
    private void setRelevance(int relevance){
        if(relevance > 0 && relevance < 11)
            this.relevance = relevance;
        else
            System.err.println("Relevance must be between 1-10");
    }

    public String getArgument(){
        return argument;
    }

    public int getrelevance(){
        return relevance;
    }
}
