package entity;

import java.util.Objects;

public class Team {
	private String TeamID;
	private String name;
	private String role;
	private String PassportIdOfEmployee;
	private String PrivateNumberOfEarthquake;

	public Team(String teamID, String name, String role, String passportIdOfEmployee,
			String privateNumberOfEarthquake) {
		super();
		this.TeamID = teamID;
		this.name = name;
		this.role = role;
		this.PassportIdOfEmployee = passportIdOfEmployee;
		this.PrivateNumberOfEarthquake = privateNumberOfEarthquake;
	}

	public String getTeamID() {
		return TeamID;
	}

	public void setTeamID(String teamID) {
		TeamID = teamID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassportIdOfEmployee() {
		return PassportIdOfEmployee;
	}

	public void setPassportIdOfEmployee(String passportIdOfEmployee) {
		PassportIdOfEmployee = passportIdOfEmployee;
	}

	public String getPrivateNumberOfEarthquake() {
		return PrivateNumberOfEarthquake;
	}

	public void setPrivateNumberOfEarthquake(String privateNumberOfEarthquake) {
		PrivateNumberOfEarthquake = privateNumberOfEarthquake;
	}

	@Override
	public String toString() {
		return "Team [TeamID=" + TeamID + ", name=" + name + ", role=" + role + ", PassportIdOfEmployee="
				+ PassportIdOfEmployee + ", PrivateNumberOfEarthquake=" + PrivateNumberOfEarthquake + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(PassportIdOfEmployee, PrivateNumberOfEarthquake, TeamID, name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(PassportIdOfEmployee, other.PassportIdOfEmployee)
				&& Objects.equals(PrivateNumberOfEarthquake, other.PrivateNumberOfEarthquake)
				&& Objects.equals(TeamID, other.TeamID) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role);
	}

}
