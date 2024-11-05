package entity;

import java.sql.Date;
import java.util.Objects;

import util.Role;

public class Instruction {
	private String topic;
	private String id;
	private String type;
	private String date;
	private String maxNumOfParticipant;
	private String employee;

	public Instruction(String id,String topic, String type, String date, String maxNumOfParticipant, String employee) {
		super();
		this.topic = topic;
		this.type = type;
		this.id = id;
		this.date = date;
		this.maxNumOfParticipant = maxNumOfParticipant;
		this.employee = employee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMaxNumOfParticipant() {
		return maxNumOfParticipant;
	}

	public void setMaxNumOfParticipant(String maxNumOfParticipant) {
		this.maxNumOfParticipant = maxNumOfParticipant;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, employee, maxNumOfParticipant, topic, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instruction other = (Instruction) obj;
		return Objects.equals(date, other.date) && Objects.equals(employee, other.employee)
				&& Objects.equals(maxNumOfParticipant, other.maxNumOfParticipant) && Objects.equals(topic, other.topic)
				&& type == other.type;
	}

	@Override
	public String toString() {
		return "Instruction [topic=" + topic + ", type=" + type + ", date=" + date + ", maxNumOfParticipant="
				+ maxNumOfParticipant + ", employee=" + employee + "]";
	}
}
