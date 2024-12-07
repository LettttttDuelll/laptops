package com.example.laptops.model.laptop;

public class Graphics_audio {
	
	
	private int graphics_audio_id;
	
	private Laptop laptop;
	private String graphics_card;
	private String audio_technology;
	public int getGraphics_audio_id() {
		return graphics_audio_id;
	}
	public void setGraphics_audio_id(int graphics_audio_id) {
		this.graphics_audio_id = graphics_audio_id;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public String getGraphics_card() {
		return graphics_card;
	}
	public void setGraphics_card(String graphics_card) {
		this.graphics_card = graphics_card;
	}
	public String getAudio_technology() {
		return audio_technology;
	}
	public void setAudio_technology(String audio_technology) {
		this.audio_technology = audio_technology;
	}
	public Graphics_audio() {
		// TODO Auto-generated constructor stub
	}

}
