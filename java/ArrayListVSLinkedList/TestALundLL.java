import java.util.*;

public class TestALundLL{
	ArrayList<Object> alNorm = new ArrayList<Object>();
	ArrayList<Object> alCons = new ArrayList<Object>(10000000);
	LinkedList<Object> ll = new LinkedList<Object>();

	public void alNormAdd(){
		for(int i=0;i<10000000; i++){
			alNorm.add(new Object());
		}
	}

	public void alNormAddAt() {
		for (int i=0; i<10000; i++) {
			alNormAdd();
			alNorm.add((i+10), new Object());
		}
	}

	public void alNormRemoveFirst() {
		for (int i=0; i<10000000; i++){
			alNorm.remove(i);	
		}			
	}

	public void alNormRemoveLast() {
		for (int i=10000000; i>0; i--){
			alNorm.remove(i);	
		}			
	}

	public void alNormRemoveMidLast() {
		for (int i=5000000; i>0; i--){
			alNormAdd();
			alNorm.remove(i);	
		}			
	}

	public void alNormRemoveMidFirst() {
		for (int i=0; i<10000000; i++){
			alConsAdd();
			alCons.remove(i);	
		}			
	}


	public void alConsAdd(){
		for(int i=0;i<10000000; i++){
			alCons.add(new Object());
		}
	}

	public void alConsAddAt() {
		for (int i=0; i<10000; i++) {
			alConsAdd();
			alCons.add((i+10), new Object());
		}
	}

	public void alConsRemoveFirst() {
		for (int i=0; i<10000000; i++){
			alCons.remove(i);	
		}			
	}

	public void alConsRemoveLast() {
		for (int i=10000000; i>0; i--){
			alCons.remove(i);	
		}			
	}

	public void alConsRemoveMidLast() {
		for (int i=5000000; i>0; i--){
			alConsAdd();
			alCons.remove(i);	
		}			
	}

	public void alConsRemoveMidFirst() {
		for (int i=0; i<10000000; i++){
			alConsAdd();
			alCons.remove(i);	
		}			
	}

	public void llAdd(){
		for(int i=0;i<10000000; i++){
			ll.add(new Object());
		}
	}

	public void llAddAt() {
		for (int i=0; i<10000; i++) {
			llAdd();
			ll.add((i+10), new Object());
		}
	}

	public void llRemoveFirst() {
		for (int i=0; i<10000000; i++){
			ll.remove(i);	
		}			
	}

	public void llRemoveLast() {
		for (int i=10000000; i>0; i--){
			ll.remove(i);	
		}			
	}

	public void llRemoveMidLast() {
		for (int i=5000000; i>0; i--){
			llAdd();
			ll.remove(i);	
		}			
	}

	public void llRemoveMidFirst() {
		for (int i=0; i<10000000; i++){
			llAdd();
			ll.remove(i);	
		}			
	}

	public static void main (String [] args){
		TestALundLL t = new TestALundLL();
		if(args.length == 1 ){

			if(args[0].equals("1")){
				System.out.println("ALN add");
				t.alNormAdd();
			}
			if(args[0].equals("4")){
				System.out.println("ALN add at");
				t.alNormAddAt();
			}
			if(args[0].equals("7")){
				System.out.println("ALN remove first");
				t.alNormRemoveFirst();
			}
			if(args[0].equals("10")){
				System.out.println("ALN remvoe last");
				t.alNormRemoveLast();
			}
			if(args[0].equals("13")){
				System.out.println("ALN remove mid first");
				t.alNormRemoveMidFirst();
			}
			if(args[0].equals("16")){
				System.out.println("ALN remove mid last");
				t.alNormRemoveMidLast();
			}
			if(args[0].equals("2")){
				System.out.println("ALC add");
				t.alConsAdd();
			}
			if(args[0].equals("5")){
				System.out.println("ALC add at");
				t.alConsAddAt();
			}
			if(args[0].equals("8")){
				System.out.println("ALC remove first");
				t.alConsRemoveFirst();
			}
			if(args[0].equals("12")){
				System.out.println("ALC remove last");
				t.alConsRemoveLast();
			}
			if(args[0].equals("15")){
				System.out.println("ALC remove mid first");
				t.alConsRemoveMidFirst();
			}
			if(args[0].equals("18")){
				System.out.println("ALC remove mid last");
				t.alConsRemoveMidLast();
			}
			if(args[0].equals("3")){
				System.out.println("LL add");
				t.llAdd();
			}
			if(args[0].equals("6")){
				System.out.println("LL add at");
				t.llAddAt();
			}
			if(args[0].equals("9")){
				System.out.println("LL remove first");
				t.llRemoveFirst();
			}
			if(args[0].equals("11")){
				System.out.println("LL remove last");
				t.llRemoveLast();
			}
			if(args[0].equals("14")){
				System.out.println("LL remove mid first");
				t.llRemoveMidFirst();
			}
			if(args[0].equals("17")){
				System.out.println("LL remove mid last");
				t.llRemoveMidLast();
			}

		}else{
			System.out.println("Please specify testnumber(1-18)");
			System.out.println("java TestALundLL [Testnumber]");

		}
	}
}
