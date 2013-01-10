import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    private JButton jButton1,jButton2,jButton3;
    private JLabel jLabel1,jLabel2,jLabel3;
    private JPanel jPanel1,jPanel2;
    private GameLogic game;
    private String path;

    public Game() {
        initComponents();
    }
    
    private void initComponents() {
        game = new GameLogic();

        switch(System.getProperty("os.name")){
            case "Windows 7":
            path="cards\\";
            break;
            case "Linux":
            path="cards/";
            break;
        
        }

        jPanel1 = new JPanel();
        jLabel1 = new JLabel("Mixed Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);
        jLabel1.setVerticalTextPosition(JLabel.TOP);
        jLabel1.setHorizontalTextPosition(JLabel.CENTER);
        jLabel2 = new JLabel("Keep Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);
        jLabel2.setVerticalTextPosition(JLabel.TOP);
        jLabel2.setHorizontalTextPosition(JLabel.CENTER);
        jLabel3 = new JLabel("Throw Stack", new ImageIcon(path + "00.png"), JLabel.CENTER);
        jLabel3.setVerticalTextPosition(JLabel.TOP);
        jLabel3.setHorizontalTextPosition(JLabel.CENTER);
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setTitle("Keep or throw!");
        setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
        jPanel1.setLayout(new GridLayout(1, 0));
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        updateLogic();
        jPanel2.setLayout(new GridLayout(1, 0));
        jButton1.setText("Keep");
        jButton1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    jButton1ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton1);

        jButton2.setText("Throw");
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton2);

        jButton3.setText("Count");
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
        jPanel2.add(jButton3);

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
    }                        

    private void jButton1ActionPerformed(ActionEvent evt) {     
        game.keep();
        updateLogic();
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        game.dump();
        updateLogic();
    }                                        

    private void jButton3ActionPerformed(ActionEvent evt) {
        game.count();
    }

    public void updateLogic(){
        jLabel1.setIcon(new ImageIcon(path + 
                                      game.view() + 
                                      game.getMixedStack().peek().getSuite() + 
                                      ".png"));
        jLabel2.setIcon(new ImageIcon(path + 
                                      game.getKeepStack().peek().getValue() + 
                                      game.getKeepStack().peek().getSuite() +
                                      ".png"));
        jLabel3.setIcon(new ImageIcon(path + 
                                      game.getThrowStack().peek().getValue() + 
                                      game.getThrowStack().peek().getSuite() +
                                      ".png"));
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
}
