package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Control.EarthQuakeLogic;
import entity.XmlMessage;

public class ShowEarthQuakeDetailsFromXml extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	public ShowEarthQuakeDetailsFromXml() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton_1 = new JButton("Press to get the Details from the xml message");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File inputFile = new File("src/HW2.xml");
					org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
							.parse(inputFile);
					((org.w3c.dom.Document) doc).getDocumentElement().normalize();

					NodeList nList = ((org.w3c.dom.Document) doc).getElementsByTagName("earthquake");

					for (int i = 0; i < nList.getLength(); i++) {
						Node node = nList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) { // not Attr, Text, etc.
							Element elem = (Element) node;
							SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
							XmlMessage xmlMessage = new XmlMessage(elem.getAttribute("privateNumber"),
									elem.getElementsByTagName("date").item(i).getTextContent(),
									
											elem.getElementsByTagName("IndicatorPlaceX").item(i).getTextContent(),
									
											elem.getElementsByTagName("IndicatorPlacey").item(i).getTextContent(),
									elem.getElementsByTagName("power").item(i).getTextContent());
							EarthQuakeLogic.allEarthQuakes.add(xmlMessage);
							EarthQuakeLogic.getInstance().addXmlMessage(xmlMessage.getPrivateNumber(),
									xmlMessage.getDate(), xmlMessage.getIndicatorPlaceX(),
									xmlMessage.getIndicatorPlacey(), xmlMessage.getPower());
						}
					}
				} catch (Exception e1) {
					// TODO: handle exception
				}
				JOptionPane.showMessageDialog(btnNewButton_1, "Details recevied successfully");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 10, 354, 39);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 108, 531, 257);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel();

		Object[] DataInRows = new Object[6];
		Object[] culomn = { "PrivateNumber", "Date", "IndicatorPlaceX", "IndicatorPlaceY", "Power", "DamagedCities" };
		scrollPane.setViewportView(table);

		model.setColumnIdentifiers(culomn);
		table.setModel(model);

		btnNewButton = new JButton("Show Details ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (XmlMessage xmlMessage : EarthQuakeLogic.allEarthQuakes) {
					DataInRows[0] = xmlMessage.getPrivateNumber();
					DataInRows[1] = xmlMessage.getDate();
					DataInRows[2] = xmlMessage.getIndicatorPlaceX();
					DataInRows[3] = xmlMessage.getIndicatorPlacey();
					DataInRows[4] = xmlMessage.getPower();
					model.addRow(DataInRows);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(401, 63, 159, 39);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("Press on \"Show Details\" to see the Details of the Earthquakes :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 72, 398, 22);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Back to menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(182, 375, 170, 28);
		contentPane.add(btnNewButton_2);
	}
}
