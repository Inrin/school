import java.util.*;
import java.io.*;

public class Person {
    //Attribute
    private String name, choice;
    private int tag, monat, jahr;
    private double groesse, gewicht;
    private boolean istMann;
    private String[] bmiV = { "Untergewicht", "Normalgewicht", "Uebergewicht", "Adipositas", "massive Adipositas", };
    //Horodb
    private String[] horoWid = {"Der Widder ist sein ganzes Leben im Flegelalter, er liebt derbe Späße.\n"
            +"Den Kumpel mal eben in den reißenden Gebirgsbach schubsen, das Feuerzeug in abgehende Winde am Hosenboden halten\n"
            +"oder ein ketchupblutendes Bein aus dem Kofferraum hängen lassen,\n"
            +"das sind herzhafte VergnÜgen nach Widderart." 
        ,"Ihre finanzielle Situation will einfach nicht besser werden.\n"
            +"Egal wieviel Sie arbeiten – es bleibt nie genug Geld zum Sparen Übrig.\n"
            +"Bevor Sie nun eine Bank Überfallen, oder vielleicht sogar selber eine Bank grÜnden\n"
            +"(was wohl ein noch größeres Verbrechen ist), sollten Sie Über die Eröffnung eines Kontos bei der Samenbank nachdenken.\n"
            +"Da geht das Sparen ganz leicht von der Hand."
        ,"Widder sind agil und energisch. Dadurch nerven sie oft ihre Umgebung.\n"
            +"Ihr mäßiger IQ fällt sofort auf, da sie mit vielen Worten sehr wenig sagen.\n"
            +"Widder reden viel und schnell.\n"
            +"Man hat oft das GefÜhl, sie wollten in fÜnf Minuten alles aus- plaudern,\n"
            +"was sie im Kopf haben.\n"
            +"Die meisten Widder-Menschen schaffen das auch spielend, da sie nicht viel drin haben.\n \n"
            +"Idealberuf: Spion (wer nichts weiß, der kann auch nichts verraten!)"};

    private String[] horoSti = {"Mundart-Theater beim Heimatverein mit Bewirtung, so lässt sich's gut lachen!\n"
            +"Traditioneller solider Humor, der zu Bier und Hausmannskost passt und sich seit Jahrzehnten in seiner Bodenständigkeit bewährt hat.\n"
            +"Das StÜck sollte recht lang sein, der Stier muss die Pointen erst sacken lassen, und wer zuletzt lacht, lacht schließlich am besten."
        ,"NatÜrlich sind Sie das ganze Jahr Über eine Pappnase, aber jetzt haben Sie auch die Möglichkeit so rum zu laufen.\n"
            +"Als trauriger Rotnasenclown werden Sie Ihrer Rolle absolut gerecht.\n"
            +"Ne abgerissene Hose und ein Oberteil bei dem Lagerfeld vor entsetzen in Ohnmacht fallen wÜrde.\n"
            +"So gewinnen Sie garantiert den ersten Preis im KostÜmwettbewerb.\n"
            +"Nur gut, dass keiner merkt, dass Sie sich gar nicht verkleidet haben."
        ,"Stiere sind Praktiker und Kämpfer. Sie haben meist einen derben Humor.\n"
            +"Probleme lösen sie lieber mit den Händen als mit Diplomatie.\n"
            +"Wo es was zu verdienen gibt, sind sie dabei. Koste es, wer's bezahlt.\n"
            +"Entspannung finden sie weniger am Strand, als bei der Spaghetti-Ernte. Idealberuf: Möhrchentester bei Hipp"};

