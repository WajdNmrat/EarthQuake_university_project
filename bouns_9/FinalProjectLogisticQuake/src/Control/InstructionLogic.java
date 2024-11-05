package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Consts;
import entity.Employee;
import entity.Instruction;

public class InstructionLogic {
	private static InstructionLogic _instance;

	private InstructionLogic() {
	}

	public static InstructionLogic getInstance() {
		if (_instance == null)
			_instance = new InstructionLogic();
		return _instance;
	}

	/**
	 * fetches all employees from DB file.
	 * 
	 * @return ArrayList of employees.
	 */
	public ArrayList<Instruction> getInstructions() {
		ArrayList<Instruction> results = new ArrayList<Instruction>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_INSTURCTIONS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Instruction(rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	/*----------------------------------------- ADD / REMOVE / UPDATE EMPLOYEE METHODS --------------------------------------------*/

	/**
	 * Adding a new Employee with the parameters received from the form. return true
	 * if the insertion was successful, else - return false
	 * 
	 * @return
	 */
	public boolean addInstructions(String id,String topic, String type, String date, String maxNumOfParticipant, String employee) {
		try {
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); // from string to DATE
			
			Date date1=null;
			try {
				date1 = sdf1.parse(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println(date);
			System.out.println(date1);
			
			java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
			
			
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_INSTURCTIONS)) {

				int i = 1;
				stmt.setString(i++, id);// can't be null
				stmt.setString(i++, topic); // can't be null
				stmt.setString(i++, type);// can't be null
	
				if (sqlStartDate != null)
					stmt.setDate(i++, sqlStartDate);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (maxNumOfParticipant != null)
					stmt.setString(i++, maxNumOfParticipant);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (employee != null)
					stmt.setString(i++, employee);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				
				stmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean add_volunteerToInstruction(String volunteerId,String courseID,String grade) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_VOLUNTEERtoInstructions)) {

				int i = 1;
				stmt.setString(i++, volunteerId);// can't be null
				stmt.setString(i++, courseID); // can't be null
				stmt.setString(i++, grade);// can't be null
				
				stmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updategrades( String grade, String InstructionCode, String passportID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_GRADE)) {
				int i = 1;
				stmt.setString(i++, passportID);
				stmt.setString(i++, InstructionCode);
				stmt.setString(i++, grade);
				
				
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
