package entity;

import java.util.Objects;

public class Member {
	protected String PassportID;
	protected String name;
	protected String phoneNumber;
	protected String email;
	protected String age;
	protected String experience;

	public Member(String passportID, String name, String phoneNumber, String email, String age, String experience) {
		super();
		PassportID = passportID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PassportID, age, email, experience, name, phoneNumber);
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
		return Objects.equals(PassportID, other.PassportID) && Objects.equals(age, other.age)
				&& Objects.equals(email, other.email) && Objects.equals(experience, other.experience)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Member [PassportID=" + PassportID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", age=" + age + ", experience=" + experience + "]";
	}
}
