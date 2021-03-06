package Calendar.Event;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Date;

public class Edit implements ActionListener {
	JFrame frame, DlgFrame, DeleteFrame;
	JPanel EditEventPane, DeletePane;
    JTextField TxtTitle, TxtLocation;
    JLabel lblTitle, lblLocation, lblStrtTime, lblEndTime;
    JButton btnSubmitEditedEvent, btnDeleteEvent, btnCancelEvent;
    JComboBox<Integer> CombBoxDay, CombBoxYear, CombBoxHourStrt, CombBoxHourEnd, CombBoxMinStrt, CombBoxMinEnd;
	JComboBox<String> CombBoxMonth;
	JOptionPane ErrorDialog;
    
    
	public Edit(JFrame inFrame) {
		frame = inFrame;
		//add new components to new frame.
		EditEventPane = new JPanel();
		EditEventPane.setBorder(BorderFactory.createEmptyBorder(35,385,25,385));
		
		editEventComponents();
		// POPULATE INPUT FIELDS WITH THE CURRENT EVENT DATA.
		
		DeleteFrame = new JFrame("Delete Event");
		setSizeAndLocation(250,124);
		DeletePane = new JPanel();
		DeletePane.setBorder(BorderFactory.createEmptyBorder(20,10,25,10));
		deleteComponents();
		DeleteFrame.setContentPane(DeletePane);
		DeleteFrame.setVisible(false);
		
		
		
		frame.setContentPane(EditEventPane);
    	frame.setVisible(true);
	}
	
	public void setSizeAndLocation(int width, int height) {
		int x, y;
    	DeleteFrame.setSize(width, height);
    	DeleteFrame.validate();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		x = (dim.width - width)/2;
		y = (dim.height - height)/2;
		DeleteFrame.setLocation(x, y);
	}
	
	public void editEventComponents() {
		lblTitle = new JLabel("Title:     ");
		lblTitle.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		lblTitle.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		EditEventPane.add(lblTitle);
		
		TxtTitle = new JTextField(12);
    	EditEventPane.add(TxtTitle);
    	
		lblLocation = new JLabel("Location:     ");
		lblLocation.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		lblLocation.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		EditEventPane.add(lblLocation);
		
		TxtLocation = new JTextField(12);
    	EditEventPane.add(TxtLocation);
    	
    	Integer[] dayInts = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    	CombBoxDay = new JComboBox<Integer>(dayInts);
    	CombBoxDay.addActionListener(this);
    	CombBoxDay.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxDay);
    	
