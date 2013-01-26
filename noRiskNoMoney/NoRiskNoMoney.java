import java.util.Random;
import java.io.*;

public class NoRiskNoMoney{
	private boolean[] field = new boolean[6];
	private boolean allowed = true;
	private boolean showMenu = true;

	public NoRiskNoMoney(){
		for(int i=0; i<field.length; i++)
			field[i] = false;
	}

	public void dice(){
		if(allowed){
			int r = new Random().nextInt(6);

			if(!field[r])
				field[r] = true;
			else
				allowed = false;
		}

	}

	public void printField(){
		System.out.println("================================");
		System.out.println("* Welcome to No Risk No Money! *");
		System.out.println("================================\n");
		System.out.println("\t+---+---+");
		for(int i=0; i<5;){
			System.out.println("\t| " + ((!field[i] ? i+1 : "X") + " | " + ((!field[++i]) ?  i+1: "X") + " |"));
			i++;
		}
		System.out.println("\t+---+---+");
		check();
	}

	private void check(){
		if(showMenu){
			if(!allowed)
				System.out.println("\nGame Over!\nType r to restart\nType q to exit");
			else
				System.out.println("\nType d to dice\nType m to disable/enable this menu\nType q to exit");
		}

		try{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			String choice = in.readLine();
			switch(choice){
				case "q":
				case "Q":
					System.exit(0);
					break;
				case "r":
				case "R":
					for(int i=0; i<field.length; i++)
						field[i] = false;
					allowed = true;
					printField();
					break;
				case "d":
				case "D":
					dice();
					printField();
					break;
				case "m":
				case "M":
					showMenu = (showMenu) ? false : true;
					printField();
					break;
				default:
					System.out.println("Please only use given options.");
					check();
					break;
			}

		}catch(IOException e){
			System.err.println("Input error");
		}   
	}

	public static void main (String [] args)
	{
		NoRiskNoMoney n = new NoRiskNoMoney();

		n.printField();
	}
}
