
public class Aufgaben
{
	private int[] generatePower2(){
		int[] returnInt = new int[100];
		for (int i=0; i<returnInt.length;i++)
			returnInt[i] = i*i;

		return returnInt;
	}

	private void printRandomInts(){
		int[] j = Generator.getZufallszahlen();	
		for (int i : j) 
			System.out.println(i);
	}

	private void bark(){
		Hund[] hunde = Generator.getHunde();
		for (Hund h : hunde) 
			h.bellen();	
	}


	public static void main (String [] args)
	{
		System.out.println("## Aufgabe a)");
			Aufgaben a = new Aufgaben();
		int[] j = a.generatePower2();
		for (int i=99; i>=0; i--) 
			System.out.println(j[i]);
		

		System.out.println("## Aufgabe b");
		a.printRandomInts();

		System.out.println("==========================================================");
		a.bark();
	}
}