    	String[] monthStrings = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    	CombBoxMonth = new JComboBox<String>(monthStrings);
    	CombBoxMonth.addActionListener(this);
    	CombBoxMonth.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxMonth);
		
    	Integer[] yearInts = {2015, 2016, 2017};
    	CombBoxYear = new JComboBox<Integer>(yearInts);
    	CombBoxYear.addActionListener(this);
    	CombBoxYear.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxYear);
    	
		lblStrtTime = new JLabel("Start Time:     ");
		lblStrtTime.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		lblStrtTime.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
		EditEventPane.add(lblStrtTime);
		
    	Integer[] HourInts = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    	CombBoxHourStrt = new JComboBox<Integer>(HourInts);
    	CombBoxHourStrt.addActionListener(this);
    	CombBoxHourStrt.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxHourStrt);
    	
    	Integer[] MinInts = {0,5,10,15,20,25,30,35,40,45,50,55};
    	CombBoxMinStrt = new JComboBox<Integer>(MinInts);
    	CombBoxMinStrt.addActionListener(this);
    	CombBoxMinStrt.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxMinStrt);
		
		lblEndTime = new JLabel("End Time:     ");
		lblEndTime.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		lblEndTime.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
		EditEventPane.add(lblEndTime);
		
    	CombBoxHourEnd = new JComboBox<Integer>(HourInts);
    	CombBoxHourEnd.addActionListener(this);
    	CombBoxHourEnd.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxHourEnd);
    	
    	CombBoxMinEnd = new JComboBox<Integer>(MinInts);
    	CombBoxMinEnd.addActionListener(this);
    	CombBoxMinEnd.setBorder(BorderFactory.createEmptyBorder(5,10,20,10));
    	EditEventPane.add(CombBoxMinEnd);
    	
    	btnCancelEvent = new JButton("Cancel");
    	btnCancelEvent.setActionCommand("CancelEventPress");
    	btnCancelEvent.addActionListener((ActionListener) this);
    	EditEventPane.add(btnCancelEvent);
    	
    	
    	btnSubmitEditedEvent = new JButton("Save Event");
    	btnSubmitEditedEvent.setActionCommand("SubmitEventPress");
    	btnSubmitEditedEvent.addActionListener((ActionListener) this);
    	EditEventPane.add(btnSubmitEditedEvent);
    	
    	btnDeleteEvent = new JButton("Delete Event");
    	btnDeleteEvent.setActionCommand("DeleteEventPress");
    	btnDeleteEvent.addActionListener((ActionListener) this);
    	EditEventPane.add(btnDeleteEvent);
	}
	
	public void deleteComponents() {
		//place confirm delete components here. 
	}
	
	public void actionPerformed(ActionEvent event) {
    	String eventName = event.getActionCommand();
    	
    	if (eventName.equals("SubmitEventPress")) {
    		
    		if (EventIsValid()) {
    			//Save
        		Calendar.Logic objLogicCal = new Calendar.Logic(frame);
        		
        		Calendar.GUI.showNewEvent("New event saved with the following values: ("+TxtTitle.getText()+"), at ("+TxtLocation.getText()+"), on ("+(Integer) CombBoxDay.getSelectedItem()+" "+(String) CombBoxMonth.getSelectedItem()+" "+(Integer) CombBoxYear.getSelectedItem()+").");
        		//And also save data to database.
    		}
    	}
    	
    	if (eventName.equals("CancelEventPress")) {
    		Calendar.Logic objLogicCal = new Calendar.Logic(frame);
    	}
    	
    	if (eventName.equals("DeleteEventPress")) {
    		// display dialog to ensure user is sure.
    		DeleteFrame.setVisible(true);
    		// then delete event from database.
    		Calendar.Logic objLogicCal = new Calendar.Logic(frame);
    	}
	}
	
	@SuppressWarnings("deprecation")
	public Boolean EventIsValid() {
		String title, location;
		int day, month, year;
		Date today = new Date();
		Date event = new Date();
		
		title = TxtTitle.getText();
		location = TxtLocation.getText();
		day = (int) CombBoxDay.getSelectedItem();
		month = 0;
		year = (int) CombBoxYear.getSelectedItem();
		
		switch ((String) CombBoxMonth.getSelectedItem()) {
			case "Jan": month = 1;
			break;
			case "Feb": month = 2;
			break;
			case "Mar": month = 3;
			break;
			case "Apr": month = 4;
			break;
			case "May": month = 5;
			break;
			case "Jun": month = 6;
			break;
			case "Jul": month = 7;
			break;
			case "Aug": month = 8;
			break;
			case "Sep": month = 9;
			break;
			case "Oct": month = 10;
			break;
			case "Nov": month = 11;
			break;
			case "Dec": month = 12;
			break;
		}
		
		event.setYear(year-1900);
		event.setMonth(month-1);
		event.setDate(day);
		
		// Check that title exists.
		if (title.equals("")) {
			ErrorDialog.showMessageDialog(DlgFrame,"Event title was left empty...\n\nAn event must have a title!", "Invalid Title", JOptionPane.ERROR_MESSAGE);
			return (false);
		}
		
		//		(1) Check that day exists in calendar (rem. leap years)
		if (month==2) {
			if (day>28) {
				if ((year!=2016)||(day!=29)) {	//2016 is a Leap year
					ErrorDialog.showMessageDialog(DlgFrame,"Chosen day does not exist in calendar...\n\nCheck your date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
					return(false);
				}
			}
		}
		if (day==31) {
			if ((month==2)||(month==4)||(month==6)||(month==9)||(month==11)) {
				ErrorDialog.showMessageDialog(DlgFrame,"Chosen day does not exist in calendar...\n\nCheck your date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
				return(false);
			}
		}
		
		//		(2) Check that date is in the future.
		if (today.compareTo(event)> 0) {
			ErrorDialog.showMessageDialog(DlgFrame,"Event occurs in the past...\n\nEvents cannot occur in the past.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
			return(false);
		}
		
		return(true);
	}
	
}
