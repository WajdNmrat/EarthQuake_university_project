package entity;

import java.util.Objects;

public class Volunteer extends Member {
	private String accept;

	public Volunteer(String passportID, String name, String phoneNumber, String email, String age, String experience,
			String accept) {
		super(passportID, name, phoneNumber, email, age, experience);
		this.accept = accept;
	}
	

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(accept);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volunteer other = (Volunteer) obj;
		return Objects.equals(accept, other.accept);
	}

	@Override
	public String toString() {
		return super.toString()+ "Volunteer [accept=" + accept + "]";
	}

}
