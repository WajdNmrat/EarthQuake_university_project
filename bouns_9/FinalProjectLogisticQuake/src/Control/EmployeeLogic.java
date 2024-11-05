package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.Employee;

public class EmployeeLogic {
	private static EmployeeLogic _instance;

	private EmployeeLogic() {
	}

	public static EmployeeLogic getInstance() {
		if (_instance == null)
			_instance = new EmployeeLogic();
		return _instance;
	}

	/**
	 * fetches all employees from DB file.
	 * 
	 * @return ArrayList of employees.
	 */
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> results = new ArrayList<Employee>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_EMPLOYEES);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Employee(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++)));
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
	public boolean addEmployee(String ID, String name, String phoneNumber, String email, String age, String experience,
			String role, String salary, String birthday, String joinning) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_EMPLOYEE)) {

				int i = 1;
				if (ID != null)
					stmt.setString(i++, ID);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (name != null)
					stmt.setString(i++, name);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (phoneNumber != null)
					stmt.setString(i++, phoneNumber);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (email != null)
					stmt.setString(i++, email);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (age != null)
					stmt.setString(i++, age);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (experience != null)
					stmt.setString(i++, experience);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (role != null)
					stmt.setString(i++, role);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (salary != null)
					stmt.setString(i++, salary);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (birthday != null)
					stmt.setString(i++, birthday);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				
				if (joinning != null)
					stmt.setString(i++, joinning);
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

}
