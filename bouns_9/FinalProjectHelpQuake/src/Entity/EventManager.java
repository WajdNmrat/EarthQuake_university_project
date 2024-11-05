package Entity;

import java.util.Objects;

public class EventManager extends Member {
	private Double salary;

	public EventManager(String passportID, String name, String phoneNumber, String email, String dateOfBirthday,
			String joinningDate, Double experience, Double salary) {
		super(passportID, name, phoneNumber, email, dateOfBirthday, joinningDate, experience);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EventManager [salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary);
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
		EventManager other = (EventManager) obj;
		return Objects.equals(salary, other.salary);
	}
}
