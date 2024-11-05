package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Control.TeamLogic;
import entity.Employee;
import entity.Team;
import entity.Volunteer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddVolunteer extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private ArrayList<Volunteer> volunteers;
	private JLabel lblNewLabel;
	private static JComboBox comboBox;
	private Boolean AddVtoT;
	private Double counter = 0.0;
	private Double X;
	private JButton btnNewButton_3;
	private boolean addTeam;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	public static String deletold;
	private JScrollPane scrollPane_1;
	DefaultTableModel model;
	private JTable table;
	public static ArrayList<String> selected_volunters= new ArrayList<String>();
   public String help2;
   private JButton btn_details_1;
   private JLabel lblChooseTeam;
   public static JComboBox comoTeam= new JComboBox<>();
   public static boolean first=true;
   
	public AddVolunteer() {

		
		JOptionPane.showMessageDialog(null, AddTeam.msg);
		
		
		volunteers = TeamLogic.getInstance().getVolunteers();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				Double D, P;
				DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder builder=factory.newDocumentBuilder();
					Document doc=builder.parse("src/HW2.xml");
					NodeList personlist=doc.getElementsByTagName("Earthquake");
					Node p=personlist.item(0);
					Element person=(Element)p;
					NodeList personlist1=person.getElementsByTagName("power");
					P = Double.valueOf(personlist1.item(0).getTextContent());
					 personlist1=person.getElementsByTagName("distanceFromIsrael");
					D = Double.valueOf(personlist1.item(0).getTextContent());
					
					System.out.println(D*P);
				} catch (ParserConfigurationException e1) {
					P=0.0;
					D=0.0;
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					P=0.0;
					D=0.0;
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					P=0.0;
					D=0.0;
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				//////////table//////////
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 146, 586, 100);
				contentPane.add(scrollPane_1);
	
				table = new JTable();
				model = new DefaultTableModel();
				
				Object[] DataInRows = new Object[7];
				Object[] culomn = { "passportID", "name", "PhoneNumber", "Mail", "Age","Experince","status" };
				scrollPane_1.setViewportView(table);
				
				model.setColumnIdentifiers(culomn);
				table.setModel(model);
				
				//////////table///////////
				
				X = TeamLogic.getInstance().DetermineTeamSize(D, P);
				ArrayList<String> x;
				
				
		btnNewButton = new JButton("Add Volunteer");
		comoTeam.setBounds(148, 111, 116, 21);
		contentPane.add(comoTeam);
		
		
		comboBox = new JComboBox();
		comboBox.removeAllItems();
		System.out.println("okay1");
		
		System.out.println(first+" ********************");
		
		System.out.println(selected_volunters);
		for (Volunteer v : TeamLogic.getInstance().getVolunteers()) 
		{
			
			if((FRMmain.system.get(FRMmain.EventManager))!=null)
			{	
				
				if(  (!(selected_volunters.contains(v.getPassportID()))) && ((v.getPassportID()!= FRMmain.comboBox.getSelectedItem().toString())))  
				{
					//// checking approval of the CEO ////
					/*if(Integer.valueOf(v.getAge()) > 55 )
					{
						CEO_Approve.comboBox_ceo.addItem(v.getPassportID());
						CEO_Approve ceo = new CEO_Approve();
						ceo.setVisible(true);
					}*/

					comboBox.addItem(v.getPassportID());
					
					
					
				}
				
			}
			else 
			{	
				System.out.println("here4");
				comboBox.addItem(v.getPassportID());

			}
		}
		
		
		if(first==true)
		{
			for (Team v : TeamLogic.getInstance().getTeams()) {
				comoTeam.addItem(v.getTeamID());
				
			}
			first=false;
		}

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String VolunteerID;

				if (counter < X) {
					System.out.println(FRMmain.system);
					help2=String.valueOf(AddTeam.saveteam);
					VolunteerID = comboBox.getSelectedItem().toString();
					
					
					

					
					AddVtoT = TeamLogic.getInstance().addVolunteerToTeam(comoTeam.getSelectedItem().toString(),VolunteerID);
					JOptionPane.showMessageDialog(btnNewButton, "Volunteer added successfully to team");
					comboBox.removeItem(VolunteerID);
					comoTeam.enable(false);
					selected_volunters.add(VolunteerID);

					FRMmain.system.get(FRMmain.EventManager).get(help2).add((VolunteerID));
					counter++;
					
				
					
					
				}
				if (counter >= X) {
					JOptionPane.showMessageDialog(null," Wrong!! the number of the volunteers team completed");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(209, 258, 160, 31);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("Choose Volunteer ID to add him :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 83, 220, 17);
		contentPane.add(lblNewLabel);
		comboBox.setBounds(250, 83, 116, 21);
		contentPane.add(comboBox);
		btnNewButton_3 = new JButton("Scheduling volunters to the team");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (counter < X) {
					JOptionPane.showMessageDialog(btnNewButton_3,
							"you have to add volunteers to team to complete the number");
				}
				if (counter >= X) {
					JOptionPane.showMessageDialog(btnNewButton, "Volunters added to the Teams Successfully");
					comoTeam.enable(true);
					comoTeam.removeItem(comoTeam.getSelectedItem().toString());
					 setVisible(false);
					 FRMmain test1=new FRMmain();
						test1.setVisible(true);
						test1.FRMmain();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(118, 300, 358, 42);
		contentPane.add(btnNewButton_3);

		btnNewButton_1 = new JButton("Back to menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(490, 411, 160, 42);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("The allowed team size is:");
		lblNewLabel_1.setBounds(24, 34, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(250, 31, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String z=X+".";
		textField.setText(z);
		
		

		
		JButton btn_details = new JButton("show volunteer details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for(Volunteer v : FRMmain.volunterarray)
				{
					if(v.getPassportID().equals(comboBox.getSelectedItem()))
					{	
						
						DataInRows[0] = v.getPassportID();
						DataInRows[1] = v.getName();
						DataInRows[2] = v.getPhoneNumber();
						DataInRows[3] = v.getEmail();
						DataInRows[4] = v.getAge();
						DataInRows[5] = v.getExperience();
						DataInRows[6] = v.getAccept();
						
						model.addRow(DataInRows);
					}
				}
				
				
				
			}
		});
		btn_details.setBounds(415, 82, 168, 23);
		contentPane.add(btn_details);
		
		btn_details_1 = new JButton("clear table");
		btn_details_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged(); // notifies the JTable that the model has changed
				
				
			}
		});
		btn_details_1.setBounds(415, 112, 116, 23);
		contentPane.add(btn_details_1);
		
		lblChooseTeam = new JLabel("Choose Team:");
		lblChooseTeam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseTeam.setBounds(10, 111, 132, 17);
		contentPane.add(lblChooseTeam);
		


		
		

		
		
		
		
	}
}
