package com.example.laptops.model.laptop;

public class Screen {
	private int screen_id;
	private Laptop laptop;
	private String screen_size;
	private String resolution;
	private String refresh_rate;
	private String color_coverage;
	private String screen_technology;
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public String getScreen_size() {
		return screen_size;
	}
	public void setScreen_size(String screen_size) {
		this.screen_size = screen_size;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getRefresh_rate() {
		return refresh_rate;
	}
	public void setRefresh_rate(String refresh_rate) {
		this.refresh_rate = refresh_rate;
	}
	public String getColor_coverage() {
		return color_coverage;
	}
	public void setColor_coverage(String color_coverage) {
		this.color_coverage = color_coverage;
	}
	public String getScreen_technology() {
		return screen_technology;
	}
	public void setScreen_technology(String screen_technology) {
		this.screen_technology = screen_technology;
	}
}
