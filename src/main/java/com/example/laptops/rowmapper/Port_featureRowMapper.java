package com.example.laptops.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.Ports_features;

public class Port_featureRowMapper implements RowMapper<Ports_features> {

	@Override
	public Ports_features mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Ports_features portFeatures = new Ports_features();
	     portFeatures.setPort_type(rs.getString("portss"));
	     portFeatures.setWireless_connection(rs.getString("wireless"));
	     portFeatures.setWebcam(rs.getString("webcam"));
	     portFeatures.setExtra_features(rs.getString("extra_features"));
	     portFeatures.setKeyboard_blacklight(rs.getString("keyboard_backlight"));
		return portFeatures;
	}

}