    private String[] horoZwi = {"Geteilter Spaß ist doppeltes VergnÜgen.\n"
            +"Zwillinge sind geborene Klassenkasper und kommen schon mit einem Witz auf den Lippen zur Welt.\n"
            +"Man versteht sie bloß noch nicht so gut.\n"
            +"Mitteilsam verbreitete ein Zwilling freche SprÜche und doppeldeutige Anspielungen per Firmen-Rundbrief\n"
            +"- ab nächstem Ersten ist er freigestellt."                            
        ,"Sie waren im Tattoo-Shop und haben sich ein wunderschönes chinesisches Symbol auf den Hintern stechen lassen.\n"
            +"Noch schöner wäre es, wenn Sie sich nicht gerade das Zeichen fÜr Ente sÜß-sauer ausgesucht hätten.\n"
            +"In Ihrem Fall hätte das Symbol fÜr Pferdehintern in Aspik auch viel besser gepasst.\n"
            +"Aber Kopf hoch!\n"
            +"Sollten Sie jemals nach China fahren, können Sie jetzt Ihr Lieblingsessen bestellen, indem Sie dem Kellner Ihren blanken Hintern zeigen."
        ,"Zwillinge halten sich fÜr witzige und unwiderstehliche Menschen. Dabei verwechseln sie ihre abgesonderten Plattheiten mit göttlicher Weisheit.\n"
            +"Denken ist fÜr sie Luxus.\n"
            +"Bei einer Umfrage hielten die meisten Zwillinge den sauren Regen fÜr einen verärgerten ehemaligen US-Präsidenten.\n"
            +"Ihr geistiges Niveau liegt irgendwo zwischen andalusischen Regenwurm und mitteleuropäischen KÜchenschabe.\n"
            +"Idealberuf: Schlagersternchen(Wie ein Stern in ein Sommernacht..., wie war das noch???)"};

    private String[] horoKre = {"Topfschlagen, Wurstschnappen und SackhÜpfen, beim Spielen bleibt der Krebs ewig Kind.\n"
            +"Wenn die lieben Kleinen Spaß haben, dann freuen sich die Großen erst recht.\n"
            +"Das 84-jährige Urgroßväterchen hat Über den bestellten Clown an seinem Wiegenfeste so fröhlich gelacht...\n"
            +"Das Gebiss musste man später aus der Bowlenschale fischen."
        ,"Es wird Zeit fÜr einen neuen Look.\n"
            +"Mutieren Sie doch einfach zu einer Person, mit der Sie frÜher nicht hätten spielen dÜrfen.\n"
            +"Mit schräger Frisur und soviel Metall im Gesicht, dass Sie durch keine Flughafenkontrolle mehr kommen, und dazu ein skandalöses Lederoutfit.\n"
            +"Sie wissen ja: „Jeder Mensch kann fÜr 5 Minuten berÜhmt sein.“\n"
            +"– Notfalls halt auch in einer Talkshow zum Thema: „Hilfe, jetzt bin total selbstverwirklicht.“"
        ,"Krebse sind leichtgläubig und dadurch oft beliebt. Mit ihnen kann man alles machen.\n"
            +"Vertreter geraten in VerzÜckung, wenn sie merken, dass sie einen Krebs vor sich haben.\n"
            +"Die Rente ist gerettet... Der IQ liegt knapp Über dem eines Kieselsteines (IQ=4, Mensch=100)\n"
            +"Das gute Gedächtnis ist zwangsläufig antrainiert und die einzige Chance, nicht ganz unterzugehen.\n"
            +"Er kann mit MÜhe angelernt werden, ein BÜgeleisen unfallfrei einzuschalten. Idealberuf: FilmvorfÜhrer im Kino(fÜr'n Knopfdruck reicht's)\n"};

    private String[] horoLoe = {"FÜr Spiel und Spaß ist in seinem Leben immer Raum, möglichst der Thronsaal.\n"
            +"Der Zirkuslöwe will sein Publikum vor Lachen zum BrÜllen bringen und selber im Rampenlicht glänzen.\n"
            +"Lustige Sketche präsentiert er auf Familienfesten, zu Abschlussfeten, an bunten Abenden, und wenn ihn keiner zurÜckhält, auch bei Trauerfeiern."
        ,"Sie planen fÜr Ihre Familie ein warmes Nest, idyllisch im GrÜnen, aber die Geldbörse klemmt?\n"
            +"Dann fangen Sie doch schon mal mit nem Camping-Grill an, und wenn sie dann noch ein tolles 3-Mann-Zelt Ihr Eigen nennen,\n"
            +"können Sie ja zumindest schon mal im GrÜnen wohnen.\n"
            +"Denken Sie immer dran:\n"
            +"Die Luftschlösser von Heute sind die Villen von Morgen."
        ,"Der Löwe versucht durch GroßzÜgigkeit von seiner mangelnden Intelligenz abzulenken.\n"
            +"Seine scheinbare Lässigkeit und Behäbigkeit sind Tarnung.\n"
            +"In Wirklichkeit braucht er die Zeit zum Überlegen.\n"
            +"Mit Musik hat er nichts am Hut.\n"
            +"FÜr ihn klingt jeder Ton gleich und Pavarotti hält er fÜr eine Nudelsorte.\n"
            +"Sein Gerede hat kaum mehr geistigen Gehalt als eine Tasse heiße Luft.\n"
            +"Idealberuf: Beamter"};

