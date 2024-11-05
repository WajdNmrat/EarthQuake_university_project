package Control;
import entity.Employee;
import entity.Team;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.Volunteer;
import entity.XmlMessage;
public class TeamLogic {
	private static TeamLogic _instance;

	private TeamLogic() {
	}

	public static TeamLogic getInstance() {
		if (_instance == null)
			_instance = new TeamLogic();
		return _instance;
	}

	public ArrayList<Volunteer> getVolunteers() {
		ArrayList<Volunteer> AllVolunteers = new ArrayList<Volunteer>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_VOLUNTEER);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					AllVolunteers.add(new Volunteer(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return AllVolunteers;
	}
	
	public boolean AddVolunteers(String passportID, String name, String phoneNumber, String email, String age, String experience,
			String accept) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_VOLUNTEER)) {

				int i = 1;
				stmt.setString(i++, passportID);// can't be null
				stmt.setString(i++, name); // can't be null
				stmt.setString(i++, phoneNumber);// can't be null
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
				
				if (accept != null)
					stmt.setString(i++, accept);
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
	
	public boolean updateStatus( String status, String volunteerID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_STATUS)) {
				int i = 1;
				stmt.setString(i++, status);
				stmt.setString(i++, volunteerID);
	
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



	public boolean addVolunteerToTeam(String TeamID, String VolunteerID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_VOLUNTEERSTOTEAM)) {

				int i = 1;
				stmt.setString(i++, TeamID);
				stmt.setString(i++, VolunteerID);

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

	public boolean addTeam(String TeamID, String name, String Role, String PassportIdOfEmployee,
			String PrivateNumberOfEarthQuake) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_TEAM)) {

				int i = 1;
				if (TeamID != null)
					stmt.setString(i++, TeamID);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				stmt.setString(i++, name); // can't be null
				stmt.setString(i++, Role); // can't be null
				stmt.setString(i++, PassportIdOfEmployee); // can't be null
				stmt.setString(i++, PrivateNumberOfEarthQuake);

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

	public Double DetermineTeamSize(Double D, Double P) {
		Double teamSize = ((D * P) % 9) + 2;
		return teamSize;
	}
	public ArrayList<Employee> Employee(){
		ArrayList<Employee> AllEmployee = new ArrayList<Employee>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_EMPLOYEES);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					AllEmployee.add(new Employee(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return AllEmployee;
	}
	
	
	public ArrayList<Team> getTeams() {
		ArrayList<Team> results = new ArrayList<Team>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_TEAM);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Team(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
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

	
	

	
	
}
