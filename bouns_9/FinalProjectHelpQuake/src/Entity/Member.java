package Entity;

import java.util.Objects;

public class Member {

	protected String PassportID;
	protected String name;
	protected String phoneNumber;
	protected String email;
	protected String dateOfBirthday;
	protected String joinningDate;
	protected Double experience;

	public Member(String passportID, String name, String phoneNumber, String email, String dateOfBirthday,
			String joinningDate, Double experience) {
		super();
		PassportID = passportID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirthday = dateOfBirthday;
		this.joinningDate = joinningDate;
		this.experience = experience;
	}

	public String getPassportID() {
		return PassportID;
	}

	public void setPassportID(String passportID) {
		PassportID = passportID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(String dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public String getJoinningDate() {
		return joinningDate;
	}

	public void setJoinningDate(String joinningDate) {
		this.joinningDate = joinningDate;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Member [PassportID=" + PassportID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", dateOfBirthday=" + dateOfBirthday + ", joinningDate=" + joinningDate + ", experience="
				+ experience + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(PassportID, dateOfBirthday, email, experience, joinningDate, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(PassportID, other.PassportID) && Objects.equals(dateOfBirthday, other.dateOfBirthday)
				&& Objects.equals(email, other.email) && Objects.equals(experience, other.experience)
				&& Objects.equals(joinningDate, other.joinningDate) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

}
