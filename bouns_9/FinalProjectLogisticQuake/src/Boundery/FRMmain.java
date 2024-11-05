package Boundery;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.EmployeeLogic;
import Control.InstructionLogic;
import Control.TeamLogic;
import entity.Volunteer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import entity.Employee;
import entity.Instruction;
import entity.Member;
import entity.Team;

import java.awt.Color;
import javax.swing.border.MatteBorder;

public class FRMmain extends JFrame {
	public FRMmain() {
	}
	/*public FRMmain() {
	}*/
	public static HashMap<String,HashMap<String,ArrayList<String>>> system= new HashMap<String,HashMap<String,ArrayList<String>>>();
	public static String EventManager;
	public static ArrayList<Employee> employeearaay=new ArrayList<Employee>();
	public static ArrayList<Volunteer> volunterarray=new ArrayList<Volunteer>();
	public static  ArrayList<Instruction> instrcutions_codes=new ArrayList<Instruction>();
	public static HashMap<String, Instruction> instructions_hash = new HashMap<String, Instruction>();
	public static ArrayList<Volunteer> awating_AdultVolunters = new ArrayList<Volunteer>();
	public static ArrayList<Team> teamsarray=new ArrayList<Team>();
	public static HashMap<String, Team> teams_hash = new HashMap<String, Team>();
	public static boolean check = false;
	
	
	
	
	

	
	public static HashMap<String,Member> Members_HASH=new HashMap<String,Member>();
	public static JComboBox<String> comboBox = new JComboBox<String> ();
	

