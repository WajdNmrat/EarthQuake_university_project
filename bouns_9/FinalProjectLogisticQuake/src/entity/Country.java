package entity;

public class Country {
	String Country3letters;
	String name;
	

	public Country(String country3letters, String name) {
		super();
		Country3letters = country3letters;
		this.name = name;
	}
	
	
	public String getCountry3letters() {
		return Country3letters;
	}
	public void setCountry3letters(String country3letters) {
		Country3letters = country3letters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
