package com.example.laptops.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.Other_info;

public class Other_infoRowMapper implements RowMapper<Other_info> {

	@Override
	public Other_info mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Other_info other_info = new Other_info();
	     other_info.setBatery_info(rs.getString("battery"));
	     other_info.setCharger_power(rs.getString("charger_power"));
	     other_info.setOperating_system(rs.getString("Operating_system"));
	     other_info.setRelease_date(rs.getString("release_year"));
		 return other_info;
	}

}
