package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.EmployeeLogic;
import Control.TeamLogic;
import entity.Employee;
import entity.Team;
import entity.XmlMessage;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AddTeam extends JFrame {
	
	
	public  AddTeam() {
	}

	private JPanel contentPane;
	private JTextField textField;
	public boolean adteam;
	private JTextField textField_1;
	static String name;
	static String role;
	static String PassportIdOfEmployee;
	static String PrivateNumberOfEarthquake;
	static String TeamID;
	static ArrayList<String> Saveleader=new ArrayList<String>() ;
	public static JComboBox comboBox_3 = new JComboBox();
	public static JComboBox comboBox_2 = new JComboBox();
	public static int help=0;
	public static int saveteam;
	public static JTextArea txtrTypeHere;
	public static String msg="";
	public static int msg_num=0;

	
	public  void AddTeam() {
		
		
		System.out.println(FRMmain.system);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Team ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 38, 83, 17);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(110, 36, 96, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Team Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(13, 86, 96, 17);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 84, 96, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Role :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 129, 61, 17);
		contentPane.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Rescue");
		comboBox.addItem("emotional support");
		comboBox.addItem("Medical Care");
		comboBox.setBounds(76, 126, 104, 26);
		contentPane.add(comboBox);
		comboBox_2.removeAllItems();
		comboBox_3.removeAllItems();
		
		for (Employee e : EmployeeLogic.getInstance().getEmployees()) {
			
			if((FRMmain.system.get(FRMmain.EventManager))!=null)
			{
			if(  (e.getPassportID()!=FRMmain.comboBox.getSelectedItem().toString()  && (FRMmain.system.get(FRMmain.EventManager).containsKey(e.getPassportID()))!=true))
				{
					comboBox_2.addItem(e.getPassportID());
				}
			
				}
			else 
			{
				if((e.getPassportID()!=FRMmain.comboBox.getSelectedItem().toString()))
				comboBox_2.addItem(e.getPassportID());

			}
		}
		
			for (Employee e : EmployeeLogic.getInstance().getEmployees()) {
				if(e.getPassportID()!=FRMmain.comboBox.getSelectedItem().toString())
				comboBox_3.addItem(e.getPassportID());
	        }
		comboBox_3.setBounds(207, 204, 101, 21);
		contentPane.add(comboBox_3);
		if(help!=0)
		{
			comboBox_3.enable(false);
		}
		role = comboBox.getSelectedItem().toString();
		PassportIdOfEmployee = comboBox_2.getSelectedItem().toString();
		PrivateNumberOfEarthquake = Main.txt_id.getText();

		JLabel lblNewLabel_4 = new JLabel("Choose Manager team :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(13, 270, 154, 17);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("	Determine Volunteer Manager :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(9, 198, 216, 26);
		contentPane.add(lblNewLabel_5);

		 txtrTypeHere = new JTextArea();
		 txtrTypeHere.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtrTypeHere.setBounds(307, 343, 221, 82);
		contentPane.add(txtrTypeHere);
        
		JLabel lblNewLabel_6 = new JLabel("Send message to the manager volunteers :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(13, 343, 307, 18);
		contentPane.add(lblNewLabel_6);
		comboBox_2.setBounds(178, 270, 106, 21);
		contentPane.add(comboBox_2);
		JButton btnNewButton_2 = new JButton("Send!");
		System.out.println(FRMmain.EventManager);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				help++;
				
				FRMmain.system.get(FRMmain.EventManager).put((String)comboBox_2.getSelectedItem(),new ArrayList<String>());
				
				if(comboBox_3.getSelectedItem().toString().equals(comboBox_2.getSelectedItem().toString()))
				{
					JOptionPane.showMessageDialog(btnNewButton_2, "Error!! team and volunter managers connot be same");
                     
				}
				else 
					
				{

					TeamID = textField.getText();
					name = textField_1.getText();
					
					if(TeamID.equals("") || name.equals(""))
					{
						JOptionPane.showMessageDialog(null, "details is blank");
						return;
					}
					
					if(FRMmain.teams_hash.containsKey(TeamID))
					{
						JOptionPane.showMessageDialog(null, "choose another Team ID");
						return;
					}
					
					adteam=TeamLogic.getInstance().addTeam(TeamID,name,role,PassportIdOfEmployee,PrivateNumberOfEarthquake);
					Integer help1=Integer.parseInt(comboBox_2.getSelectedItem().toString());
					saveteam=help1;
					Saveleader.add(PassportIdOfEmployee);
					comboBox_2.removeItem(comboBox_2.getSelectedItem());
					
					if(txtrTypeHere != null)
					{	
						
						msg=txtrTypeHere.getText();
						msg_num++;
						JOptionPane.showMessageDialog(null, "New team is Added and a Message Sent to the choosen volunter Manger");
						int result = JOptionPane.showConfirmDialog(null, "you wanna add another team?","add another team", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
						{
							FRMmain.Intilaize(); //// fetch data again ///
							textField.setText("");
							 textField_1.setText("");
								if(help!=0)
								{
									comboBox_3.enable(false);
								}
								
						}
						else
						{
							setVisible(false);
							 FRMmain test1=new FRMmain();
							 test1.setVisible(true);
							 test1.FRMmain();
						}

						
			
					}
					else
					{
						JOptionPane.showMessageDialog(null, "please Insert a Message");
						
					}
		 	
						
					
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(538, 350, 98, 34);
		contentPane.add(btnNewButton_2);
		


		
		JLabel lblNewLabel_3 = new JLabel("Generate Teams and Mangers");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(195, 11, 307, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2_1 = new JButton("Back to Menu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 	setVisible(false);
				 	FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(26, 444, 154, 34);
		contentPane.add(btnNewButton_2_1);

	}
}
