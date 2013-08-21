public class Kreuzung{
        private static Ampel ampel1 = new Ampel();
        private static Ampel ampel2 = new Ampel();
        private static Ampel ampel3 = new Ampel();
        private static Ampel ampel4 = new Ampel();

        public static void main(String[] args){
                ampel1.setLampen(true,false,false);
                ampel3.setLampen(true,false,false);
                ampel2.setLampen(false,false,true);
                ampel4.setLampen(false,false,true);
                System.out.println("Aktueller status:\n");
                System.out.println("Ampel1: " + ampel1);
                System.out.println("Ampel2: " + ampel2);
                System.out.println("Ampel3: " + ampel3);
                System.out.println("Ampel4: " + ampel4);
                ampel1.schalten();
                ampel2.schalten();
                ampel3.schalten();
                ampel4.schalten();
                System.out.println("Aktueller status:\n");
                System.out.println("Ampel1: " + ampel1);
                System.out.println("Ampel2: " + ampel2);
                System.out.println("Ampel3: " + ampel3);
                System.out.println("Ampel4: " + ampel4);
                ampel1.schalten();
                ampel2.schalten();
                ampel3.schalten();
                ampel4.schalten();
                System.out.println("Aktueller status:\n");
                System.out.println("Ampel1: " + ampel1);
                System.out.println("Ampel2: " + ampel2);
                System.out.println("Ampel3: " + ampel3);
                System.out.println("Ampel4: " + ampel4);
                ampel1.schalten();
                ampel2.schalten();
                ampel3.schalten();
                ampel4.schalten();
                System.out.println("Aktueller status:\n");
                System.out.println("Ampel1: " + ampel1);
                System.out.println("Ampel2: " + ampel2);
                System.out.println("Ampel3: " + ampel3);
                System.out.println("Ampel4: " + ampel4);
                ampel1.schalten();
                ampel2.schalten();
                ampel3.schalten();
                ampel4.schalten();
                System.out.println("Aktueller status:\n");
                System.out.println("Ampel1: " + ampel1);
                System.out.println("Ampel2: " + ampel2);
                System.out.println("Ampel3: " + ampel3);
                System.out.println("Ampel4: " + ampel4);
                ampel1.schalten();
                ampel2.schalten();
                ampel3.schalten();
                ampel4.schalten();
        }
}
