package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.TeamLogic;
import entity.Volunteer;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;


public class Approve_adults extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane_1;
	DefaultTableModel model;
	private JTable table;


	public Approve_adults() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> como_adults = new JComboBox<String>();
		
		como_adults.setBounds(167, 46, 125, 22);
		contentPane.add(como_adults);
		
		JLabel lblNewLabel = new JLabel("adult Volunteer LIST");
		lblNewLabel.setBounds(33, 50, 124, 14);
		contentPane.add(lblNewLabel);
		System.out.println(FRMmain.awating_AdultVolunters);
		for(Volunteer v : FRMmain.awating_AdultVolunters )
		{
			como_adults.addItem(v.getPassportID());
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 129, 586, 114);
		contentPane.add(scrollPane_1);
		
		
		
		table = new JTable();
		model = new DefaultTableModel();
		
		Object[] DataInRows = new Object[5];
		Object[] culomn = { "passportID", "name", "PhoneNumber", "Mail", "Age"};
		scrollPane_1.setViewportView(table);
		
		model.setColumnIdentifiers(culomn);
		table.setModel(model);
		
		
		
		JButton btnNewButton = new JButton("show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(Volunteer v : FRMmain.awating_AdultVolunters)
				{
					if(v.getPassportID().equals(como_adults.getSelectedItem()))
					{	
						
						DataInRows[0] = v.getPassportID();
						DataInRows[1] = v.getName();
						DataInRows[2] = v.getPhoneNumber();
						DataInRows[3] = v.getEmail();
						DataInRows[4] = v.getAge();
	
						model.addRow(DataInRows);
					}
				}
			}
		});
		btnNewButton.setBounds(321, 46, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_details_1 = new JButton("clear table");
		btn_details_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged(); // notifies the JTable that the model has changed
			}
		});
		btn_details_1.setBounds(490, 257, 106, 23);
		contentPane.add(btn_details_1);
		
		JLabel lblNewLabel_1 = new JLabel("adults approval");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(33, 11, 148, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Approve him");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String PassportId = null, Name = null, PhoneNumber = null, Email = null, Birthday, joinning,status = null;
				String Age = null,salary,Experince = null;
				
				for(Volunteer v1 : FRMmain.awating_AdultVolunters)
				{
					if(v1.getPassportID().equals(como_adults.getSelectedItem().toString()))
					{
							PassportId = v1.getPassportID();
							Name = v1.getName();
							PhoneNumber = v1.getPhoneNumber();
							Email = v1.getEmail();
							status = "true";
							Experince =v1.getExperience();
							Age= v1.getAge();
					}
				}
				
				if(FRMmain.Members_HASH.containsKey(PassportId))
				{
					JOptionPane.showMessageDialog(null, "this ID exist");
					return;
				}
				
				
				boolean AddVL = TeamLogic.getInstance().AddVolunteers (PassportId,  Name,  PhoneNumber,  Email,  Age,  Experince, status);
				como_adults.removeItem(PassportId);
				JOptionPane.showMessageDialog(btnNewButton, "Volunteer added successfully");
			}
		});
		btnNewButton_1.setBounds(321, 80, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btn_details_1_1 = new JButton("Back to Menu");
		btn_details_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				 FRMmain test1=new FRMmain();
				 test1.setVisible(true);
				 test1.FRMmain();
			}
		});
		btn_details_1_1.setBounds(10, 340, 125, 23);
		contentPane.add(btn_details_1_1);
		

	}
}
