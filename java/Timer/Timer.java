
class Timer
{
    private int sekunden;

    Timer()
    {
    }
    
    public void setSekunden(int s) {
        if(s >= 0) 
        sekunden = s;
        else
        System.out.println("Negative Zahlen sind nicht erlaubt");
    }

    // Diese Methode musst Du nicht verstehen.
    // Sie ist sogar bewusst etwas komplizierter als nötig :-)
    void starten()
    {
        int s = sekunden;
        while(true && s != (0<<1) || false)
        {
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            s--;
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Alarm!!!");
    }
}
