package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.InstructionLogic;
import entity.Instruction;
import entity.Volunteer;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class add_TrainVolunter extends JFrame {

	private JPanel contentPane;
	private boolean add;



	/**
	 * Create the frame.
	 */
	public add_TrainVolunter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assign Volunters to Training");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 88, 228, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> como_coursess = new JComboBox<String>();
		como_coursess.setBounds(259, 59, 234, 19);
		contentPane.add(como_coursess);
		
		JLabel lblChooseCourse = new JLabel("choose from available Courses");
		lblChooseCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChooseCourse.setBounds(21, 55, 228, 22);
		contentPane.add(lblChooseCourse);
		
		JComboBox<String> como_volunters = new JComboBox<String>();
		como_volunters.setBounds(259, 92, 234, 19);
		contentPane.add(como_volunters);
		
		JLabel lblNewLabel_1 = new JLabel("Assign volunters to courses");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 26, 272, 22);
		contentPane.add(lblNewLabel_1);
		

		
		JLabel lblNewLabel_2 = new JLabel("grade");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(21, 121, 56, 22);
		contentPane.add(lblNewLabel_2);
		
		JComboBox<String> como_grades = new JComboBox<String>();
		como_grades.setBounds(87, 125, 56, 19);
		contentPane.add(como_grades);
		
		JLabel lblNewLabel_2_1 = new JLabel("note:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(21, 154, 56, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Grade \"8888\" is the default grade, means the volunter no yet examed");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(31, 171, 417, 29);
		contentPane.add(lblNewLabel_2_2);
		
		if(FRMmain.instrcutions_codes != null)
		{
			for(Instruction inst : FRMmain.instrcutions_codes)
			{	
					como_coursess.addItem(inst.getId());

			}
		}
		
		como_grades.addItem("8888");
		
		if(FRMmain.volunterarray != null)
		{
			for(Volunteer inst1 : FRMmain.volunterarray)
			{	
				como_volunters.addItem(inst1.getPassportID());

			}
		}
		
		for (int i = 1; i <= 100; i++) {
			
			como_grades.addItem(String.valueOf(i));
			
		}

		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String volunterID = como_volunters.getSelectedItem().toString();
				String courseID = como_coursess.getSelectedItem().toString();
				String grade = como_grades.getSelectedItem().toString();
				System.out.println(grade+ " " + volunterID + " " + courseID );
				add=InstructionLogic.getInstance().add_volunteerToInstruction(volunterID, courseID, grade);
				if(add)
				{
					JOptionPane.showMessageDialog(null, "succesfully updated");
				}
				
			}
		});
		btnNewButton.setBounds(180, 123, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBackToMenu = new JButton("Back To Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 setVisible(false);
				 FRMmain test1=new FRMmain();
					test1.setVisible(true);
					test1.FRMmain();
			}
		});
		btnBackToMenu.setBounds(21, 243, 122, 23);
		contentPane.add(btnBackToMenu);
		
		JButton btnUpdate = new JButton("update this grade");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String volunterID = como_volunters.getSelectedItem().toString();
				String courseID = como_coursess.getSelectedItem().toString();
				String grade = como_grades.getSelectedItem().toString();
				System.out.println(grade+ " " + volunterID + " " + courseID );
				add=InstructionLogic.getInstance().updategrades(volunterID, courseID, grade);
				if(add)
				{
					JOptionPane.showMessageDialog(null, "updated");
				}
				
			}
		});
		btnUpdate.setBounds(290, 243, 158, 23);
		contentPane.add(btnUpdate);
		
		
		
		
		
		
		
		

		
		
		
		
	}
}
