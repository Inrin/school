import javax.swing.JOptionPane;
/**
 * Responsible for gamemanagement.
 */
public class GameLogic
{
    /** The three needed Stacks for playing KeepOrThrow */
    private Stack mixedStack, keepStack,throwStack;
    private int errors;

    public GameLogic(){
        gameInit();
    }

    /**
     * View the current top card of mixedStack
     */
    public int view(){
        return (!mixedStack.isEmpty()) ? mixedStack.peek().getValue() : 0;
    }

    /**
     * View the current suite of top card of mixedStack
     */
    public int viewSuite(){
        return (!mixedStack.isEmpty()) ? mixedStack.peek().getSuite() : 0;
    }

    /**
     * Keep the current top card on the mixedStack(Place it on keepStack).
     */
    public void keep(){
        if(!mixedStack.isEmpty()){
            if(!keepStack.isEmpty()){
                int mvalue = mixedStack.peek().getValue();
                int kvalue = keepStack.peek().getValue();
                int msuite = mixedStack.peek().getSuite();
                int ksuite = keepStack.peek().getSuite();
                if(mvalue > kvalue)
                    keepStack.push(mixedStack.pop());
                else if(mvalue >= kvalue && msuite != ksuite)
                    keepStack.push(mixedStack.pop());
                else
                    JOptionPane.showMessageDialog(null,"Not allowed. Card is equal or smaler than previous!"
                    ,"Not allowed."
                    ,JOptionPane.PLAIN_MESSAGE);
            }else{
                keepStack.push(mixedStack.pop());
            }
        }else{
            JOptionPane.showMessageDialog(null
            ,"Mxed stack is empty!"
            ,"Stack is empty!"
            ,JOptionPane.PLAIN_MESSAGE);
            errors++;
        }
    }

    /**
     * Throw the current top card on the mixedStack away(Place it on throwStack).
     */
    public void dump(){
        if(!mixedStack.isEmpty()){
            throwStack.push(mixedStack.pop());
        }else{
            JOptionPane.showMessageDialog(null,"Mixed sktack is empty!","Stack is empty!",JOptionPane.PLAIN_MESSAGE);
            errors++;
        }
    }

    /**
     * Count cards on keepStack.
     */
    public int count(){
        int counter = 0;
        if(!keepStack.isEmpty()){
            Card temp = keepStack.peek();
            while(temp.getNext() !=null){
                counter++;
                temp = temp.getNext();
            }
            return counter;
        }else{
            JOptionPane.showMessageDialog(null,"Keepdtack is empty!","Empty",JOptionPane.PLAIN_MESSAGE);
            errors++;
            return 1;
        }
    }

    protected Stack getMixedStack(){
        return mixedStack;
    }

    protected Stack getKeepStack(){
        return keepStack;
    }

    protected Stack getThrowStack(){
        return throwStack;
    }

    public int getErrors(){
        return errors;
    }

    /**
     * Do all the things needed to start a new game.
     */
    private void gameInit(){
        mixedStack = new Stack();
        keepStack = new Stack();
        keepStack.push(new Card(0,0));
        throwStack = new Stack();
        throwStack.push(new Card(0,0));

        for(int i=1; i<53; i++){
            mixedStack.push(new Card());
        }
    }
}
