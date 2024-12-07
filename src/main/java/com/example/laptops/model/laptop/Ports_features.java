package com.example.laptops.model.laptop;

public class Ports_features {
	
	private int ports_features_id ;
	private Laptop laptop;
	
	private String port_type;
	private String wireless_connection ;
	private String webcam ;
	private String extra_features;
	private String keyboard_blacklight;
	
	public int getPorts_features_id() {
		return ports_features_id;
	}

	public void setPorts_features_id(int ports_features_id) {
		this.ports_features_id = ports_features_id;
	}

	public String getPort_type() {
		return port_type;
	}

	public void setPort_type(String port_type) {
		this.port_type = port_type;
	}

	public String getWireless_connection() {
		return wireless_connection;
	}

	public void setWireless_connection(String wireless_connection) {
		this.wireless_connection = wireless_connection;
	}

	public String getWebcam() {
		return webcam;
	}

	public void setWebcam(String webcam) {
		this.webcam = webcam;
	}

	public String getExtra_features() {
		return extra_features;
	}

	public void setExtra_features(String extra_features) {
		this.extra_features = extra_features;
	}

	public String getKeyboard_blacklight() {
		return keyboard_blacklight;
	}

	public void setKeyboard_blacklight(String keyboard_blacklight) {
		this.keyboard_blacklight = keyboard_blacklight;
	}

	public Ports_features() {
		
	}
	public Ports_features(int ports_features_id, String port_type, String wireless_connection, String webcam,
			String extra_features, String keyboard_blacklight) {
		this.ports_features_id = ports_features_id;
		this.port_type = port_type;
		this.wireless_connection = wireless_connection;
		this.webcam = webcam;
		this.extra_features = extra_features;

		this.keyboard_blacklight = keyboard_blacklight;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}
