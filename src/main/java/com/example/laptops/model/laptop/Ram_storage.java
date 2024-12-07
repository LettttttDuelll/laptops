package com.example.laptops.model.laptop;


public class Ram_storage {
	
	private int ram_id;

	private Laptop laptop;
	private String ram_min;
	private String ram_type;
	private String ram_speed;
	private String max_ram;
	private String ram_storage;
	public int getRam_id() {
		return ram_id;
	}
	public void setRam_id(int ram_id) {
		this.ram_id = ram_id;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public String getRam_min() {
		return ram_min;
	}
	public void setRam_min(String ram_min) {
		this.ram_min = ram_min;
	}
	public String getRam_type() {
		return ram_type;
	}
	public void setRam_type(String ram_type) {
		this.ram_type = ram_type;
	}
	public String getRam_speed() {
		return ram_speed;
	}
	public void setRam_speed(String ram_speed) {
		this.ram_speed = ram_speed;
	}
	public String getMax_ram() {
		return max_ram;
	}
	public void setMax_ram(String max_ram) {
		this.max_ram = max_ram;
	}
	public String getRam_storage() {
		return ram_storage;
	}
	public void setRam_storage(String ram_storage) {
		this.ram_storage = ram_storage;
	}
	public Ram_storage() {
		// TODO Auto-generated constructor stub
	}

}
