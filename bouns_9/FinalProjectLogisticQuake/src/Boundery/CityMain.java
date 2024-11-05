package Boundery;
import java.awt.BorderLayout;
import java.util.ArrayList;

import java.util.Map;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.Text;

import Control.EarthQuakeLogic;
import Control.TeamLogic;
import entity.City;
import entity.Country;
import entity.Employee;

import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

public class CityMain extends JFrame {
	
	public  CityMain() {
	}
	
	private JPanel contentPane;
	private JTextField id_txt;
	private JTextField txt_name;
	private JTextField txt_distance;
	public static int countsities=0;
	public boolean adcity;
	public boolean adcitytoearth;
	public boolean addcontry;
	private int number=0,count=0;
	private ArrayList<String> citiesID = new ArrayList<String>();
	private ArrayList<String> citiessaves = new ArrayList<String>();
	private ArrayList<City> currentcities= new ArrayList<City>();
	private ArrayList<Country> currentcountries= new ArrayList<Country>();
	private int flag=1;
	private int flag2=1;
	

	

	public static  ArrayList<Country> country_codes=new ArrayList<Country>();
	private JTextField txt_countryname;
	

	
	public void CityMain() {
		
		currentcities=EarthQuakeLogic.getInstance().getCities();
		currentcountries=EarthQuakeLogic.getInstance().getcountiresCode();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Damaged Cities");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(160, 21, 157, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("City ID");
		lblNewLabel_1.setBounds(28, 71, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		id_txt = new JTextField();
		id_txt.setBounds(120, 68, 86, 20);
		contentPane.add(id_txt);
		id_txt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("City Name");
		lblNewLabel_2.setBounds(28, 96, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_name = new JTextField();
		txt_name.setBounds(120, 93, 86, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Distance from Israel");
		lblNewLabel_4.setBounds(28, 121, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		txt_distance = new JTextField();
		txt_distance.setBounds(160, 118, 86, 20);
		contentPane.add(txt_distance);
		txt_distance.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("CountryName");
		lblNewLabel_3.setBounds(38, 153, 77, 14);
		contentPane.add(lblNewLabel_3);
		txt_countryname = new JTextField();
		txt_countryname.setBounds(160, 150, 86, 20);
		contentPane.add(txt_countryname);
		txt_countryname.setColumns(10);
		JButton btnSendXmlTo = new JButton("send XML to LogisticQuake");
		btnSendXmlTo.setEnabled(false);
		
		 String num = JOptionPane.showInputDialog("how many cities you wanna add ?");
		 try {
			 number = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "please Insert a vaild number");
		}

		 if(number<1)
		 {
			 JOptionPane.showMessageDialog(null, "Insert a positive number");
			  num = JOptionPane.showInputDialog("how many cities you wanna add ?");
		 }
		 

			
			
		JButton btnNewButton = new JButton("add City");
		btnNewButton.setBounds(62, 228, 161, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){ 
				 countsities++;
				 Main.item[0]=id_txt.getText();
				 Main.item[1]=txt_name.getText();
				 Main.item[2]=txt_countryname.getText();
				 Main.item[3]=txt_distance.getText();
				 



						citiesID.add(id_txt.getText());
						citiessaves.add(id_txt.getText());
						citiessaves.add(txt_name.getText());
						citiessaves.add(txt_countryname.getText());
						citiessaves.add(txt_distance.getText());
					
					String dis = txt_distance.getText();
					
					if(txt_countryname.getText().length()<3)
					{
			        	 JOptionPane.showMessageDialog(null, "country must contain at least 3 letters must be number");  
			        	 return;
					}
					
					char[] chars = dis.toCharArray();
					
				      for(char c : chars)
				      {
				          if(!(Character.isDigit(c)))
				          {
				        	 JOptionPane.showMessageDialog(null, "distance must be number");  
				        	 return;
				          }
				      }
				          

					for(City s:currentcities)//a
                    {
                   	 if(s.getCityNumber().equals(id_txt.getText()) || id_txt.getText().equals("") || txt_name.getText().equals("") || txt_countryname.getText().equals("") ||  txt_distance.getText().equals(""))
                   	 {
                   		 
                   		 JOptionPane.showMessageDialog(null, "city id exists or details is  blank");
                   		 return;
                   	 }
                    }
					
				 	
					String letter1=Character.toString(txt_countryname.getText().charAt(0));
					String letter2=Character.toString(txt_countryname.getText().charAt(1));
					String letter3=Character.toString(txt_countryname.getText().charAt(2));
					String capatial=new String(letter1+letter2+letter3);
					
					

					
					
					for(Country c : currentcountries)
                    {
						System.out.println(c.getCountry3letters());
						System.out.println("searching for " + capatial.toUpperCase()+txt_countryname.getText());
						if(c.getCountry3letters().equals(capatial.toUpperCase()+txt_countryname.getText()))
                   	 	{
                   		 flag2=0;
                   		 System.out.println("found");
                   		 break;
                   	 	}
 
                    }
					System.out.println("here1");
					if(flag2==1) // this  country has not been before
					{
 						addcontry=EarthQuakeLogic.getInstance().addcontry(capatial.toUpperCase()+txt_countryname.getText(),txt_countryname.getText());
 						Country c1 = new Country(capatial.toUpperCase()+txt_countryname.getText(),txt_countryname.getText());
 						currentcountries.add(c1);
 						System.out.println("here2");
					}
						
					System.out.println("here3");
                         if(flag==1)
                         { 	 					System.out.println("here4");
                        	 adcity=EarthQuakeLogic.getInstance().addCity(id_txt.getText(),txt_name.getText(),capatial.toUpperCase()+txt_countryname.getText(),txt_distance.getText());
                        	 adcitytoearth=EarthQuakeLogic.getInstance().addcitytoearth(Main.txt_id.getText(),id_txt.getText());
                        	 JOptionPane.showMessageDialog(null, "City added");
                        	 City c = new City(id_txt.getText(),txt_name.getText(),capatial.toUpperCase()+txt_countryname.getText(),txt_distance.getText());
                        	 currentcities.add(c);
                        	 
                        	 
                        	 id_txt.setText("");
                        	 txt_name.setText("");
                        	 txt_distance.setText("");
                        	 txt_countryname.setText("");
                        	 count++;
						
                         }
                         
					
				
     					System.out.println("here5");
				if(count==number)
				{
					System.out.println("here6");
					btnSendXmlTo.setEnabled(true);
					btnNewButton.setEnabled(false);
				}

			 }}); 
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(382, 415, 132, 30);
		contentPane.add(btnNewButton_1);
		
		
		
		btnSendXmlTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Main.item[0]!=""&&Main.item[1]!=""&&Main.item[2]!=""&&Main.item[3]!="")
				{
			for(String G:Main.item)
			{
				Main.hamada.add(G);		
			}
				}
				 String path="src/HW2.xml";
				    File f=new File(path);
				    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
				    try {
						DocumentBuilder builder=dbf.newDocumentBuilder();
						 org.w3c.dom.Document doc = builder.newDocument();
						 //root
						 org.w3c.dom.Element root= doc.createElement("XmlMessages");
						 //create children
						 org.w3c.dom.Element quake= doc.createElement("Earthquake");
						 org.w3c.dom.Element quakeid= doc.createElement("ID");
						 Text idValue=((org.w3c.dom.Document) doc).createTextNode(Main.txt_id.getText());
						 ((Node) quakeid).appendChild(idValue);
						//create children DATE
						 org.w3c.dom.Element quakeDate= doc.createElement("date");
						 Text idValue1=((org.w3c.dom.Document) doc).createTextNode(Main.date);
						 ((Node) quakeDate).appendChild(idValue1);
						//create children PLACE X
						 org.w3c.dom.Element quakePlacex=doc.createElement("IndicatorPlaceX");
						 Text idValue2=((org.w3c.dom.Document) doc).createTextNode(Main.txt_x.getText());
						 ((Node) quakePlacex).appendChild(idValue2);	
						 //create children PLACE Y
						 org.w3c.dom.Element quakePlacey= doc.createElement("IndicatorPlacey");
						 Text idValue3=((org.w3c.dom.Document) doc).createTextNode(Main.txt_y.getText());
						 ((Node) quakePlacey).appendChild(idValue3);
						 //create children POWER
						 org.w3c.dom.Element quakePower= doc.createElement("power");
						 Text idValue4=((org.w3c.dom.Document) doc).createTextNode(Main.txt_power.getText());
						 ((Node) quakePower).appendChild(idValue4);	
						 //create cities
						 org.w3c.dom.Element quakecities= doc.createElement("city");
						 int i;
						 org.w3c.dom.Element rootcities= doc.createElement("cities");
	                      int help=0;
						 for(i=0;i<CityMain.countsities;i++)
						 {
							 //create children
							 org.w3c.dom.Element idcity= doc.createElement("city");
							 org.w3c.dom.Element quakcity= doc.createElement("cityNumber");
							 Text city=((org.w3c.dom.Document) doc).createTextNode(citiessaves.get(help+0));
							 ((Node) quakcity).appendChild(city);
							//create children DATE
							 org.w3c.dom.Element namecity= doc.createElement("CityName");
							 Text nameValue1=((org.w3c.dom.Document) doc).createTextNode(citiessaves.get(help+1));
							 ((Node) namecity).appendChild(nameValue1);
							//create children PLACE X
							 org.w3c.dom.Element countrycity=doc.createElement("country");
							 Text countryValue2=((org.w3c.dom.Document) doc).createTextNode(citiessaves.get(help+2));
							 ((Node) countrycity).appendChild(countryValue2);	
							 //create children PLACE Y
							 org.w3c.dom.Element distancecity= doc.createElement("distanceFromIsrael");
							 Text distanceValue3=((org.w3c.dom.Document) doc).createTextNode(citiessaves.get(help+3));
							 ((Node) distancecity).appendChild(distanceValue3);
							 
							 
							 ((Node) idcity).appendChild((Node) quakcity);
							 ((Node) idcity).appendChild((Node) namecity);
							 ((Node) idcity).appendChild((Node) countrycity);
							 ((Node) idcity).appendChild(distancecity);

							 ((Node) rootcities).appendChild((Node) idcity);
							 help=help+4;
						 }
						 //add to stednt node
						 ((Node) quake).appendChild((Node) quakeid);
						 ((Node) quake).appendChild((Node) quakeDate);
						 ((Node) quake).appendChild((Node) quakePlacex);
						 ((Node) quake).appendChild((Node) quakePlacey);
						 ((Node) quake).appendChild((Node) quakePower);
						 ((Node) quake).appendChild((Node)rootcities);
						 //add to root
						 ((Node) root).appendChild((Node) quake);
						 //add to document
						 ((Node) doc).appendChild((Node) root);
	                        //write from temp
						 DOMSource source=new DOMSource((Node) doc);
						 StreamResult result=new StreamResult(f);
						 TransformerFactory transformerFactory=TransformerFactory.newInstance();
						 Transformer transFormer =transformerFactory.newTransformer();
						 transFormer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"no");
						 transFormer.setOutputProperty(OutputKeys.INDENT,"yes");
						 transFormer.transform(source,result);
						 
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null, "xml generated and sended");
				setVisible(false);
				FRMmain test1=new FRMmain();
				test1.setVisible(true);
				test1.FRMmain();
			}
		});
		btnSendXmlTo.setBounds(62, 269, 161, 30);
		contentPane.add(btnSendXmlTo);
		
		

		btnNewButton_1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){ 
				 
				 Main.item[0]="";
				 Main.item[1]="";
				 Main.item[2]="";
				 Main.item[3]="";
				setVisible(false);
				Main test1=new Main();
				test1.setVisible(true);
				test1.Main();
				 
			 }

		});
	
		}
}