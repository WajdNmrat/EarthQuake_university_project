package entity;

import java.util.Objects;

public class City {
	private String cityNumber;
	private String CityName;
	private String distanceFromIsrael;
	private String country;

	public City(String cityNumber, String cityName, String country, String distanceFromIsrael) {
		super();
		this.cityNumber = cityNumber;
		this.CityName = cityName;
		this.distanceFromIsrael = distanceFromIsrael;
		this.country = country;
	}

	public String getCityNumber() {
		return cityNumber;
	}

	public void setCityNumber(String cityNumber) {
		this.cityNumber = cityNumber;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getDistanceFromIsrael() {
		return distanceFromIsrael;
	}

	public void setDistanceFromIsrael(String distanceFromIsrael) {
		this.distanceFromIsrael = distanceFromIsrael;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CityName, cityNumber, country, distanceFromIsrael);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(CityName, other.CityName) && Objects.equals(cityNumber, other.cityNumber)
				&& Objects.equals(country, other.country)
				&& Objects.equals(distanceFromIsrael, other.distanceFromIsrael);
	}

	@Override
	public String toString() {
		return "City [cityNumber=" + cityNumber + ", CityName=" + CityName + ", distanceFromIsrael="
				+ distanceFromIsrael + ", country=" + country + "]";
	}
}
