package Entity;

import java.util.Objects;

public class Injured {
	private String privateNumber;
	private String Name;
	private String ID;

	public Injured(String privateNumber, String name, String iD) {
		super();
		this.privateNumber = privateNumber;
		Name = name;
		ID = iD;
	}

	public String getPrivateNumber() {
		return privateNumber;
	}

	public void setPrivateNumber(String privateNumber) {
		this.privateNumber = privateNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Injured [privateNumber=" + privateNumber + ", Name=" + Name + ", ID=" + ID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, Name, privateNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Injured other = (Injured) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(Name, other.Name)
				&& Objects.equals(privateNumber, other.privateNumber);
	}
}
