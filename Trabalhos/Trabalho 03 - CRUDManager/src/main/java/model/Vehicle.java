package model;

public class Vehicle {
	
	private int id;
	private String type;
	private String brand;
	private String model;
	private int yearOfManufacture;
	private String plate;
	private Company company;
	
	public Vehicle() {
		this(0);
	}
	
	public Vehicle(int id) {
		this.id = id;
		setType("");
		setBrand("");
		setYearOfManufacture(0);
		setPlate("");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
}
