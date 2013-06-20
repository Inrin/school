/**
 * Simple Programm to calculate factorial
 *
 * */
public class Fakult{

	/**
	 *
	 * Recursively calculates factorial
	 *
	 * @param n is natural in n!
	 * @return factorial
	 * 
	 * */
	public int calcFakult(int n){
		if(n==1){
			return 1;
		}else{
			return n*calcFakult(n-1);
		}
	}

	/**
	 *
	 * Main method
	 *
	 * @param args Get user param before execution
	 *
	 * */
	public static void main(String[] args){
		int firstArg = 0;
		if(args.length > 0){
			try {
				firstArg = Integer.parseInt(args[0]);
			} catch (NumberFormatException e){
				System.err.println("Argument" + " must be a integer");
				System.exit(1);
			}
		}

		Fakult f = new Fakult();
		System.out.println(f.calcFakult(firstArg));

	}

}	