	/*public void FRMmain()
	{}*/

	
	private JPanel contentPane;
	public void FRMmain() {
		
		
		///////////////getting all employess from database//////////////////////
		
		
		
		employeearaay = EmployeeLogic.getInstance().getEmployees();
		volunterarray = TeamLogic.getInstance().getVolunteers();
		teamsarray=TeamLogic.getInstance().getTeams();

		if(!(employeearaay.isEmpty()))
		{
			for(Employee emp : employeearaay)
			{
				Members_HASH.put(emp.getPassportID(), emp);
			}
		}
		
		if(!(volunterarray.isEmpty()))
		{
			for(Volunteer emp1 : volunterarray)
			{
				Members_HASH.put(emp1.getPassportID(), emp1);
			}
		}
		

		instrcutions_codes = InstructionLogic.getInstance().getInstructions();
		
		if(!(instrcutions_codes.isEmpty()))
		{
			for(Instruction emp1 : instrcutions_codes)
			{
				instructions_hash.put(emp1.getId(), emp1);
			}
		}
		
		
		if(!(teamsarray.isEmpty()))
		{
			for(Team emp1 : teamsarray)
			{
				teams_hash.put(emp1.getTeamID(), emp1);
			}
		}
		


		System.out.println(employeearaay);
		System.out.println(volunterarray);
		System.out.println(Members_HASH);
		
		
		///////////////////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmAddEmployee().setVisible(true);
			}
		});
		btnNewButton.setBounds(217, 84, 147, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CEO   :  Add workers to the system");
		lblNewLabel.setBounds(20, 90, 162, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Go to Build The Teams");
		btnNewButton_1.setBounds(161, 476, 250, 41);
		contentPane.add(btnNewButton_1);
		
		if(check==false)
		{
			btnNewButton_1.setEnabled(false);
		}
		else
		{
			btnNewButton_1.setEnabled(true);
		}
		
		System.out.println(check);
		JLabel lblNewLabel_1 = new JLabel("Choose Event Manager :");
		lblNewLabel_1.setBounds(70, 158, 147, 14);
		contentPane.add(lblNewLabel_1);
				comboBox.setBounds(227, 154, 118, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Main  Menu");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(256, 11, 250, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblAddVoluntersTo = new JLabel("CEO   :  add volunters to the system");
		lblAddVoluntersTo.setBounds(20, 123, 162, 14);
		contentPane.add(lblAddVoluntersTo);
		
		JButton btn_add_volunters = new JButton("Add Volunters");
		btn_add_volunters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Add_vol_SYSTM().setVisible(true);
				

			}
		});
		btn_add_volunters.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_volunters.setBounds(217, 117, 147, 22);
		contentPane.add(btn_add_volunters);
		
		JButton btn_add_volunters_1 = new JButton("create Course");
		btn_add_volunters_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 setVisible(false);
				 AddTraining test1=new AddTraining();
					test1.setVisible(true);
					
			}
		});
		btn_add_volunters_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_volunters_1.setBounds(133, 309, 147, 22);
		contentPane.add(btn_add_volunters_1);
		
		JLabel lblNewLabel_3 = new JLabel("adding Courses");
		lblNewLabel_3.setBounds(20, 315, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CEO");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(20, 58, 250, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(20, 235, 667, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Volunter_Manger");
		lblNewLabel_2_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(20, 262, 250, 25);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel msg_lbl = new JLabel("0");
		msg_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		msg_lbl.setBounds(498, 375, 85, 14);
		contentPane.add(msg_lbl);
		
		JLabel lblNewLabel_3_1 = new JLabel("assigns&grades");
		lblNewLabel_3_1.setBounds(20, 342, 106, 14);
		contentPane.add(lblNewLabel_3_1);
		
		
		
		JButton btn_add_volunters_1_1 = new JButton("assign&grades");
		btn_add_volunters_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 setVisible(false);
				 add_TrainVolunter test12=new add_TrainVolunter();
					test12.setVisible(true);
			}
		});
		btn_add_volunters_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_volunters_1_1.setBounds(133, 342, 147, 22);
		contentPane.add(btn_add_volunters_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Adding volunters to Teams");
		lblNewLabel_3_1_1.setBounds(20, 377, 162, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		
		
		JButton btn_add_volunters_1_1_1 = new JButton("Scheduling volunters");
		
		btn_add_volunters_1_1_1.setEnabled(false);
		
		if(AddTeam.msg_num>0)
		{
			JOptionPane.showMessageDialog(null, "hey Volunter manger you have a new Message from the CEO");
			btn_add_volunters_1_1_1.setEnabled(true);
			msg_lbl.setText(String.valueOf(AddTeam.msg_num));
			
		}
		
		btn_add_volunters_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddTeam.msg_num--;
				setVisible(false);
				new AddVolunteer().setVisible(true);
			}
		});
		btn_add_volunters_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_volunters_1_1_1.setBounds(175, 373, 170, 22);
		contentPane.add(btn_add_volunters_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Message Box:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(365, 371, 130, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_2 = new JLabel("volunter status");
		lblNewLabel_3_2.setBounds(20, 413, 106, 14);
		contentPane.add(lblNewLabel_3_2);
		
		
		
		JButton btn_add_volunters_1_2 = new JButton("Update Volunter Status");
		btn_add_volunters_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Update_status fr = new Update_status();
				fr.setVisible(true);
			}
		});
		btn_add_volunters_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_volunters_1_2.setBounds(123, 407, 183, 22);
		contentPane.add(btn_add_volunters_1_2);
		
		
		JButton btnApproveAdultVolunters = new JButton("approve adult volunters");
		
		btnApproveAdultVolunters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					setVisible(false);
				 Approve_adults test1=new Approve_adults();
				 test1.setVisible(true);
				
				
			}
		});
		btnApproveAdultVolunters.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnApproveAdultVolunters.setBounds(440, 84, 213, 22);
		contentPane.add(btnApproveAdultVolunters);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2_2.setBounds(10, 451, 667, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("EventManger");
		lblNewLabel_2_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1.setBounds(10, 480, 250, 25);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		

		
		
		JButton btn_choose = new JButton("choose");
		btn_choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				system.put(FRMmain.EventManager,new HashMap<String,ArrayList<String>>());				
				comboBox.enable(false);
				btn_choose.setEnabled(false);
				check = true;
				btnNewButton_1.setEnabled(true);
				
				
				
				
			}
		});
		btn_choose.setBounds(237, 187, 89, 23);
		contentPane.add(btn_choose);
		

		
		//comboBox.removeAllItems();
		
		for (Employee v : TeamLogic.getInstance().Employee()) {
			comboBox.addItem(v.getPassportID());
			employeearaay.add(v);
		}
		
		
		try {
			
			EventManager = comboBox.getSelectedItem().toString();
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "there is no members");
		} 
		
		 	
			/*if(employeearaay.isEmpty())
			{
				btnNewButton_1.setEnabled(false);
			}*/
		

		 
			btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

					setVisible(false);
					AddTeam test1=new AddTeam();
					test1.setVisible(true);
					test1.AddTeam();
					
					
			}
		});
		
	}
	
	public static void Intilaize()
	{
		employeearaay = EmployeeLogic.getInstance().getEmployees();
		volunterarray = TeamLogic.getInstance().getVolunteers();
		teamsarray=TeamLogic.getInstance().getTeams();

		if(!(employeearaay.isEmpty()))
		{
			for(Employee emp : employeearaay)
			{
				Members_HASH.put(emp.getPassportID(), emp);
			}
		}
		
		if(!(volunterarray.isEmpty()))
		{
			for(Volunteer emp1 : volunterarray)
			{
				Members_HASH.put(emp1.getPassportID(), emp1);
			}
		}
		

		instrcutions_codes = InstructionLogic.getInstance().getInstructions();
		
		if(!(instrcutions_codes.isEmpty()))
		{
			for(Instruction emp1 : instrcutions_codes)
			{
				instructions_hash.put(emp1.getId(), emp1);
			}
		}
		
		if(!(teamsarray.isEmpty()))
		{
			for(Team emp1 : teamsarray)
			{
				teams_hash.put(emp1.getTeamID(), emp1);
			}
		}

		

		System.out.println(employeearaay);
		System.out.println(volunterarray);
		System.out.println(Members_HASH);
	}
}
