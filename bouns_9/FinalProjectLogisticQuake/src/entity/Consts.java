package entity;

import java.net.URLDecoder;

public class Consts {
	private Consts() {
		throw new AssertionError();
	}

	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";

	/*----------------------------------------- EMPLOYEES QUERIES -----------------------------------------*/
	public static final String SQL_SEL_EMPLOYEES = "SELECT * FROM Employee";
	public static final String SQL_INS_EMPLOYEE = "{ call qryInsEmployee(?,?,?,?,?,?,?,?,?,?) }";
	/*----------------------------------------- Team QUERIES ------------------------------------*/

	public static final String SQL_SEL_TEAM = "SELECT * FROM Team";
	public static final String SQL_INS_TEAM = "{ call qryInsTeam(?,?,?,?,?) }";

	/*----------------------------------------- VolunteerToTeam QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_VOLUNTEERSTOTEAM = "SELECT * FROM VolunteersInTeam";
	public static final String SQL_INS_VOLUNTEERSTOTEAM = "{ call qryInsVolunteerToTeam(?,?) }";
	public static final String SQL_UPD_STATUS ="{ call qryUpdateVolunter(?,?) }";
	

	/*----------------------------------------- EarthQuakes QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_EarhQuakeMessage = "SELECT * FROM EarhQuakeMessage";
	public static final String SQL_INS_EarhQuakeMessage = "{ call qryInsXmlMessage(?,?,?,?,?)}";

	/*----------------------------------------- Cities QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_CITIES = "SELECT * FROM City";
	public static final String SQL_INS_CITIES = "{ call qryInsCity(?,?,?,?)}";
	
	/*----------------------------------------- INSTURCTIONS QUERIES -----------------------------------------*/
	public static final String SQL_SEL_INSTURCTIONS = "SELECT * FROM Instruction";
	public static final String SQL_INS_INSTURCTIONS = "{ call qryInsInstruction(?,?,?,?,?,?) }";
	
	/*----------------------------------------- Volunteer QUERIES --------------------------------------------*/
	public static final String SQL_SEL_VOLUNTEER = "SELECT * FROM Volunter";
	public static final String SQL_INS_VOLUNTEER = "{ call qryInsVolunter(?,?,?,?,?,?,?) }";
	
	public static final String SQL_INS_VOLUNTEERtoInstructions = "{ call qryInsVolunteersinInstructions(?,?,?) }";
	//public static final String SQL_UPDATE_grade = "Update VolunteersinInstructions Set grade=? WHERE ((passportID=?) AND (InstructionCode=?));";
	public static final String SQL_UPD_GRADE ="{ call qryUpdateVolunteersinInstructions(?,?,?) }";
	
	/*----------------------------------------- city to team QUERIES --------------------------------------------*/
	public static final String SQL_SEL_CitiesOfEarhQuake = "SELECT * FROM CitiesOfEarhQuake";
	public static final String SQL_INS_CitiesOfEarhQuake = "{ call qryInsCities(?,?) }";
	/*-----------------------------------------  Country QUERIES --------------------------------------------*/
	public static final String SQL_SEL_Contries = "SELECT * FROM Contries";
	public static final String SQL_INS_Contries = "{ call qryInsContries(?,?) }";
	/**
	 * find the correct path of the DB file
	 * 
	 * @return the path of the DB file (from eclipse or with runnable file)
	 */
	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			// System.out.println(decoded) - Can help to check the returned path
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				return decoded + "/database/HW1.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				System.out.println(decoded);
				return decoded + "src/entity/HW1.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
