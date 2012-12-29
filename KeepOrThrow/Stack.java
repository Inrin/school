
/**
 * Stack of cards
 */
public class Stack
{
	private Card top;

	public Stack(){
		this.top = null;
	}

	/**
	 * Check emptiness.
	 * 
	 * @return true if empty
	 */
	public boolean isEmpty(){
		return (top!=null) ? false : true;
	}

	/**
	 * Get the top card and put it back on this stack.
	 * 
	 * @return Topcard
	 */
	public Card peek(){
		return top;
	}

	/**
	 * Give the topcard, don't put it back.
	 */
	public Card pop(){
		if(top!=null){///**
			Card temp = top;
			top = top.getNext();
			temp.setNext(null);
			return temp;
		}else{
			return null;
		}//*/
	}

	/**
	 * Put a Card on this Stack.
	 */
	public void push(Card c){
		if(c!=null){
			if(top == null){
				top = c;
			}else{
				c.setNext(top);
				top = c;
			}
		}else{
			System.out.println("Must be a card!");
		}
	}
}

