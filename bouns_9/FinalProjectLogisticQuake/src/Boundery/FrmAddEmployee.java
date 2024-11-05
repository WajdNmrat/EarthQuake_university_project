package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.EmployeeLogic;
import entity.Employee;

public class FrmAddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_11;
	private JLabel lblNewLabel_10;
	Boolean AddEm;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_11;
	private JLabel age_label;
	private JLabel exp_label;
	private JComboBox<String> comodays;
	private JComboBox<String> comomonths;
	private JComboBox<String> comoyears;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JComboBox<String> comodays_1;
	private JComboBox<String> comomonths_1;
	private JComboBox<String> comoyears_1;
	
	public  FrmAddEmployee() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(99, 44, 115, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comodays = new JComboBox<String>();
		comodays.setBounds(76, 271, 72, 19);
		contentPane.add(comodays);
		
		comomonths = new JComboBox<String>();
		comomonths.setBounds(76, 292, 72, 19);
		contentPane.add(comomonths);
		
		comoyears = new JComboBox<String>();
		comoyears.setBounds(76, 315, 72, 19);
		contentPane.add(comoyears);
		
		comodays_1 = new JComboBox<String>();
		comodays_1.setBounds(282, 271, 72, 19);
		contentPane.add(comodays_1);
		
		comomonths_1 = new JComboBox<String>();
		comomonths_1.setBounds(282, 292, 72, 19);
		contentPane.add(comomonths_1);
		
		comoyears_1 = new JComboBox<String>();
		comoyears_1.setBounds(282, 315, 72, 19);
		contentPane.add(comoyears_1);
		
		
		for (int i = 1; i <= 31; i++) {
			comodays.addItem(String.valueOf(i));
			comodays_1.addItem(String.valueOf(i));
    
		}
		
		for (int i = 1; i <= 12; i++) {
			comomonths.addItem(String.valueOf(i));
			comomonths_1.addItem(String.valueOf(i));
		    
		}
		
		for (int i = 1900; i <= 2022; i++) {
			comoyears.addItem(String.valueOf(i));
			comoyears_1.addItem(String.valueOf(i));    
		}

		JLabel lblNewLabel = new JLabel("PassportID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 45, 79, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 92, 56, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 187, 79, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Phone Number :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 157, 110, 19);
		contentPane.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(76, 94, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(118, 158, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(76, 189, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Rescue");
		comboBox.addItem("emotional support");
		comboBox.addItem("Medical Care");
		comboBox.setBounds(76, 127, 110, 19);
		contentPane.add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("Age :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 345, 56, 26);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Birthday ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 236, 79, 26);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Joinning date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(216, 239, 138, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Role :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 122, 56, 18);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Salary :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(307, 46, 56, 18);
		contentPane.add(lblNewLabel_8);

		textField_11 = new JTextField();
		textField_11.setBounds(373, 47, 96, 19);
		contentPane.add(textField_11);
		textField_11.setColumns(10);

		lblNewLabel_10 = new JLabel("Experince : ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(216, 345, 79, 18);
		contentPane.add(lblNewLabel_10);

		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PassportId, Name, PhoneNumber, Email, Birthday, joinning;
				String Age,salary, RetirementAge, Experince;
				String role;
				int Age_int=0,joinning_int=0;
				PassportId = textField.getText();
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
				
				role = comboBox.getSelectedItem().toString();
				salary =textField_11.getText();
				//RetirementAge =textField_12.getText();
				Experince =String.valueOf(joinning_int);
				Age= String.valueOf(Age_int);
				age_label.setText(Age);
				exp_label.setText(Experince);
				AddEm = EmployeeLogic.getInstance().addEmployee(PassportId,Name,PhoneNumber,Email,Age,Experince,role,salary,Birthday,joinning);
				JOptionPane.showMessageDialog(btnNewButton, "Employee added successfully");
				FRMmain.Intilaize(); // update databse
				//Employee ee = new Employee(PassportId,Name,PhoneNumber,Email,Age,Experince,role,salary,Birthday,joinning);
				//FRMmain.employeearaay.add(ee);
				 

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(334, 413, 164, 38);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Back to menu ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(21, 412, 182, 39);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_11 = new JLabel("add new employee");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(21, 11, 319, 14);
		contentPane.add(lblNewLabel_11);
		
		age_label = new JLabel("null");
		age_label.setBounds(73, 353, 46, 14);
		contentPane.add(age_label);
		
		exp_label = new JLabel("null");
		exp_label.setBounds(312, 349, 46, 14);
		contentPane.add(exp_label);
		
		lblNewLabel_12 = new JLabel("Day :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 271, 56, 19);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("month :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(10, 292, 56, 19);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("year :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 313, 56, 19);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Day :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(216, 271, 56, 19);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("month :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(216, 292, 56, 19);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("year :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(216, 313, 56, 19);
		contentPane.add(lblNewLabel_17);
		


	}
}