    private String[] horoJun = {"Nur weil Lachen gesund ist und als Seelenreiniger gute Dienste leistet, wird Humor zugelassen.\n"
            +"Aber bitte sparsam und der Situation angemessen, denn auch hier gilt, wie die kluge Jungfrau weiß:\n"
            +"Die Dosis macht das Gift!\n"
            +"Es sollen sich ja schon der eine oder die andere totgelacht haben und das ist doch recht unvernÜnftig."
        ,"Sie gehen zur Fußpilzbehandlung zum Arzt, wo Sie aufgrund eines kleinen Irrtums mit dem Patienten verwechselt werden,\n"
            +"der sich einer Geschlechtsumwandlung unterziehen wollte.\n"
            +"Aber Ihr Arzt erkennt den Fehler\n"
            +"(nach der OP)\n"
            +"und erlässt Ihnen dafÜr kulanter Weise die 10 Euro PraxisgebÜhr und heißt Sie in Ihrem neuen Körper willkommen.\n"
            +"Ansonsten ist Ihr Monat relativ ruhig."
        ,"Die ausgeprägte Bauernschläue der Jungfrau, wird oft mit echter Intelligenz verwechselt - aber eben nur von ihr selbst.\n"
            +"Bei genauerem Hinsehen bleibt davon nicht viel Übrig.\n"
            +"Ihre Unbeholfenheit verhindert dann auch letztlich noch mögliche Erfolge.\n"
            +"Die Ordnungsliebe ist bei ihr absolut wichtig, weil sie dazu noch Über eine schon phänomenale Gedächtnisschwäche verfÜgt.\n"
            +"(Dr. Alzheimer war Jungfrau!)\n"
            +"Idealberuf: Abschmecker in der Kläranlage.\n"
            +"(Die merken auch nichts mehr...)\n"};

    private String[] horoWaa = {"Viele verschiedene Darbietungen auf hohem kÜnstlerischen Niveau zu einer Einheit zusammengefÜgt, das macht der Waage Freude!\n"
            +"AmÜsement in vollendeter Harmonie und Schönheit kann gern oberflächlich bleiben.\n"
            +"Es soll schließlich elegante Unterhaltung bieten und nur ja keine Angriffsfläche fÜr unhöfliche Kritik."
        ,"Sie gehen zur Fußpilzbehandlung zum Arzt, wo Sie aufgrund eines kleinen Irrtums mit dem Patienten verwechselt werden,\n"
            +"der sich einer Geschlechtsumwandlung unterziehen wollte.\n"
            +"Aber Ihr Arzt erkennt den Fehler\n"
            +"(nach der OP)\n"
            +"und erlässt Ihnen dafÜr kulanter Weise die 10 Euro PraxisgebÜhr und heißt Sie in Ihrem neuen Körper willkommen.\n"
            +"Ansonsten ist Ihr Monat relativ ruhig."
        ,"Die Waage ist ein Träumer und Schöngeist.\n"
            +"Sie ist musisch veranlagt und hat fÜr praktische Dinge wenig Sinn,\n"
            +"da diese meist mit Arbeit (ihgitt) verbunden sind. Eckt deshalb oft mit Stieren an. Der ihr nachgesagte Gerechtigkeitssinn ist Schein.\n"
            +"Die Waage ist bei Problemfällen einfach zu faul, Über eine Lösung nachzudenken und versucht die Situation durch Schlichtung zu entschärfen.\n"
            +"Gott sei dank lässt ihre eigene Intelligenz zumindest brauchbare Notlösungen zu. Idealberuf: Pflastermaler oder Sänger"};

