package com.example.laptops.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.CPU;

public class CPURowMapper implements RowMapper<CPU> {

	@Override
	public CPU mapRow(ResultSet rs, int rowNum) throws SQLException {
		CPU cpu = new CPU();
        cpu.setCpu_id(rs.getInt("cpu_id"));
        cpu.setCpu_technology(rs.getString("cpu_technology"));
        cpu.setNum_cores(rs.getInt("cpu_cores"));
        cpu.setNum_threads(rs.getInt("cpu_threads"));
        cpu.setCpu_speed(rs.getString("cpu_base_clock"));
        cpu.setCpu_maxspeed(rs.getString("cpu_max_clock"));
        cpu.setCache_size(rs.getString("cpu_cache"));
		return cpu;
	}

}
