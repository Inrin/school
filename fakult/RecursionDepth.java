public class RecursionDepth{
	public void calcRecursionDepth(long d){
		try{
			calcRecursionDepth(++d);
		}catch (StackOverflowError e){
			System.out.println("Maximum recursion depth is " + d);
			System.err.println("StackOverflowError occurred");
		}
	}

	public static void main(String[] args){
		RecursionDepth r = new RecursionDepth();
		r.calcRecursionDepth(1);
	}
}