    private String[] horoSko = {"So ein kleines intrigantes Machtspielchen gegen Kollegen anzetteln oder als bittersÜße Rache eine Todesanzeige\n"
            +"der noch lebenden Ex-Beziehung in die Tageszeitung bringen - fÜr den Skorpion gilt kein Tabu.\n"
            +"Wer sich mit ihm einen Scherz erlauben will, fÜr den hört der Spaß auf, wenn er fÜr den Skorpion anfängt.\n"
            +"Denn Schadenfreude ist das reinste VergnÜgen."
        ,"Auf der Suche nach den neusten Modetrends landen Sie unweigerlich beim örtlichen Zeltverleih,\n"
            +"denn der GÜrtel, den sich andere enger schnallen mÜssen, passt Ihnen doch schon lange nicht mehr.\n"
            +"Also schwingen Sie sich in Ihre viel zu enge Jogging-Plane und trainieren Sie,\n"
            +"bis Sie auch in menschlichen Kleidergrößen wieder gut aussehen."
        ,"Skorpione sind meist rÜcksichtslos und verschlagen.\n"
            +"Ihr geistiges Niveau bewegt sich auf dem Level eines toten Huhnes und ihr bescheidenes Quantum an Denkvermögen ist absolut notwendig,\n"
            +"um Wege zu finden, den vielen Feinden zu entkommen.\n"
            +"Skorpione werden meist in jungen Jahren ermordet. Idealberuf: Klötzchentester in Legoland"};

    private String[] horoSch = {"Großspurig und Übertrieben scherzt der SchÜtze, schreibt lustige SinnsprÜche in lebensgroßen Buchstaben auf Straßenkreuzungen,\n"
            +"bucht am 1. April im ReisebÜro einen Flug fÜr eine 17-köpfige Elefantenfamilie in den Europapark und wird erst im letzten Augenblick erwischt,\n"
            +"ehe er mit dem Fallschirm von der Eiffelturmspitze abspringt."
        ,"Mit Ihrem Gesichtsausdruck könnte man ganze Modellwettbewerbe lahmlegen.\n"
            +"Mal im Ernst, Ihre Mundwinkel sind so verkniff en, dass man glauben könnte,\n"
            +"man hätte Ihnen schon vor Wochen eine Flasche Rizinusöl eingetrichtert\n"
            +"und dann das Arschloch zugenäht.\n"
            +"Entspannen Sie sich mal ein bisschen,\n"
            +"und versuchen Sie es mit einem Lächeln."
        ,"SchÜtzen sind optimistisch und kritiklos, was ein Zeichen von Nähe zur Debilität sein kann.\n"
            +"Sie gehen oft stÜrmisch an Dinge heran, ohne etwas davon zu verstehen.\n"
            +"Ihre Risikofreude ist bei diesem geistigen Niveau schon Todesmut.\n"
            +"Vorsicht bei Gebrauch von Fremdwörtern!\n"
            +"SchÜtzen halten diese oft fÜr Schimpfworte und schlagen dann häufig vorsichtshalber zu.\n"
            +"Idealberuf: Kellner (höchstens)\n"};

    private String[] horoSte = {"Das Furzkissen bringt den Gast arg in Verlegenheit und die Tischrunde zum Lachen.\n"
            +"Es hÜpfen Teller und ein Wurm kringelt sich im Weinglas, und keiner will's gewesen sein!\n"
            +"Ein Steinbock guckt mit missbilligender Strenge todernst zu und\n lacht sich hinter seiner knochentrockenen Fassade scheckig, weil ihm den Quatsch keiner zutraut."
        ,"GlÜckwunsch zu Ihrer regelmäßigen Verdauung.\n"
            +"Es gibt nur wenige Menschen, die so präzise jeden Morgen um 7 Uhr Stuhlgang haben.\n"
            +"Nur schade, dass Sie immer erst um 8 Uhr aufwachen.\n"
            +"Kaufen Sie sich doch einfach mal einen Wecker, und Sie werden sehen,\n"
            +"dass nicht jeder Tag beschissen anfangen muss."
        ,"Steinböcke sind brav, ehrlich und zurÜckhaltend - und das ist auch gut so!\n"
            +"Denn wären sie zu ihrer grenzenlosen Dummheit auch noch frech, falsch und dreist, wäre ihnen kein langes Leben beschieden.\n"
            +"Steinböcke werden wegen ihrer absoluten Unfähigkeit, ihre verworrenen Gedanken in Worte zu fassen, oft missverstanden.\n"
            +"Der einzige Geist, den sie kennen,\n"
            +"ist der Himbeergeist.(hicks)\n"
            +"Idealberuf: Kaninchensammler\n"};

