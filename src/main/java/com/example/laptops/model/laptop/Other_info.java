package com.example.laptops.model.laptop;



public class Other_info {
	
	private int other_info_id;
	private Laptop laptop;
	private String batery_info;
	private String charger_power;
	private String operating_system;
	private String release_date;
	public Other_info() {
		
	}
	public Other_info(int other_info_id, String batery_info, String charger_power, String operating_system,
			String release_date) {
		super();
		this.other_info_id = other_info_id;
		this.batery_info = batery_info;
		this.charger_power = charger_power;
		this.operating_system = operating_system;
		this.release_date = release_date;
	}
	public long getOther_info_id() {
		return other_info_id;
	}
	public void setOther_info_id(int other_info_id) {
		this.other_info_id = other_info_id;
	}
	public String getBatery_info() {
		return batery_info;
	}
	public void setBatery_info(String batery_info) {
		this.batery_info = batery_info;
	}
	public String getCharger_power() {
		return charger_power;
	}
	public void setCharger_power(String charger_power) {
		this.charger_power = charger_power;
	}
	public String getOperating_system() {
		return operating_system;
	}
	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}
