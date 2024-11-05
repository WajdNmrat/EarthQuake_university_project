package Boundery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import Control.EarthQuakeLogic;
import Control.TeamLogic;
import entity.XmlMessage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.lang.model.element.Element;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
public class Main extends JFrame {
	private JPanel contentPane;
	public static JTextField txt_id;
	public static JTextField txt_x;
	public static JTextField txt_y;
	public static JTextField txt_power;
	public static String quakeID;
	public static DefaultTableModel model = new DefaultTableModel();
	public static String item[]=new String[4]; 
	public static int count=0;
	public static JTable table = new JTable(model);
	public static JMenuBar mb=new JMenuBar();  	
	public static	JMenu menu=new JMenu("Menu");
	public static JMenu submenu=new JMenu("jtree");
	public static String save1="" ;
	public static String save2="" ;
	public static String save3="" ;
	public static String save4="" ;
	public static String save5="" ;
	public static String date;
	public static ArrayList<String> hamada =new ArrayList<String>();
	public static ArrayList<XmlMessage> quakearray =new ArrayList<XmlMessage>();
	public boolean adearth;
	private boolean flag=false;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public   Main() {
	}
	
	
	/**
	 * Create the frame.
	 */
	public  void Main() {
		
		quakearray = EarthQuakeLogic.getInstance().getEarthQuake();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New EarthQuake Details Create XML File");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 22, 504, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(65, 74, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_id = new JTextField();
		txt_id.setBounds(121, 71, 86, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Indicator Place X");
		lblNewLabel_3.setBounds(266, 73, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		txt_x = new JTextField();
		txt_x.setBounds(403, 73, 86, 20);
		contentPane.add(txt_x);
		txt_x.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Indicator Place Y");
		lblNewLabel_4.setBounds(266, 108, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		txt_y = new JTextField();
		txt_y.setBounds(403, 105, 86, 20);
		contentPane.add(txt_y);
		txt_y.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("Add Cities");
		btnNewButton_1.setBounds(197, 326, 183, 40);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.setEnabled(false);
		
		JLabel lblNewLabel_5 = new JLabel("Power");
		lblNewLabel_5.setBounds(65, 105, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txt_power = new JTextField();
		txt_power.setBounds(121, 102, 86, 20);
		contentPane.add(txt_power);
		txt_power.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Earth quake");
		btnNewButton.setBounds(197, 275, 185, 40);
		contentPane.add(btnNewButton);
		
		JComboBox<String> comodays = new JComboBox<String>();
		comodays.setBounds(149, 145, 72, 19);
		contentPane.add(comodays);
		
		JComboBox<String> comomonths = new JComboBox<String>();
		comomonths.setBounds(149, 175, 72, 19);
		contentPane.add(comomonths);
		
		JComboBox<String> comoyears = new JComboBox<String>();
		comoyears.setBounds(149, 205, 72, 19);
		contentPane.add(comoyears);
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Day");
		lblNewLabel_2_1.setBounds(79, 147, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_7.setBounds(65, 133, 183, 113);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Month");
		lblNewLabel_2_1_1.setBounds(79, 177, 46, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Year");
		lblNewLabel_2_1_2.setBounds(79, 207, 46, 14);
		contentPane.add(lblNewLabel_2_1_2);
		btnNewButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){ 
			   
				String quakeid  = txt_id.getText();
				String date = comodays.getSelectedItem() + "/" + comomonths.getSelectedItem() + "/" + comoyears.getSelectedItem();
				
				for(XmlMessage x : quakearray)
				{
					if(x.getPrivateNumber().equals(quakeid))
					{
						JOptionPane.showMessageDialog(null, "this quake id is exists");
						return;
					}
				}
				
				 
				quakeID = txt_id.getText();				
				adearth=EarthQuakeLogic.getInstance().addXmlMessage(txt_id.getText(),date,txt_x.getText(),txt_y.getText(),txt_power.getText());
				XmlMessage x = new XmlMessage(txt_id.getText(),date,txt_x.getText(),txt_y.getText(),txt_power.getText());
				quakearray.add(x);
				
				if(adearth)
				{	
					btnNewButton.setEnabled(false);
					btnNewButton_1.setEnabled(true);
				}
			 }
             
		});
		
		
		/*if(count!=0)
		{
			txt_id.setText(save1);
			txt_date.setText(save2);
			txt_x.setText(save3);
			txt_y.setText(save4);
			txt_power.setText(save5);
			Main.item[0]=save1;
			Main.item[1]=save2;

			Main.item[2]=save3;

			Main.item[3]=save4;
				submenu.add(table);
				menu.add(submenu);	
				mb.add(menu);
				contentPane.add(mb);
		
		}
		if(count==0)
		{
			Main.model.addColumn("cities");
			mb.setBounds(421, 150, 150, 30);
			count++;
			
		}*/
		btnNewButton_1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){ 
				  save1=txt_id.getText();
			         save2=date;
			        save3=txt_x.getText();
			         save4=txt_y.getText();
			         save5=txt_power.getText();
			         
				 setVisible(false);
				 CityMain test1=new CityMain();
				 test1.setVisible(true);
				 test1.CityMain();
				 
			 }

		});
		
	}
}

