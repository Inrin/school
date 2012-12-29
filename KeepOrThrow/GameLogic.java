import javax.swing.JOptionPane;
/**
 * Responsible for gamemanagement.
 */
public class GameLogic
{
	/** The three needed Stacks for playing KeepOrThrow */
	private Stack mixedStack, keepStack,throwStack;

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
	 * Keep the current top card on the mixedStack(Place it on keepStack).
	 */
	public void keep(){
		if(!mixedStack.isEmpty()){
			if(!keepStack.isEmpty()){
				if(mixedStack.peek().getValue() > keepStack.peek().getValue())
					keepStack.push(mixedStack.pop());
				else
					JOptionPane.showMessageDialog(null,"Not allowed. Card is equal or smaler than previous!");
			}else{
				keepStack.push(mixedStack.pop());
			}
		}else{
			JOptionPane.showMessageDialog(null,"Stack is empty!");
		}
	}

	/**
	 * Throw the current top card on the mixedStack away(Place it on throwStack).
	 */
	public void dump(){
		if(!mixedStack.isEmpty())
			throwStack.push(mixedStack.pop());
		else 
			JOptionPane.showMessageDialog(null,"Deck is empty!");
	}

	/**
	 * Count cards on keepStack.
	 */
	public void count(){
		int counter = 0;
		if(!keepStack.isEmpty()){
			Card temp = keepStack.peek();
			while(temp.getNext() !=null){
				counter++;
				temp = temp.getNext();
			}
			JOptionPane.showMessageDialog(null,counter);
		}else
			JOptionPane.showMessageDialog(null, "Empty");
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

	/**
	 * Do all the things needed to start a new game.
	 */
	private void gameInit(){
		mixedStack = new Stack();
		keepStack = new Stack();
		keepStack.push(new Card(0));
		throwStack = new Stack();
		throwStack.push(new Card(0));

		for(int i=1; i<53; i++){
			mixedStack.push(new Card());
		}
	}
}
