package Entity;

import java.net.URLDecoder;

public class Consts {
	private Consts() {
		throw new AssertionError();
	}

	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";

	/*----------------------------------------- MemberOrganization QUERIES -----------------------------------------*/
	public static final String SQL_SEL_MEMBERORGANIZATION = "SELECT * FROM MemberOrganization";
	public static final String SQL_INS_MEMBERORGANIZATION = "{ call qryInsMemberOrganization(?,?,?,?,?,?,?) }";

	/*----------------------------------------- Team QUERIES --------------------------------------------*/
	public static final String SQL_SEL_TEAM = "SELECT * FROM Team";

	/*----------------------------------------- Reporting QUERIES ------------------------------------*/

	public static final String SQL_SEL_REPORTING = "SELECT * FROM Reporting";
	public static final String SQL_INS_REPORTING = "{ call qryInsReport(?,?,?,?,?) }";

	/*----------------------------------------- Injured QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_INJURED = "SELECT * FROM injured";
	public static final String SQL_INS_INJURED = "{ call qryInsInjured(?,?,?) }";

	/*----------------------------------------- Injured QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_InjuredInReport = "SELECT * FROM InjuredInReports";
	public static final String SQL_INS_InjuredInReport = "{ call qryInsInjuredInReports(?,?,?,?,?) }";

	/*----------------------------------------- EarthQuakes QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_EARTHQUAKE = "SELECT * FROM EarthQuake";
	public static final String SQL_INS_EARTHQUAKE = "{call qryInsEarthQuake(?,?,?,?,?)}";

	/*----------------------------------------- MedicalCare QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_MedicalCare = "SELECT * FROM MedicalCare";
	public static final String SQL_INS_MedicalCare = "{call qryInsMedicalCare(?,?,?,?,?,?,?)}";

	/*----------------------------------------- MentalTherapy QUERIES ----------------------------------------------*/
	public static final String SQL_SEL_MENTALTHERAPY = "SELECT * FROM MentalTherapy";
	public static final String SQL_INS_MENTALTHERAPY = "{call qryInsMentalTherapy(?,?,?,?,?,?,?)}";

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
				return decoded + "/database/HomeWork3.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				System.out.println(decoded);
				return decoded + "src/entity/HomeWork3.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