    private String[] horoWas = {"Schrullige Überraschungen mit technischen Finessen sind seine Spezialität.\n"
            +"Da stehen zwei Polizisten und wollen wissen, ob der Herr des Hauses Funker ist.\n"
            +">>Ja, harmloser Hobbyfunker<<,\n"
            +"sagt Frau Wassermann.\n"
            +"Der Polizist: >>Von wegen harmlos, die gesamte Nato-Flotte läuft gerade aus!!!<<"
        ,"Das FrÜhjahr wird fÜr Sie total spannend.\n"
            +"Wenn Sie ein Mann sind, meckert Ihre Frau nicht mehr mit Ihnen, wenn Sie abends noch mit nem Kumpel in die Kneipe wollen, weil sie mit Ihren Kindern ausgezogen ist.\n"
            +"Ihre minderjährige Tochter eröff net Ihnen, dass Sie bald Opa sind\n"
            +"und der Erzeuger des Enkels wohl irgendwer von der Karnevalsparty sein mÜsste.\n"
            +"Wenn Sie eine Frau sind, sind Sie vermutlich das Mädchen von der Karnevalsparty.\n"
            +"Alles in allem wird die nächste Zeit fÜr Sie wohl alles andere als langweilig."
        ,"Der Wassermann versucht stets, sich mit Übertriebener Freundlichkeit in den Vordergrund zu spielen.\n"
            +"Bei seinem Bonsai-Hirn merkt er nicht, dass sich eigentlich kein Mensch fÜr ihn interessiert.\n"
            +"Er bekommt meist sowieso nicht mit, worum es eigentlich geht. Wenn er morgens die Augen öffnet, verliert er zuerst einmal den Überblick.\n"
            +"Meist hat er schon nach 5 Minuten vergessen, was er Überhaupt wollte.\n"
            +"Muss jeden Montag neu angelernt werden!\n"
            +"Idealberuf: SchlÜsselschnitzer\n"};

    private String[] horoFis = {"Die leicht verfÜhrbaren Fische lieben Magie und Märchen.\n"
            +"Sie lassen sich so gerne belÜgen und betrÜgen, aber im wahren Leben wird ja eher davon abgeraten.\n"
            +"Nur wenn ein ZauberkÜnstler auftritt, oder ein Erzähler aus 1001 Nacht, dann geben sich Fische losgelöst vom harten Alltagschwerelos dem VergnÜgen hin."
        ,"Ihr Diätenwahn hat Sie zu einem wandelnden Symbol fÜr Hunger und Leid auf der Welt gemacht,\n"
            +"und im Park kommen Tauben auf Sie zugeflogen, um Sie zu fÜttern.\n"
            +"Am jÜngsten Tag könnten Sie bei der Auferstehung des Fleisches glatt liegenbleiben, also rein in die Eisdiele oder in die Konditorei und nach Herzenslust naschen.\n"
            +"Andernfalls könnte Sie sich natÜrlich beim Supertalent anmelden und Xylophon auf Ihren eigenen Rippen spielen."
        ,"Fische haben eine sehr hoch entwickelte Sensibilität und nehmen diese als Vorwand, um fehlende Intelligenz zu vertuschen.\n"
            +"Dabei machen sie sich zum Hampelmann der Nation.\n"
            +"Zu allem Unglck sind Fische auch noch so naiv, dass sie gar nicht merken wer sich alles Über sie lustig macht.\n"
            +"Um eine gewisse Schadensbegrenzung bei den Fischen zu erreichen, mÜssen sie ständig beaufsichtigt werden.\n"
            +"In der Öffentlichkeit sind Fische an der Leine zu fÜhren.\n"
            +"Idealberuf: Klofrau/ Mann\n"};
    // Konstruktor
    public Person(String vollerName, int geburtsTag, int geburtsMonat, int geburtsJahr, double groesse, double gewicht, boolean istMann) {
        jahr = geburtsJahr;
        monat = geburtsMonat;                        //Gloable Variablen initiieren
        tag = geburtsTag;
        name = vollerName;
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.istMann = istMann;  

    }    

    public Person()
    {
    }

