/**
 *
 * Made to determine the maximum recursion depth
 *
 * */
public class RecursionDepth{
	/**
	 *
	 * Calculate maximum recursion depth, recursively;)
	 * @param d depth to start with
	 *
	 * */
	public void calcRecursionDepth(long d){
		try{
			calcRecursionDepth(++d);
		}catch (StackOverflowError e){
			System.out.println("Maximum recursion depth is " + d);
			System.err.println("StackOverflowError occurred");
		}
	}

	/**
	 *
	 * Main method
	 *
	 * Make a instance of this class and determine maximum recursion depth starting with 1
	 *
	 * @param args unused yet
	 *
	 * */
	public static void main(String[] args){
		RecursionDepth r = new RecursionDepth();
		r.calcRecursionDepth(1);
	}
}
