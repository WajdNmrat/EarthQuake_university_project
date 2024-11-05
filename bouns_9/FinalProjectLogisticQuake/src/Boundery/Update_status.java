package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.TeamLogic;
import entity.Employee;
import entity.Volunteer;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_status extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_status frame = new Update_status();
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
	public Update_status() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Choose volunteer :");
		lblNewLabel_1.setBounds(10, 70, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> combovolunteers = new JComboBox<String>();
		combovolunteers.setBounds(167, 66, 118, 22);
		contentPane.add(combovolunteers);
		
		JLabel lblNewLabel = new JLabel("Update volunteer status");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 26, 189, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("update status:");
		lblNewLabel_1_1.setBounds(10, 105, 147, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox<String> como_status = new JComboBox<String>();
		como_status.setBounds(167, 99, 118, 22);
		contentPane.add(como_status);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String satus = como_status.getSelectedItem().toString();
				String volID = combovolunteers.getSelectedItem().toString();
				boolean upd =TeamLogic.getInstance().updateStatus(satus, volID);
				
				if(upd)
				{
					JOptionPane.showMessageDialog(null, "status updated");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "something Wrong");
				}
				
				
			}
		});
		btnUpdate.setBounds(144, 151, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton = new JButton("back to menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					setVisible(false);
				 FRMmain test1=new FRMmain();
				 test1.setVisible(true);
				 test1.FRMmain();
			}
		});
		btnNewButton.setBounds(10, 229, 110, 23);
		contentPane.add(btnNewButton);
		
		como_status.addItem("True");
		como_status.addItem("False");
		
		for (Volunteer v : TeamLogic.getInstance().getVolunteers()) {
			
			combovolunteers.addItem(v.getPassportID());
			
		}
		
	}
}
