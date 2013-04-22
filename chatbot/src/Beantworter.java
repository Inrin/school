import java.util.HashMap;

public class Beantworter {
	private HashMap<String,String> antworten;

	public Beantworter(){
		antworten = new HashMap();
	}

	public String gibAntwort(String question){
		if(!question.toLowerCase().contains("exit") || !question.toLowerCase().contains("quit")){
			String[] standardantwoorten = {" Aufgrund von Energiesparmaßnahmen wurde meine KI auf 1% "
				+ "ihres Normalzustandes zurückversetzt.\n Daher verstehe ich \'"+question+"\' nicht.", " Bitte erzählen Sie mir mehr über: " +question};

			if(antworten.containsKey(question))
				System.out.println(antworten.get(question));
					
			return standardantwoorten[new java.util.Random().nextInt(2)];
		}

		return "";
	}	
}
