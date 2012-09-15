public class Autobewertung
{
    private String marke;
    private double neupreis, alter, unfaelle, kilometerstandInTausend;

    public Autobewertung(String marke, double neupreis, double alter, double unfaelle, double kilometerstandInTausend) {
        this.marke = marke;
        this.neupreis = neupreis;
        this.alter = alter;
        this.unfaelle = unfaelle;
        this.kilometerstandInTausend = kilometerstandInTausend;
    } 

    public double getPreis() {
        return neupreis*Math.pow(0.93, alter)*Math.pow(0.94, unfaelle)*Math.pow(0.97, kilometerstandInTausend);
    }

    public void setAlter(double newAlter) {
        if(newAlter > 0)
        alter = newAlter;
        else
        System.out.println("Error 33");
    }

    public void setUnfaelle(double newUnfaelle) {
        unfaelle = newUnfaelle;
    }

    public void setkilometerstandInTausend(double newKilometerstand) {
        kilometerstandInTausend = newKilometerstand;
    }

    public String getMarke() {
        return marke;
    }

    public double getNeupreis() {
        return neupreis;
    }

    public double getUnfaelle() {
        return unfaelle;
    }

    public double getkilometerstandInTausend() {
        return kilometerstandInTausend;
    }

    public double getAlter() {
        return alter;
    }
    
    public double getVerlust () {
        return getNeupreis() - getPreis();
    }

    public void getInfo() {
        System.out.println("===============================================");
        System.out.println("*               Autobewertung                 *");
        System.out.println("===============================================");
        System.out.println("");
        System.out.println("Der aktuelle Wert des Autos der Marke: " + getMarke() + ",\n des Alters " +
            (int) getAlter() + ",\n mit dem Kilometerstand von " + (int) getkilometerstandInTausend() + ".000,\n sowie der Unfallanzahl von " +
            (int) getUnfaelle() + ", betraegt: " + (int) getPreis());
        System.out.println("");
        System.out.println("Dies ist ein Verlust von " + getVerlust() + " gegenueber einem Neupreis von " + getNeupreis());
    }
}

