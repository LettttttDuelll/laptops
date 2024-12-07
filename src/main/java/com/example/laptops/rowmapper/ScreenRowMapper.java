package com.example.laptops.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.Screen;

public class ScreenRowMapper implements RowMapper<Screen> {

	@Override
	public Screen mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Screen screen = new Screen();
	     screen.setScreen_size(rs.getString("screen_size"));
	     screen.setResolution(rs.getString("resolution"));
	     screen.setRefresh_rate(rs.getString("refresh_rate"));
	     screen.setColor_coverage(rs.getString("color_coverage"));
	     screen.setScreen_technology(rs.getString("screen_technology"));
	        
		return screen;
	}

}
