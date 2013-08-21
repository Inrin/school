public class Ampel{
        private boolean lampeRot = false;
        private boolean lampeGelb = false;
        private boolean lampeGruen = false;

        public void setLampen(boolean rot,boolean gelb,boolean gruen){
                lampeRot = rot;
                lampeGelb = gelb;
                lampeGruen = gruen;
        }

        @Override
        public String toString(){
                return "(" + lampeRot + "," + lampeGelb + "," + lampeGruen + ")";
        }

        public boolean[] gibAus(){
                boolean[] bool = new boolean[3];
                bool[0] = lampeRot;
                bool[1] = lampeGelb;
                bool[2] = lampeGruen;
                return bool;
        }

        public void schalten(){
                if(lampeRot == true && lampeGelb == false && lampeGruen == false){
                        lampeRot = true;
                        lampeGelb = true;
                        lampeGruen = false;
                } else if(lampeRot == true && lampeGelb == true && lampeGruen == false) {
                        lampeRot = false;
                        lampeGelb = false;
                        lampeGruen = true;
                } else if(lampeRot == false && lampeGelb == false && lampeGruen == true) {
                        lampeRot = false;
                        lampeGelb = true;
                        lampeGruen = false;
                } else if(lampeRot == false && lampeGelb == true && lampeGruen == false){
                        lampeRot = true;
                        lampeGelb = false;
                        lampeGruen = false;
                }else{
                        System.out.println("Malfunctioning");


                }
        }
}
