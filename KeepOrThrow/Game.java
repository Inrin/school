import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    private JButton jButton1,jButton2,jButton3;
    private JLabel jLabels[] = new JLabel[5];
    private JPanel jPanel1,jPanel2;
    private JMenuBar jMenuBar;
    private JMenu jMenuDatei;
    private JMenuItem jMenuItemDateiHilfe,jMenuItemDateiSchließen;
    private GameLogic gl;
    private String path;
    private int countdown=60000;
    private Timer timer;

    public Game() {
        initComponents();
    }

    private void initComponents() {
        gl = new GameLogic();

        switch(System.getProperty("os.name")){
            case "Windows 7":
            path="cards\\";
            break;
            case "Linux":
            path="cards/";
            break;

        }

        jPanel1 = new JPanel();
        jMenuBar = new JMenuBar();
        jMenuDatei = new JMenu("Datei");
        jMenuItemDateiHilfe = new JMenuItem("Hilfe");
        jMenuItemDateiHilfe.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jMenuItemDateiHilfeActionPerformed(evt);
                }
            });
        jMenuItemDateiSchließen = new JMenuItem("Schließen");
        jMenuItemDateiSchließen.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jMenuItemDateiSchließenActionPerformed(evt);
                }
            });
            
        jMenuDatei.add(jMenuItemDateiHilfe);
        jMenuDatei.add(jMenuItemDateiSchließen);
        jMenuBar.add(jMenuDatei);

        jLabels[0] = new JLabel("Mixed Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);
        jLabels[1] = new JLabel("0", JLabel.CENTER);
        jLabels[2] = new JLabel("Keep Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);
        jLabels[3] = new JLabel("120s", JLabel.CENTER);
        jLabels[4] = new JLabel("Keep Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);

        Font f = new Font("Dialog",Font.PLAIN,18);
        Font f2 = new Font("Dialog",Font.PLAIN,24);

        for(int i=0; i<jLabels.length; i+=2){
            jLabels[i].setVerticalTextPosition(JLabel.TOP);
            jLabels[i].setHorizontalTextPosition(JLabel.CENTER);
            jLabels[i].setFont(f);
        }

        for(int i=1; i<jLabels.length; i+=2){
            jLabels[i].setFont(f2);
        }

        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setTitle("Keep or throw!");
        setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
        jPanel1.setLayout(new GridLayout(1, 0));

        for(int i = 0; i<jLabels.length; i++)
            jPanel1.add(jLabels[i]);

        updateLabels();
        jPanel2.setLayout(new GridLayout(1, 0));
        jButton1.setFont(f);
        jButton1.setText("Throw");
        jButton1.setMnemonic(KeyEvent.VK_T);
        jButton1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jButton1ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton1);

        jButton2.setFont(f);
        jButton2.setText("Keep");
        jButton2.setMnemonic(KeyEvent.VK_K);
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton2);

        jButton3.setFont(f);
        jButton3.setText("Restart");
        jButton3.setMnemonic(KeyEvent.VK_R);
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton3);
        
        setJMenuBar(jMenuBar);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        timerInit();
    }                        

    private void jMenuItemDateiHilfeActionPerformed(ActionEvent evt){
        JOptionPane.showMessageDialog(null, "See http://www.infoskript.com for more Info");
    }

    private void jMenuItemDateiSchließenActionPerformed(ActionEvent evt){
        System.exit(0);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {     
        gl.dump();
        updateLabels();
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        gl.keep();
        updateLabels();
    }                                        

    private void jButton3ActionPerformed(ActionEvent evt) {
        countdown = 60000;
        gl = new GameLogic();
        updateLabels();
        timer.restart();
    }

    public void updateLabels(){
        jLabels[0].setIcon(new ImageIcon(path + 
                gl.view() + 
                gl.viewSuite() + 
                ".png"));
        jLabels[2].setIcon(new ImageIcon(path + 
                gl.getKeepStack().peek().getValue() + 
                gl.getKeepStack().peek().getSuite() +
                ".png"));
        jLabels[4].setIcon(new ImageIcon(path + 
                gl.getThrowStack().peek().getValue() + 
                gl.getThrowStack().peek().getSuite() +
                ".png"));
    }

    private void timerInit(){
        final ActionListener playingtime = new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jLabels[3].setText(String.valueOf(countdown/1000) + "s");
                    countdown--;
                }
            };
        ActionListener heartbeat = new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jLabels[1].setText(String.valueOf(gl.count()));

                    if(countdown == 0){
                        timer.stop();
                        while(!gl.getMixedStack().isEmpty()){
                            gl.getMixedStack().pop();
                            updateLabels();
                        }
                    }

                    if(gl.getMixedStack().isEmpty()){
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "Game over!\n You Score is: "
                            + (gl.count() + scoreAlgorithm()));
                    }
                }
            };
        timer = new Timer(1,playingtime);
        timer.addActionListener(heartbeat);
        timer.start();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Game().setVisible(true);
                }
            });
    }

    private int scoreAlgorithm(){
        int returnvalue = 0;
        if(gl.getKeepStack().isEmpty())
            return 0;

        if(countdown > 50000)
            returnvalue -= countdown/1000;
        else 
            returnvalue += countdown/1000;

        if(gl.getThrowStack().isEmpty())
            returnvalue += 1000;

        returnvalue -= gl.getErrors();

        return returnvalue;
    }
}
