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

import javax.swing.JOptionPane;

import entity.City;
import entity.Consts;
import entity.Country;
import entity.Instruction;
import entity.XmlMessage;

public class EarthQuakeLogic {
	// TODO Auto-generated method stub
	private static EarthQuakeLogic _instance;

	private EarthQuakeLogic() {
	}

	public static EarthQuakeLogic getInstance() {
		if (_instance == null)
			_instance = new EarthQuakeLogic();
		return _instance;
	}

	public static ArrayList<XmlMessage> allEarthQuakes = new ArrayList<XmlMessage>();
	public static ArrayList<City> allCities = new ArrayList<City>();

	public boolean addXmlMessage(String privateNumber, String date, String indicatorPlaceX, String indicatorPlacey,
			String power) {
		try {
			
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); // from string to DATE
			
			Date date1=null;
			try {
				date1 = sdf1.parse(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_EarhQuakeMessage)) {

				int i = 1;
				if (privateNumber != null)
					stmt.setString(i++, privateNumber);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (sqlStartDate != null)
					stmt.setDate(i++, sqlStartDate );
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (indicatorPlaceX != null)
					stmt.setString(i++, indicatorPlaceX);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (indicatorPlacey != null)
					stmt.setString(i++, indicatorPlacey);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (power != null)
					stmt.setString(i++, power);
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
	
	

	public boolean addCity(String cityNumber, String CityName, String country, String distanceFromIsrael) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_CITIES)) {

				int i = 1;
				if (cityNumber != null)
					stmt.setString(i++, cityNumber);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (CityName != null)
					stmt.setString(i++, CityName);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (country != null)
					stmt.setString(i++, country);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (distanceFromIsrael != null)
					stmt.setString(i++, distanceFromIsrael);
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
	public boolean addcitytoearth(String earthid, String cityid) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_CitiesOfEarhQuake)) {

				int i = 1;
				if (earthid != null)
					stmt.setString(i++, earthid);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (cityid != null)
					stmt.setString(i++, cityid);
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
	
	public boolean addcontry(String contryid, String contryname) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_Contries)) {

				int i = 1;
				if (contryid != null)
					stmt.setString(i++, contryid);
				else
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				if (contryname != null)
					stmt.setString(i++, contryname);
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
	
	
	public ArrayList<Country> getcountiresCode() {
		
		ArrayList<Country> results = new ArrayList<Country>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_Contries);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Country (rs.getString(i++), rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
public ArrayList<City> getCities() {
		
		ArrayList<City> results = new ArrayList<City>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CITIES);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new City (rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	

	public ArrayList<XmlMessage> getEarthQuake() {
		
		ArrayList<XmlMessage> AllEarthQuakes = new ArrayList<XmlMessage>();
		try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_EarhQuakeMessage);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				AllEarthQuakes.add(new XmlMessage(rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return AllEarthQuakes;
	}
	
	
	
	
	
	
}
