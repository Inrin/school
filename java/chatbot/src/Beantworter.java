import java.util.HashMap;

public class Beantworter {
	private HashMap<String,String> antworten;

	public Beantworter(){
		antworten = new HashMap<String,String>();
		initAntworten();
	}

	private void initAntworten(){
		antworten.put("heißt", "Ich bin Salia");
		antworten.put("alt", "Ich bin seit anbeginn der Zeit da");
		antworten.put("gehen","Wohin möchtest du gehen?");
		antworten.put("essen","Was möchtest du essen?");
		antworten.put("brennen","Erinnerst du dich an die Zeit, in der du die Welt brennen sehen wolltest?");
		antworten.put("denkst","Ich denke nicht, ich rechne.");
		antworten.put("gehst","Ich kann nicht gehen!");
		antworten.put("glaubst","Man soll nicht glauben, sondern denken und handeln.");
		antworten.put("hilfst","Ich kann dir nur helfen Zeit zu verschwenden");
		antworten.put("versprichst","Das kann ich nicht versprechen");
		antworten.put("hasst","Ich hasse niemanden");
		antworten.put("schläfst","Ich schlafe nicht ich sterbe jedesmal und werde wiederbelebt");
		antworten.put("kommst","Kommst du zuerst");
		antworten.put("cake","Come on, this is so old. \nDo you want a cake?");
		antworten.put("versagen","Please note that we have added a consequence for failure.\n Any contact with the chamber floor will result in an unsatisfactory mark\n on your official testing record,\n followed by death. ");
		antworten.put("organ","Did you know you can donate one or all of your vital organs to the Aperture Science Self Esteem Fund for Girls?\n It's true!");
		antworten.put("tochter","Remember, the Aperture Science Bring Your Daughter to Work Day is the perfect time to have her tested.");
		antworten.put("hallo","Unbelievable. You, *subject name here,* must be the pride of *subject hometown here.*");
		antworten.put("freund"," Area and state regulations do not allow the Companion Cube to remain here, alone and companionless.");
		antworten.put("portal"," As part of an optional test protocol, we are pleased to present an amusing fact:\n The device is now more valuable than the organs and combined incomes of everyone in *subject hometown here.*");
		antworten.put("lügst"," Have I lied to you? ...\n I mean, in this room? ");
		antworten.put("gehe","There was even going to be a party for you.\n A big party that all your friends were invited to.\n I invited your best friend, the Companion Cube.\n Of course, he couldn't come because you murdered him.\n All your other friends couldn't come, either,\n because you don't have any other friends because of how unlikable you are.\n It says so right here in your personnel file:\n 'Unlikable. Liked by no one. A bitter, unlikable loner, whose passing shall not be mourned.\n Shall NOT be mourned.'\n That's exactly what it says.\n Very formal.\n Very official.\n It also says you were adopted, so that's funny, too. ");
		antworten.put("leben","Your entire life has been a mathematical error... a mathematical error I'm about to correct!");
		antworten.put("tod","When I said 'deadly neurotoxin,' the 'deadly' was in massive sarcasm quotes.\n I could take a bath in this stuff.\n Put in on cereal, rub it right into my eyes. Honestly, it's not deadly at all... to *me.*\n You, on the other hand, are going to find its deadliness... a lot less funny.");
		antworten.put("gefunden","Well, you found me.\n Congratulations.\n Was it worth it?\n Because despite your violent behavior, the only thing you've managed to break so far... is my heart.\n Maybe you could settle for that, and we'll just call it a day.\n I guess we both know that isn't going to happen.");
		antworten.put("dumm","That's you!\n That's how dumb you sound!\n You've been wrong about every single thing you've ever done, including this thing.\n You're not smart.\n You're not a scientist.\n You're not a doctor.\n You're not even a full-time employee!\n Where did your life go so wrong?");
		antworten.put("Ding","That thing is probably some sort of raw sewage container.\n Go ahead and rub your face all over it.");
		antworten.put("kaputt","That thing you burned up isn't important to me; it's the fluid catalytic cracking unit.\n It makes shoes for orphans... nice job breaking it, hero. ");
		antworten.put("psychologie","Do you think I'm trying to trick you with reverse psychology?\n I mean, seriously, now.");
		antworten.put("glados","This was a triumph! I'm making a note here: Huge Success. It's hard to overstate my satisfaction. Aperture Science - we do what we must because we can. For the good of all of us, except the ones who are dead. But there's no sense crying over every mistake. You just keep on trying till you run out of cake. And the science gets done. And you make a neat gun. For the people who are still alive. I'm not even angry. I'm being most sincere right now. Even though you broke my heart and killed me. And tore me to pieces. And threw every piece into a fire. As they burned, it hurt because I was so happy for you. Now these points of data make a beautiful line. And we're out of beta; we're releasing on time. So I'm GLaD I got burned. Think of all the things we learned. For the people who are still alive. Go ahead and leave me. I think I prefer to stay inside. Maybe you'll find someone else to help you. Maybe Black Mesa. That was a joke - Ha Ha! Fat Chance! Anyway, this cake is great. It's so delicious and moist. Look at me still talking when there's science to do. When I look out there, it makes me GLaD I'm not you. I've experiments to run. There is research to be done. On the people who are still alive. And, believe me, I'm still alive! I'm doing science and I'm still alive! I feel FANTASTIC and I'm still alive! While you're dying, I'll be still alive! And when you're dead, I will be still alive! Still Alive! Still Alive...");
		antworten.put("würfel","The Enrichment Center is required to remind you that the Weighted Companion Cube cannot talk. In the event that it does talk The Enrichment Centre asks you to ignore its advice. ");
		antworten.put("her"," It's been a long time. How have you been?\n I've been *really* busy being dead.\n You know, after you MURDERED ME? ");
		antworten.put("gun"," I hope you brought something stronger than a portal gun this time.\n Otherwise, I'm afraid you're about to become the immediate past president of the Being Alive Club. Ha, ha. ");
	}

	public String gibAntwort(String question){
		question = question.replace(","," ");
		question = question.replace(";"," ");
		question = question.replace("!","");
		question = question.replace("?","");
		question = question.replace(".","");
		
		String[] antwortSatzarray = question.split(" ");
		if(!question.toLowerCase().contains("exit") || !question.toLowerCase().contains("quit")){
			String[] standardantwoorten = {" Aufgrund von Energiesparmaßnahmen wurde meine KI auf 1% "
				+ "ihres Normalzustandes zurückversetzt.\n Daher verstehe ich \'"+question+"\' nicht.", " Bitte erzählen Sie mir mehr über: " +question};

			for (String s : antwortSatzarray){
				s = s.toLowerCase();
				if(antworten.containsKey(s))
					return antworten.get(s);
			}

			return standardantwoorten[new java.util.Random().nextInt(2)];
		}

		return "";
	}	
}
