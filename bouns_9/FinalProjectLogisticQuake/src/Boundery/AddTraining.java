package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.EmployeeLogic;
import Control.InstructionLogic;
import Control.TeamLogic;
import entity.Employee;
import entity.Instruction;
import entity.Member;
import entity.Volunteer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;

public class AddTraining extends JFrame {

	private JPanel contentPane;
	private JTextField topic_txt;
	public static int courserNumber;

	private JTextField courseid_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTraining frame = new AddTraining();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddTraining() {
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creating Training Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(171, 11, 597, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourse = new JLabel("Course Topic:");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(10, 93, 105, 18);
		contentPane.add(lblCourse);
		
		topic_txt = new JTextField();
		topic_txt.setColumns(10);
		topic_txt.setBounds(125, 91, 115, 26);
		contentPane.add(topic_txt);
		
		JLabel lblNewLabel_7 = new JLabel("Role :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 128, 56, 18);
		contentPane.add(lblNewLabel_7);
		
		Object[] Roles = {"Rescue" , "emotional support","Medical Care"};
		JComboBox<Object> comboBox = new JComboBox<Object>(Roles);

		comboBox.setBounds(71, 130, 110, 19);

		JOptionPane.showMessageDialog(null, comboBox, "Choose a Role", JOptionPane.QUESTION_MESSAGE);
		String Role = comboBox.getSelectedItem().toString();
		System.out.println(Role);
		
		JLabel lblMaxNumberOf = new JLabel("Max number of participations:");
		lblMaxNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxNumberOf.setBounds(0, 157, 200, 18);
		contentPane.add(lblMaxNumberOf);
		
		JLabel lblNewLabel_1 = new JLabel("Available Employees with same Role");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 201, 276, 17);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(255, 201, 116, 21);
		contentPane.add(comboBox_1);
		
		JLabel roletxt = new JLabel("New label");
		roletxt.setBounds(88, 132, 152, 14);
		contentPane.add(roletxt);
		
		roletxt.setText(Role);
		
		
		courseid_txt = new JTextField();
		courseid_txt.setColumns(10);
		courseid_txt.setBounds(76, 56, 72, 26);
		contentPane.add(courseid_txt);
		
		
		
		JLabel lblNewLabel_12 = new JLabel("Day :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 241, 56, 19);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("month :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(10, 262, 56, 19);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("year :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 283, 56, 19);
		contentPane.add(lblNewLabel_14);
		
		JComboBox<String> comodays = new JComboBox<String>();
		comodays.setBounds(76, 241, 72, 19);
		contentPane.add(comodays);
		
		JComboBox<String> comomonths = new JComboBox<String>();
		comomonths.setBounds(76, 262, 72, 19);
		contentPane.add(comomonths);
		
		JComboBox<String> comoyears = new JComboBox<String>();
		comoyears.setBounds(76, 285, 72, 19);
		contentPane.add(comoyears);
		
		JComboBox<String> comonumbers = new JComboBox<String>();
		comonumbers.setBounds(204, 157, 72, 19);
		contentPane.add(comonumbers);
		
		JLabel lblNewLabel_2 = new JLabel("code:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 68, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		for (int i = 1; i <= 100; i++) {
			comonumbers.addItem(String.valueOf(i));
		}
		
		comomonths.addItem("01");
		comomonths.addItem("02");
		comomonths.addItem("03");
		comomonths.addItem("04");
		comomonths.addItem("05");
		comomonths.addItem("06");
		comomonths.addItem("07");
		comomonths.addItem("08");
		comomonths.addItem("09");
		comomonths.addItem("10");
		comomonths.addItem("11");
		comomonths.addItem("12");
		
		comodays.addItem("01");
		comodays.addItem("02");
		comodays.addItem("03");
		comodays.addItem("04");
		comodays.addItem("05");
		comodays.addItem("06");
		comodays.addItem("07");
		comodays.addItem("08");
		comodays.addItem("09");
		
		for (int i = 10; i <= 31; i++) {
			
			comodays.addItem(String.valueOf(i));  
		}

	
	
	for (int i = 2022; i >= 1940; i--) {
		comoyears.addItem(String.valueOf(i));  
	}
		
		
		
		
		for (Employee e : EmployeeLogic.getInstance().getEmployees()) 
		{
		
			if( e.getRole().equals(Role))  
				
			{	
				comboBox_1.addItem(e.getPassportID());
				
			}
				
		}
		
		JButton btnNewButton = new JButton("Create Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String course_id, course_topic,role,Max_Participtions,employee_id,employee_name = null,date;
				
				course_topic = topic_txt.getText();
				Max_Participtions = (String) comonumbers.getSelectedItem();
				employee_id= (String) comboBox_1.getSelectedItem();
				course_id = courseid_txt.getText();
				
				if(FRMmain.instructions_hash != null)
				{
					if(FRMmain.instructions_hash.containsKey(course_id))
					{
						JOptionPane.showMessageDialog(null, "change course ID");
						return;
					}
				}
				
				
				for( Entry<String, Member> m : FRMmain.Members_HASH.entrySet())
				{
					if(employee_id.equals(m.getKey()))
					{	System.out.println(m.getKey());
						employee_name = m.getValue().getName();
					}
				}
				
				date = comodays.getSelectedItem() + "/" + comomonths.getSelectedItem() + "/" + comoyears.getSelectedItem();
				
				boolean AddTr = InstructionLogic.getInstance().addInstructions(course_id, course_topic, Role, date,Max_Participtions , employee_name);
				
				
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
				 

				
			}
		});
		btnNewButton.setBounds(171, 324, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
				
				
			}
		});
		btnBackToMenu.setBounds(10, 425, 124, 23);
		contentPane.add(btnBackToMenu);

		
		
		

		}
	}

