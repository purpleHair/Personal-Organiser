package Notes;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/**
 * Display all user's notes
 *
 */
public class GUI extends JFrame{
	JFrame frame;
    JPanel noteHomePane,noteEditPane;
    JLabel title,noteTitleLabel,noteContLabel;
    JTextField noteTitle,content;
    Border blackBorder;
	TitledBorder borderTitle;
    JButton editBtn; 
	LinkedList<JLabel> noteEntry = new LinkedList<JLabel>();
	
    public GUI(){
    	//noteHomePane = new JPanel(new GridBagLayout());
	//	addComponents(noteHomePane);

    }
    public void addComponents() {
    	noteHomePane = new JPanel();
    	noteHomePane.setLayout(new GridBagLayout());
    	addNoteEntry(noteHomePane);
		
    }
    protected void updateNoteEntry() {
    	//JButton note2 = new JButton("Finish coursework");
    	JLabel note1 = new JLabel("Weather is good");
    	JLabel note2 = new JLabel("This is another note");
    	//note1.setHorizontalAlignment(SwingConstants.LEFT);
    	noteEntry.add(note1);
    	noteEntry.add(note2);


    }
    protected void createEditPane(){
    	noteEditPane = new JPanel();
    	noteEditPane.setLayout((new BoxLayout(noteEditPane,BoxLayout.Y_AXIS)));
    	noteEditPane.setToolTipText("EDIT");
    	noteTitleLabel = new JLabel("Title: ");
    	noteContLabel = new JLabel("Content: ");
    	noteTitle = new JTextField(20);
    	noteTitle.setColumns(4);
    	content = new JTextField(20);
    	noteTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    	noteEditPane.add(noteTitleLabel);
    	noteTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
    	noteEditPane.add(noteTitle);
    	noteContLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    	noteEditPane.add(noteContLabel);
    	content.setAlignmentX(Component.LEFT_ALIGNMENT);
    	noteEditPane.add(content);



    }
    protected void addNoteEntry(Container pane) {
    	GridBagConstraints c = new GridBagConstraints();

    	JButton btn = new JButton("Read");
    	JButton btn2 = new JButton("Read");


    	updateNoteEntry();
    	int counter = 0;
    	for (JLabel label : noteEntry){
    		c.fill = GridBagConstraints.HORIZONTAL;
    		//c.anchor = GridBagConstraints.FIRST_LINE_START;
    		c.ipadx= 20;
        	c.gridy = counter;
    		pane.add(label,c);
    		counter++;	
    	}
		c.ipadx= 10;

    	c.gridy = 0;
    	c.gridx = 1;
    	pane.add(btn,c);
    	c.gridy = 1;

    	pane.add(btn2,c);

    }
    private void createAndShowGUI() {
    	blackBorder = BorderFactory.createLineBorder(Color.black);
    	borderTitle = BorderFactory.createTitledBorder(blackBorder, "Create Note");

    	
    	//borderTitle.setTitleJustification(TitledBorder.CENTER);
	        //Create and set up the window.
	       // JFrame frame = new JFrame("HelloWorldSwing");
    	this.setTitle("NOTE");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(200, 200);
	    createEditPane();
	    //this.add(noteEditPane);
	    addComponents();
    	noteEditPane.setBorder(borderTitle);
    	borderTitle = BorderFactory.createTitledBorder(blackBorder, "Notes Content");
    	noteHomePane.setBorder(borderTitle);
	    this.add(noteEditPane,BorderLayout.NORTH);
	    this.add(noteHomePane,BorderLayout.CENTER);

	        //Display the window.
	    this.pack();
	    this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		
	}

	public static void main(String args[]) {
		GUI gui = new GUI();
		gui.createAndShowGUI();
	}
}
