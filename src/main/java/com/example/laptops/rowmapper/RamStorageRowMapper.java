package com.example.laptops.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.Ram_storage;

public class RamStorageRowMapper implements RowMapper<Ram_storage> {

	@Override
	public Ram_storage mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ram_storage ram = new Ram_storage();
        ram.setRam_min(rs.getString("ram"));
        ram.setRam_type(rs.getString("ram_type"));
        ram.setRam_speed(rs.getString("ram_speed"));
        ram.setMax_ram(rs.getString("max_ram"));
        ram.setRam_storage(rs.getString("storage"));
		return ram;
	}

}
