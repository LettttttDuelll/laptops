package com.example.laptops.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.CPU;
import com.example.laptops.model.laptop.Laptop;

public class LaptopRowMapper implements RowMapper<Laptop> {
    @Override
    public Laptop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Laptop laptop = new Laptop();
        laptop.setLaptop_id(rs.getInt("laptop_id"));
        laptop.setLaptop_name(rs.getString("laptop_name"));
        laptop.setLaptop_price(rs.getInt("laptop_price"));
        CPU cpu = new CPU();
        cpu.setCpu_id(rs.getInt("cpu_id"));
        cpu.setCpu_technology(rs.getString("cpu_technology"));
        cpu.setNum_cores(rs.getInt("cpu_cores"));
        cpu.setNum_threads(rs.getInt("cpu_threads"));
        cpu.setCpu_speed(rs.getString("cpu_base_clock"));
        cpu.setCpu_maxspeed(rs.getString("cpu_max_clock"));
        cpu.setCache_size(rs.getString("cpu_cache"));
        laptop.setCpu(cpu);
        return laptop;
    }
}
