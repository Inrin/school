import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class Textedit extends JFrame implements ActionListener{
	private JTextArea textfield;
	private JButton save,open;
	private JFileChooser fc = new JFileChooser();		
	private File file = null;
	private Scanner scan;
	private	FileWriter out;
	private JScrollPane scrollBarForTextArea;


	public Textedit()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		setTitle("TextEdit");

		textfield = new JTextArea();
		textfield.setFont(new Font("Serif",Font.PLAIN, 12));
		textfield.setColumns(30);
		textfield.setLineWrap(true);
		textfield.setRows(30);
		textfield.setWrapStyleWord(true);
		open = new JButton("Open");
		save = new JButton("Save");
		add(textfield);
		add(open);
		open.addActionListener(this);
		add(save);
		save.addActionListener(this);
		scrollBarForTextArea = new JScrollPane(textfield,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollBarForTextArea);

		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == textfield){
			System.out.println("testing");
		}else if (evt.getSource() == open) {
			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				try{
					scan =  new Scanner(new BufferedReader(new FileReader(file)));
					String complete = null;

					while (scan.hasNext()) {
						complete = scan.next();
					}    

					textfield.setText(complete);	

					pack();
				} catch (Exception ex){				
					System.out.println(ex.toString());

					System.err.println("Could not open file. Please check permissions.");
					JOptionPane.showMessageDialog(this, "File does not exist", "No file", JOptionPane.ERROR_MESSAGE);
				} finally {
					scan.close();
				}
			}
		} else if (evt.getSource() == save) {
			int choice = JOptionPane.showConfirmDialog(this,
					"Do you want to overwrite " + file.getName(), 
					"Are you sure?",
					JOptionPane.OK_CANCEL_OPTION);

			if(choice == JOptionPane.OK_OPTION){
				if(file == null)
					JOptionPane.showMessageDialog(this, "No file opened", "No file", JOptionPane.ERROR_MESSAGE);

				try{
					out = new FileWriter(file);
					out.write(textfield.getText());
					if(out != null)
						out.close();
				} catch (IOException ex) {
					System.out.println(ex.toString());
					System.err.println("Could not save file. Please check permissions.");
				}			
			}
		}
	}

	public static void main (String [] args)
	{
		Textedit t = new Textedit();
	}
}
