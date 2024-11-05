package Entity;

import java.util.Objects;

public class InjuredInReport {
	private String privateNumberOfReport;
	private String privateNumberOfInjured;
	private String location;
	private String situation;
	private String rescation;

	public InjuredInReport(String privateNumberOfReport, String privateNumberOfInjured, String location,
			String situation, String rescation) {
		super();
		this.privateNumberOfReport = privateNumberOfReport;
		this.privateNumberOfInjured = privateNumberOfInjured;
		this.location = location;
		this.situation = situation;
		this.rescation = rescation;
	}

	public String getPrivateNumberOfReport() {
		return privateNumberOfReport;
	}

	public void setPrivateNumberOfReport(String privateNumberOfReport) {
		this.privateNumberOfReport = privateNumberOfReport;
	}

	public String getPrivateNumberOfInjured() {
		return privateNumberOfInjured;
	}

	public void setPrivateNumberOfInjured(String privateNumberOfInjured) {
		this.privateNumberOfInjured = privateNumberOfInjured;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getRescation() {
		return rescation;
	}

	public void setRescation(String rescation) {
		this.rescation = rescation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, privateNumberOfInjured, privateNumberOfReport, rescation, situation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InjuredInReport other = (InjuredInReport) obj;
		return Objects.equals(location, other.location)
				&& Objects.equals(privateNumberOfInjured, other.privateNumberOfInjured)
				&& Objects.equals(privateNumberOfReport, other.privateNumberOfReport)
				&& Objects.equals(rescation, other.rescation) && Objects.equals(situation, other.situation);
	}

	@Override
	public String toString() {
		return "InjuredInReport [privateNumberOfReport=" + privateNumberOfReport + ", privateNumberOfInjured="
				+ privateNumberOfInjured + ", location=" + location + ", situation=" + situation + ", rescation="
				+ rescation + "]";
	}

}
