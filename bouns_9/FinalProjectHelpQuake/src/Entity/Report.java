package Entity;

import java.util.Objects;

public class Report {
	private String privateNUmber;
	private String dateExitOfTheInjured;
	private String privateNumberOfExtractor;
	private String Hour;
	private String Minute;

	public Report(String privateNUmber, String dateExitOfTheInjured, String privateNumberOfExtractor, String hour,
			String minute) {
		super();
		this.privateNUmber = privateNUmber;
		this.dateExitOfTheInjured = dateExitOfTheInjured;
		this.privateNumberOfExtractor = privateNumberOfExtractor;
		Hour = hour;
		Minute = minute;
	}

	public String getPrivateNUmber() {
		return privateNUmber;
	}

	public void setPrivateNUmber(String privateNUmber) {
		this.privateNUmber = privateNUmber;
	}

	public String getDateExitOfTheInjured() {
		return dateExitOfTheInjured;
	}

	public void setDateExitOfTheInjured(String dateExitOfTheInjured) {
		this.dateExitOfTheInjured = dateExitOfTheInjured;
	}

	public String getPrivateNumberOfExtractor() {
		return privateNumberOfExtractor;
	}

	public void setPrivateNumberOfExtractor(String privateNumberOfExtractor) {
		this.privateNumberOfExtractor = privateNumberOfExtractor;
	}

	public String getHour() {
		return Hour;
	}

	public void setHour(String hour) {
		Hour = hour;
	}

	public String getMinute() {
		return Minute;
	}

	public void setMinute(String minute) {
		Minute = minute;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Hour, Minute, dateExitOfTheInjured, privateNUmber, privateNumberOfExtractor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		return Objects.equals(Hour, other.Hour) && Objects.equals(Minute, other.Minute)
				&& Objects.equals(dateExitOfTheInjured, other.dateExitOfTheInjured)
				&& Objects.equals(privateNUmber, other.privateNUmber)
				&& Objects.equals(privateNumberOfExtractor, other.privateNumberOfExtractor);
	}

	public Integer calculate() {
		Integer hour = Integer.parseInt(getHour()) * 60;
		Integer minute = Integer.parseInt(getMinute());
		Integer value = hour + minute;
		return value;
	}

	@Override
	public String toString() {
		return "Report [privateNUmber=" + privateNUmber + ", dateExitOfTheInjured=" + dateExitOfTheInjured
				+ ", privateNumberOfExtractor=" + privateNumberOfExtractor + ", Hour=" + Hour + ", Minute=" + Minute
				+ "]";
	}

}
