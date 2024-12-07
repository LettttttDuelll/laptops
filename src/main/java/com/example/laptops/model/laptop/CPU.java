package com.example.laptops.model.laptop;




public class CPU {

	private int cpu_id;
	private Laptop laptop;
	private String cpu_technology;
	private int num_cores;
	private int num_threads;
	private String cpu_speed;
	private String cpu_maxspeed;
	private String cache_size;
	public CPU() {
	}
	public int getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}
	public String getCpu_technology() {
		return cpu_technology;
	}
	public void setCpu_technology(String cpu_technology) {
		this.cpu_technology = cpu_technology;
	}
	public int getNum_cores() {
		return num_cores;
	}
	public void setNum_cores(int num_cores) {
		this.num_cores = num_cores;
	}
	public int getNum_threads() {
		return num_threads;
	}
	public void setNum_threads(int num_threads) {
		this.num_threads = num_threads;
	}
	public String getCpu_maxspeed() {
		return cpu_maxspeed;
	}
	public void setCpu_maxspeed(String cpu_maxspeed) {
		this.cpu_maxspeed = cpu_maxspeed;
	}
	public String getCpu_speed() {
		return cpu_speed;
	}
	public void setCpu_speed(String cpu_speed) {
		this.cpu_speed = cpu_speed;
	}
	public String getCache_size() {
		return cache_size;
	}
	public void setCache_size(String cache_size) {
		this.cache_size = cache_size;
	}
	public CPU(int cpu_id, String cpu_technology, int num_cores, int num_threads, String cpu_speed, String cache_size) {
		this.cpu_id = cpu_id;
		this.cpu_technology = cpu_technology;
		this.num_cores = num_cores;
		this.num_threads = num_threads;
		this.cpu_speed = cpu_speed;
		this.cache_size = cache_size;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}
