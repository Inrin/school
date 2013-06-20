public class Starwarsname {
	private String name, surname, maiden, hometown;

	public Starwarsname(String name, String surname, String maiden, String hometown){
		this.name = name;
		this.surname = surname;
		this.maiden = maiden;
		this.hometown = hometown;
	}

	public String generateName(){
		CharSequence nameprefix = surname.subSequence(0,3);
		CharSequence namesuffix = name.subSequence(0,2);
		CharSequence surnameprefix = maiden.subSequence(0,2);
		CharSequence surnamesuffix = hometown.subSequence(0,3);

		String starwarsname = nameprefix.toString() + namesuffix.toString() + " " + surnameprefix.toString() + surnamesuffix.toString();
		return starwarsname;
	}

	public static void main (String [] args)
	{
		if(args.length == 4){
		Starwarsname s = new Starwarsname(args[0],args[1],args[2], args[3]);
		System.out.println(s.generateName());
		}else{
			System.out.println("usage: java Starwarsname name surname maidenname hometown");
		}
	}
}
