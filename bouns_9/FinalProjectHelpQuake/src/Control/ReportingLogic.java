package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Consts;
import Entity.Injured;
import Entity.InjuredInReport;
import Entity.Report;

public class ReportingLogic {
	private static ReportingLogic _instance;

	private ReportingLogic() {
	}

	public static ReportingLogic getInstance() {
		if (_instance == null)
			_instance = new ReportingLogic();
		return _instance;
	}

	public ArrayList<Report> getReports() {
		ArrayList<Report> allReports = new ArrayList<Report>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_REPORTING);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					allReports.add(new Report(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allReports;
	}

	public ArrayList<Injured> getInjureds() {
		ArrayList<Injured> allInjureds = new ArrayList<Injured>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_REPORTING);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					allInjureds.add(new Injured(rs.getString(i++), rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allInjureds;
	}

	public ArrayList<InjuredInReport> getInjuredInReports() {
		ArrayList<InjuredInReport> allInjuredInReports = new ArrayList<InjuredInReport>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_InjuredInReport);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					allInjuredInReports.add(new InjuredInReport(rs.getString(i++), rs.getString(i++), rs.getString(i++),
							rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allInjuredInReports;
	}

	public boolean addInjured(String PrivateNumber, String Name, String ID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_INJURED)) {

				int i = 1;
				stmt.setString(i++, PrivateNumber);
				stmt.setString(i++, Name); // can't be null
				stmt.setString(i++, ID); // can't be null

				stmt.execute();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addReport(String PrivateNumber, String dateExitOfTheInjured, String privateNumberOfExtractor,
			String Hour, String Minute) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_REPORTING)) {

				int i = 1;
				stmt.setString(i++, PrivateNumber);
				stmt.setString(i++, dateExitOfTheInjured); // can't be null
				stmt.setString(i++, privateNumberOfExtractor);
				stmt.setString(i++, Hour);
				stmt.setString(i++, Minute);
				stmt.execute();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addInjuredInReports(String PrivateNumberOfReport, String PrivateNumberOfInjured, String Location,
			String Situation, String Rescation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_InjuredInReport)) {

				int i = 1;
				stmt.setString(i++, PrivateNumberOfReport);
				stmt.setString(i++, PrivateNumberOfInjured);
				stmt.setString(i++, Location);
				stmt.setString(i++, Situation);
				stmt.setString(i++, Rescation);

				stmt.execute();
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
