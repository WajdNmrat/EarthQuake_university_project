package Boundery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.ReportingLogic;
import Entity.Injured;
import Entity.Report;

public class AddReport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Boolean addReport;
	private Boolean addInjured;
	private Boolean addReToIn;

	/**
	 * Create the frame.
	 */
	public AddReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter your private number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 23, 197, 19);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(204, 21, 109, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter private number of the report : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 58, 259, 19);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(250, 58, 102, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Enter the date of found the injured :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 106, 247, 19);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(260, 104, 96, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Enter the location :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 191, 137, 19);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(144, 189, 109, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Enter the private number of the injured :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 239, 277, 19);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(286, 237, 96, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Enter the name of the injured :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 288, 211, 19);
		contentPane.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setBounds(231, 286, 102, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Enter the ID of the injured :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 330, 197, 19);
		contentPane.add(lblNewLabel_6);

		textField_6 = new JTextField();
		textField_6.setBounds(204, 328, 102, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("situation of the injured :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 370, 162, 19);
		contentPane.add(lblNewLabel_7);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("easy");
		comboBox.addItem("medium");
		comboBox.addItem("hard");
		comboBox.addItem("die");
		comboBox.setBounds(182, 371, 105, 21);
		contentPane.add(comboBox);

		JLabel lblNewLabel_8 = new JLabel("dose the injured take a rescution :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 416, 243, 19);
		contentPane.add(lblNewLabel_8);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("true");
		comboBox_1.addItem("false");
		comboBox_1.setBounds(256, 417, 96, 21);
		contentPane.add(comboBox_1);

		JLabel lblNewLabel_10 = new JLabel("Hour :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(286, 156, 67, 14);
		contentPane.add(lblNewLabel_10);

		JComboBox comboBox_2 = new JComboBox();
		for (Integer i = 1; i <= 24; i++) {
			comboBox_2.addItem(i);
		}
		comboBox_2.setBounds(340, 155, 67, 21);
		contentPane.add(comboBox_2);

		JLabel lblNewLabel_11 = new JLabel("Minute :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(429, 159, 61, 14);
		contentPane.add(lblNewLabel_11);

		JComboBox comboBox_3 = new JComboBox();
		for (Integer i = 0; i <= 60; i++) {
			comboBox_3.addItem(i);
		}
		comboBox_3.setBounds(493, 155, 61, 21);
		contentPane.add(comboBox_3);

		JButton btnNewButton = new JButton("Add Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IdOfExtractor, privateNumberOfReport, date, location, injuredPrivateNumber, InjuredName,
						InjuredID, situation, rescution, hour, minute;
				IdOfExtractor = textField.getText();
				privateNumberOfReport = textField_1.getText();
				date = textField_2.getText();
				location = textField_3.getText();
				injuredPrivateNumber = textField_4.getText();
				InjuredName = textField_5.getText();
				InjuredID = textField_6.getText();
				situation = (String) comboBox.getSelectedItem();
				rescution = (String) comboBox_1.getSelectedItem();
				hour = comboBox_2.getSelectedItem().toString();
				minute = comboBox_3.getSelectedItem().toString();
				ArrayList<String> reportsCodes = new ArrayList<String>();
				for (Report report : ReportingLogic.getInstance().getReports()) {
					reportsCodes.add(report.getPrivateNUmber());
				}
				if (!reportsCodes.contains(privateNumberOfReport)) {
					addReport = ReportingLogic.getInstance().addReport(privateNumberOfReport, date, IdOfExtractor, hour,
							minute);
					reportsCodes.add(privateNumberOfReport);
					JOptionPane.showMessageDialog(btnNewButton, "Report Added Successfully");
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "This Report already exist");
				}
				ArrayList<String> InjuredPrivateNumber = new ArrayList<String>();
				for (Injured injured : ReportingLogic.getInstance().getInjureds()) {
					InjuredPrivateNumber.add(injured.getPrivateNumber());
				}
				if (!InjuredPrivateNumber.contains(injuredPrivateNumber)) {
					addInjured = ReportingLogic.getInstance().addInjured(injuredPrivateNumber, InjuredName, InjuredID);
					InjuredPrivateNumber.add(injuredPrivateNumber);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "This Injured already exist");
				}
				addReToIn = ReportingLogic.getInstance().addInjuredInReports(privateNumberOfReport,
						injuredPrivateNumber, location, situation, rescution);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(429, 312, 178, 47);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_9 = new JLabel("Enter the hour and minute of report :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 154, 259, 19);
		contentPane.add(lblNewLabel_9);

		JButton btnNewButton_1 = new JButton("Return to Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomePage().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(429, 388, 178, 47);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Odeh\\Pictures\\Task-Report-Animation-Blog.gif"));
		lblNewLabel_12.setBounds(0, 0, 636, 463);
		contentPane.add(lblNewLabel_12);

	}
}
