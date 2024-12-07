package com.example.laptops.model.laptop;

public class Laptop {
	
	private Integer laptop_id;
	private Integer laptop_price ;
	private String laptop_name;
	private CPU cpu;
	private Ram_storage ram;
	private Screen screen;
	private Graphics_audio graphics_audio;
	private Ports_features ports_features;
	private Dimension_weight dimension_weight;
	private Other_info other_info;
	private String formattedPrice; 
	public Graphics_audio getGraphics_audio() {
		return graphics_audio;
	}
	public void setGraphics_audio(Graphics_audio graphics_audio) {
		this.graphics_audio = graphics_audio;
	}
	public Ports_features getPorts_features() {
		return ports_features;
	}
	public void setPorts_features(Ports_features ports_features) {
		this.ports_features = ports_features;
	}
	public Dimension_weight getDimension_weight() {
		return dimension_weight;
	}
	public void setDimension_weight(Dimension_weight dimension_weight) {
		this.dimension_weight = dimension_weight;
	}
	public Other_info getOther_info() {
		return other_info;
	}
	public void setOther_info(Other_info other_info) {
		this.other_info = other_info;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Ram_storage getRam() {
		return ram;
	}
	public void setRam(Ram_storage ram) {
		this.ram = ram;
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public Integer getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}
	public Integer getLaptop_price() {
		return laptop_price;
	}
	public void setLaptop_price(int laptop_price) {
		this.laptop_price = laptop_price;
	}
	public String getLaptop_name() {
		return laptop_name;
	}
	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}
	
	public Laptop() {
	}
	public Laptop(Integer laptop_id, Integer laptop_price, String laptop_name, CPU cpu) {
		this.laptop_id = laptop_id;
		this.laptop_price = laptop_price;
		this.laptop_name = laptop_name;
		this.cpu = cpu;
	}
	public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }
	
}
