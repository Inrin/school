public class Salia {
	private Eingabeleser in;
	private Beantworter out;

	public Salia(){
		in = new Eingabeleser();
		out = new Beantworter();
	}

	public Salia(String prompt){
		in = new Eingabeleser(prompt);
		out = new Beantworter();
	}

	private void greeting(String whatisSalia){
		System.out.println(" Hallo!\n\n Mein Name ist Salia.\n Ich bin dein persönlicher " + whatisSalia);
	}

	private void valediction(){
		System.out.println("\tEs war mir ein Vergnügen.\n\nLass uns das wiederholen :)");
	}

	public void init(){
		greeting("Ansprechpartner");
		String s = null;
		do{
		s = in.gibEingabe();
		System.out.println(out.gibAntwort(s));
		} while(!s.equals("exit") && s != null);
		valediction();
	}
}
