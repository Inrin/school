public class Beantworter {
	public String gibAntwort(String question){
		if(!question.equals("exit"))
		return " Aufgrund von Energiesparmaßnahmen wurde meine KI auf 1% "
			+ "ihres Normalzustandes zurückversetzt.\n Daher verstehe ich "+question+" nicht.";
		return "";
	}	
}
