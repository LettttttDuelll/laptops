package com.example.laptops.model.laptop;

public class Dimension_weight {
	
	private long dimension_weight_id;
	private Laptop laptop;
	private String dimension ;
	private String weight ;
	private String material;
	public long getDimension_weight_id() {
		return dimension_weight_id;
	}
	public void setDimension_weight_id(long dimension_weight_id) {
		this.dimension_weight_id = dimension_weight_id;
	}
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Dimension_weight() {
		
	}
	public Dimension_weight(String dimension, String weight, String material) {
		this.setDimension(dimension);
		this.weight = weight;
		this.material = material;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

}
