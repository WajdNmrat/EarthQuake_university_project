package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.EmployeeLogic;
import Control.TeamLogic;
import entity.Volunteer;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class Add_vol_SYSTM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Boolean AddVL;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Add_vol_SYSTM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 11, 749, 492);
		contentPane.add(contentPane_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(99, 44, 115, 26);
		contentPane_1.add(textField);
		
		JComboBox<String> comodays = new JComboBox<String>();
		comodays.setBounds(76, 271, 72, 19);
		contentPane_1.add(comodays);
		
		JComboBox<String> comomonths = new JComboBox<String>();
		comomonths.setBounds(76, 292, 72, 19);
		contentPane_1.add(comomonths);
		
		JComboBox<String> comoyears = new JComboBox<String>();
		comoyears.setBounds(76, 315, 72, 19);
		contentPane_1.add(comoyears);
		
		JComboBox<String> comodays_1 = new JComboBox<String>();
		comodays_1.setBounds(282, 271, 72, 19);
		contentPane_1.add(comodays_1);
		
		JComboBox<String> comomonths_1 = new JComboBox<String>();
		comomonths_1.setBounds(282, 292, 72, 19);
		contentPane_1.add(comomonths_1);
		
		JComboBox<String> comoyears_1 = new JComboBox<String>();
		comoyears_1.setBounds(282, 315, 72, 19);
		contentPane_1.add(comoyears_1);
		
		JLabel lblNewLabel = new JLabel("PassportID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 45, 79, 18);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 92, 56, 19);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 158, 79, 18);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 128, 110, 19);
		contentPane_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Back to menu ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				 FRMmain test1=new FRMmain();
				 test1.setVisible(true);
				 test1.FRMmain();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(21, 412, 182, 39);
		contentPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("add new volunter");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(10, 11, 724, 14);
		contentPane_1.add(lblNewLabel_11);
		
		JLabel age_label = new JLabel("null");
		age_label.setBounds(73, 353, 46, 14);
		contentPane_1.add(age_label);
		
		JLabel exp_label = new JLabel("null");
		exp_label.setBounds(312, 349, 46, 14);
		contentPane_1.add(exp_label);
		
		JLabel lblNewLabel_12 = new JLabel("Day :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 271, 56, 19);
		contentPane_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("month :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(10, 292, 56, 19);
		contentPane_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("year :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 313, 56, 19);
		contentPane_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Day :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(216, 271, 56, 19);
		contentPane_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("month :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(216, 292, 56, 19);
		contentPane_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("year :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(216, 313, 56, 19);
		contentPane_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_12_1 = new JLabel("Status:");
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12_1.setBounds(269, 44, 71, 19);
		contentPane_1.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_7.setBounds(0, 218, 410, 184);
		contentPane_1.add(lblNewLabel_7);
		

		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 94, 96, 19);
		contentPane_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 129, 96, 19);
		contentPane_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(76, 159, 96, 19);
		contentPane_1.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 345, 56, 26);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Birthday ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 236, 79, 26);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Joinning date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(216, 239, 138, 20);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_10 = new JLabel("Experince : ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(216, 345, 79, 18);
		contentPane_1.add(lblNewLabel_10);
		
		JComboBox<String> como_status = new JComboBox<String>();
		como_status.setBounds(334, 46, 72, 19);
		contentPane_1.add(como_status);
		
		como_status.addItem("True");
		como_status.addItem("False");
		
		String status;
		
		status= (String) como_status.getSelectedItem();
		
		
		
		for (int i = 1; i <= 31; i++) {
			comodays.addItem(String.valueOf(i));
			comodays_1.addItem(String.valueOf(i));
    
		}
		
		for (int i = 1; i <= 12; i++) {
			comomonths.addItem(String.valueOf(i));
			comomonths_1.addItem(String.valueOf(i));
		    
		}
		
		for (int i = 2022; i >= 1940; i--) {
			comoyears.addItem(String.valueOf(i));
			comoyears_1.addItem(String.valueOf(i));    
		}
		
		JButton btnNewButton = new JButton("Add Volunteer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String PassportId, Name, PhoneNumber, Email, Birthday, joinning;
				String Age,salary, RetirementAge, Experince;
				String role;
				
				int Age_int=0,joinning_int=0;

				PassportId = textField.getText();
				
				if(PassportId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ID connot be blank");
					return;
				}
				
				
				if(FRMmain.Members_HASH.containsKey(PassportId))
				{
					JOptionPane.showMessageDialog(null, "this ID exist");
					return;
				}
				
				Name = textField_1.getText();
				PhoneNumber = textField_2.getText();
				Email = textField_3.getText();
				
				Birthday = comodays.getSelectedItem() + "/" + comomonths.getSelectedItem() + "/" + comoyears.getSelectedItem();
				
			      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
			      Date date;
				try {
					
					date = formatter.parse(Birthday);
				      //Converting obtained Date object to LocalDate object
				      Instant instant = date.toInstant();
				      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
				      LocalDate givenDate = zone.toLocalDate();
				      
				    //Calculating the difference between given date to current date.
				      Period period = Period.between(givenDate, LocalDate.now());
				      Age_int = period.getYears();

				      
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				joinning = comodays_1.getSelectedItem() + "/" + comomonths_1.getSelectedItem() + "/" + comoyears_1.getSelectedItem();

				
				 SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/YY");
			      Date date1;
				try {
					date1 = formatter.parse(joinning);
				      //Converting obtained Date object to LocalDate object
				      Instant instant1 = date1.toInstant();
				      ZonedDateTime zone1 = instant1.atZone(ZoneId.systemDefault());
				      LocalDate givenDate1 = zone1.toLocalDate();
				      
				    //Calculating the difference between given date to current date.
				      Period period1 = Period.between(givenDate1, LocalDate.now());
				      joinning_int = period1.getYears();
				      
				      
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//role = comboBox.getSelectedItem().toString();
				

				Experince =String.valueOf(joinning_int);
				Age= String.valueOf(Age_int);
				


				if( PassportId.equals("") || Name.equals("") || Email.equals("") || PhoneNumber.equals(""))
				{
					JOptionPane.showMessageDialog(null, "please fill the blank");
					return;
				}
					//////////// we should add checking age here ////////////////
				
				if(Age_int<60)
				{
					exp_label.setText(Experince);
					age_label.setText(Age);
					AddVL = TeamLogic.getInstance().AddVolunteers (PassportId,  Name,  PhoneNumber,  Email,  Age,  Experince, status);
					JOptionPane.showMessageDialog(btnNewButton, "Volunteer added successfully");
					 setVisible(false);
					 FRMmain test1=new FRMmain();
					 test1.setVisible(true);
					 test1.FRMmain();
				}
				else
				{
					Volunteer v = new Volunteer(PassportId,  Name,  PhoneNumber,  Email,  Age,  Experince, status);
					
					if(!(FRMmain.awating_AdultVolunters.contains(v)))
					{	
						JOptionPane.showMessageDialog(btnNewButton, "adult voluntee sending to CEO to approve");
						FRMmain.awating_AdultVolunters.add(v);
					}
						
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(334, 413, 164, 38);
		contentPane_1.add(btnNewButton);
		
		
		
		
	}
}