    public String getErgebnis()
    { 
        if(getAlter() < 25)                                                     //Erst Alter ÜberprÜfen
        {
            if(getBMI() < 19) { return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) { return bmiV[1];}         //Gewichtsklasse wiedergeben
            else if(getBMI() >= 24 && getBMI() < 30) {  return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {  return bmiV[3];}
            else {  return bmiV[4];}
        }
        else if(getAlter() > 24 && getAlter() < 35) 
        {
            if(getBMI() < 19) { return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) {  return bmiV[1];}
            else if(getBMI() >= 24 && getBMI() < 30) {  return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {  return bmiV[3];}
            else {  return bmiV[4];}
        }
        else if(getAlter() > 34 && getAlter() < 45) 
        {
            if(getBMI() < 19) { return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) {  return bmiV[1];}
            else if(getBMI() >= 24 && getBMI() < 30) {  return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {  return bmiV[3];}
            else {  return bmiV[4];}
        }
        else if(getAlter() > 44 && getAlter() < 55) 
        {
            if(getBMI() < 19) { return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) {  return bmiV[1];}
            else if(getBMI() >= 24 && getBMI() < 30) {  return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {  return bmiV[3];}
            else  {  return bmiV[4];}
        }
        else if(getAlter() > 54 && getAlter() < 65) 
        {
            if(getBMI() < 19) {return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) {return bmiV[1];}
            else if(getBMI() >= 24 && getBMI() < 30) {return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {return bmiV[3];}
            else  {return bmiV[4];}
        }
        else  
        {
            if(getBMI() < 19) {return bmiV[0];}
            else if(getBMI() >= 19 && getBMI() < 25) {return bmiV[1];}
            else if(getBMI() >= 24 && getBMI() < 30) {return bmiV[2];}
            else if(getBMI() >= 29 && getBMI() < 40) {return bmiV[3];}
            else  {return bmiV[4];}
        }     
    }

    public int getSternzeichen()
    {
        if(monat == 3 && tag > 20 || monat == 4 && tag < 21)                     //Wiedergabe des Sternzeichens; sortiert nach ekliptikaler Länge -->http://de.wikipedia.org/wiki/Tierkreiszeichen
            return 1; //Widder
        else if(monat == 4 && tag > 20 || monat == 5 && tag < 22)
            return 2; //Stier
        else if(monat == 5 && tag > 21 || monat == 6 && tag < 22)
            return 3; //Zwillinge
        else if(monat == 6 && tag > 21 || monat == 7 && tag < 23)
            return 4; //Krebs
        else if(monat == 7 && tag > 22 || monat == 8 && tag < 24)
            return 5; //Loewe
        else if(monat == 8 && tag > 23 || monat == 9 && tag < 24)
            return 6; //Jungfrau
        else if(monat == 9 && tag > 23 || monat == 10 && tag < 24)
            return 7; //Waage
        else if(monat == 10 && tag > 23 || monat == 11 && tag < 23)
            return 8; //Skorpion
        else if(monat == 11 && tag > 22 || monat == 12 && tag < 22)
            return 9; //SchÜtze
        else if(monat == 12 && tag > 21 || monat == 1 && tag < 21)
            return 10; //Steinbock
        else if(monat == 1 && tag > 20 || monat == 2 && tag < 20)
            return 11; //Wassermann
        else if(monat == 2 && tag > 20 || monat == 3 && tag < 21)
            return 12; //Fische
        else return 0; //Invalid starsign
    } 

    public double getBMI()
    {   
        if(!istMann)                                                    //Berechnung des BMI
        {
            return (gewicht/(groesse * groesse)) - 1;
        }
        else
        {
            return (gewicht/(groesse * groesse));
        }
    }

    public void setGewicht(double gewicht)
    {
        gewicht = this.gewicht;    
    }

    public void setName(String vollerName)
    {
        name = vollerName;
    }

    public int getAlter() {
        // Create a calendar object with the date of birth
        Calendar dateOfBirth = new GregorianCalendar(jahr, monat - 1, tag);
        // Create a calendar object with today's date
        Calendar today = Calendar.getInstance();
        // Get age based on year
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        // Add the tentative age to the date of birth to get this year's birthday
        dateOfBirth.add(Calendar.YEAR, age);
        // If this year's birthday has not happened yet, subtract one from age
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }

    public String getHoroskop()
    {
        int rand = new Random().nextInt(3);

        switch(getSternzeichen()) {
            case 1: return horoWid[rand];    //RÜckgabe eines zufällig gewähltem Horoskopes aus der horodb fÜr das jeweilige Sternzeichen

            case 2: return horoSti[rand];

            case 3: return horoZwi[rand];

            case 4: return horoKre[rand];

            case 5: return horoLoe[rand];

            case 6: return horoJun[rand];

            case 7: return horoWaa[rand];

            case 8: return horoSko[rand];

            case 9: return horoSch[rand];

            case 10:return horoSte[rand];

            case 11:return horoWas[rand];

            case 12:return horoFis[rand];

            default: return "Invalid String";

        }
    }

    public void printInfo() {
        // Alle Infos Über eine Person zusammenfassen
        System.out.println("*******************************************************");
        System.out.println("*            Info Über " + name);
        System.out.println("*******************************************************");
        System.out.println(" " + name + " ist am " + tag + "." + monat + "." + jahr + " geboren");
        System.out.println(" und damit " + getAlter() + " Jahre alt.");
        System.out.println(" Sie haben einen BMI von " + getBMI());
        System.out.println(" Sie haben: " + getErgebnis());
        System.out.println(" Ihr Horoskop lautet:\n " + getHoroskop());
    }

    public void input() {
        System.out.println("*******************************************************");
        System.out.println("*        Willkommen im Personal Info Center!");
        System.out.println("*******************************************************");
        System.out.println("");
        System.out.println("Bitte geben Sie Ihren Vor- und Zunamen ein:");
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( System.in ) );

            name = in.readLine();
            try{
                
                System.out.println("Bitte geben Sie Ihr Geburtsdatum ein: (TT.MM.JJJJ)");
                String geburtsdaten, istMannasc, gewichtasc, groesseasc;
                String[] temp;
                geburtsdaten = in.readLine();
                temp = geburtsdaten.split("\\."); 

                tag = Integer.parseInt(temp[0]);
                monat = Integer.parseInt(temp[1]);
                jahr = Integer.parseInt(temp[2]);
            }
            catch (NumberFormatException e) {
                System.out.println("Bitte geben Sie nur Zahlen nach dem vorgegebenen Schema ein!");
         
            }

            System.out.println("Bitte geben Sie Ihr Gewicht in Kilogramm ein: ");
            String gewichtasc = in.readLine();
            gewicht = Double.parseDouble(gewichtasc);
            System.out.println("Bitte geben Sie Ihre Größe in Meter ein:");
            String groesseasc = in.readLine();
            groesse = Double.parseDouble(groesseasc);
            System.out.println("Sind Sie eine Frau? (J/N)");
            String istMannasc = in.readLine();
            if(istMannasc.equals("j") ^ istMannasc.equals("J"))
                istMann = false;  
            else if(istMannasc.equals("n") ^ istMannasc.equals("N"))
                istMann = true;
            else System.out.println("Bitte geben Sie entweder 'j' oder 'n' oder 'J' oder 'N' ein!");
            System.out.println("Sie haben sich erfolgreich im PIC registriert.");
            check();
        } catch( IOException e ) {
            System.out.println( "Sie haben etwas Falsches eingegeben! :-(" );
        }
    }

    public void check()
    {
        System.out.println("\nNun können Sie Ihr|en..\n"
            +"(H)oroskop erhalten, BMI-(W)ert, BMI-(B)eurteilung oder alle Ihre (I)nformationen zusammen anzeigen lassen.");
        System.out.println("Tippen sie 'exit' ein um das Programm zu beenden.");
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( System.in ) );
            choice = in.readLine();
            if(choice.equals("h") ^ choice.equals("H"))
            {
                System.out.println("");
                System.out.print(getHoroskop());
                check();
            }
            else if(choice.equals("W") ^ choice.equals("w"))
            {
                System.out.println("");
                System.out.println(getBMI());
                check();
            }
            else if(choice.equals("B") ^ choice.equals("b"))
            {
                System.out.println("");
                System.out.println(getErgebnis());
                check();
            }
            else if(choice.equals("I") ^ choice.equals("i"))
            {
                System.out.println("");
                printInfo();
                check();
            }
            else if(choice.equals("exit"))
                System.exit(0);
        }
        catch( IOException e ) {
            System.out.println( "Sie haben etwas Falsches eingegeben! :-(" );
        }
    }  
}