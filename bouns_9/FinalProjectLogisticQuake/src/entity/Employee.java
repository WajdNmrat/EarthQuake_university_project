package entity;

import java.util.Objects;

public class Employee extends Member {
	private String role;
	private String salary;
	private String birthday;
	private String joinning;
	private String retrimentAge;

	public Employee(String passportID, String name, String phoneNumber, String email, String age, String experience,
			String role, String salary, String birthday, String joinning) {
		super(passportID, name, phoneNumber, email, age, experience);
		this.role = role;
		this.salary = salary;
		this.birthday = birthday;
		this.joinning = joinning;

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getJoinning() {
		return joinning;
	}

	public void setJoinning(String joinning) {
		this.joinning = joinning;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(birthday, joinning, retrimentAge, role, salary);
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
		Employee other = (Employee) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(joinning, other.joinning)
				&& Objects.equals(retrimentAge, other.retrimentAge) && Objects.equals(role, other.role)
				&& Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return super.toString() + "Employee [role=" + role + ", salary=" + salary + ", birthday=" + birthday
				+ ", joinning=" + joinning + "]";
	}

}
