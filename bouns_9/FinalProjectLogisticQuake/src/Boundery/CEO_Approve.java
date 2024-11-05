package Boundery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class CEO_Approve extends JFrame {

	private JPanel contentPane;
	public static JComboBox comboBox_ceo;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CEO_Approve frame = new CEO_Approve();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CEO_Approve() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Volunter's List to Approve");
		lblNewLabel.setBounds(26, 62, 137, 19);
		contentPane.add(lblNewLabel);
		
		comboBox_ceo = new JComboBox();
		comboBox_ceo.setBounds(173, 60, 116, 21);
		contentPane.add(comboBox_ceo);
		
		
	}
}
