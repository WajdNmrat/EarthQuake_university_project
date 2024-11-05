package entity;

import java.util.ArrayList;
import java.util.Objects;

public class XmlMessage {
	private String privateNumber;
	private String date;
	private String IndicatorPlaceX;
	private String IndicatorPlacey;
	private String power;
	private ArrayList<City> damagedCities;

	public XmlMessage(String privateNumber, String date, String indicatorPlaceX, String indicatorPlacey,
			String power) {
		super();
		this.privateNumber = privateNumber;
		this.date = date;
		this.IndicatorPlaceX = indicatorPlaceX;
		this.IndicatorPlacey = indicatorPlacey;
		this.power = power;
		damagedCities = new ArrayList<City>();
	}

	public String getPrivateNumber() {
		return privateNumber;
	}

	public void setPrivateNumber(String privateNumber) {
		this.privateNumber = privateNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIndicatorPlaceX() {
		return IndicatorPlaceX;
	}

	public void setIndicatorPlaceX(String indicatorPlaceX) {
		IndicatorPlaceX = indicatorPlaceX;
	}

	public String getIndicatorPlacey() {
		return IndicatorPlacey;
	}

	public void setIndicatorPlacey(String indicatorPlacey) {
		IndicatorPlacey = indicatorPlacey;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public ArrayList<City> getDamagedCities() {
		return damagedCities;
	}

	public void setDamagedCities(ArrayList<City> damagedCities) {
		this.damagedCities = damagedCities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IndicatorPlaceX, IndicatorPlacey, damagedCities, date, power, privateNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlMessage other = (XmlMessage) obj;
		return Objects.equals(IndicatorPlaceX, other.IndicatorPlaceX)
				&& Objects.equals(IndicatorPlacey, other.IndicatorPlacey)
				&& Objects.equals(damagedCities, other.damagedCities) && Objects.equals(date, other.date)
				&& Objects.equals(power, other.power) && Objects.equals(privateNumber, other.privateNumber);
	}

	@Override
	public String toString() {
		return "XmlMessage [privateNumber=" + privateNumber + ", date=" + date + ", IndicatorPlaceX=" + IndicatorPlaceX
				+ ", IndicatorPlacey=" + IndicatorPlacey + ", power=" + power + ", damagedCities=" + damagedCities
				+ "]";
	}
}
