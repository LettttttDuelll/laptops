package com.example.laptops.rowmapper;

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
        
        /*CPU cpu = new CPU();
        cpu.setCpu_id(rs.getInt("cpu_id"));
        cpu.setCpu_technology(rs.getString("cpu_technology"));
        cpu.setNum_cores(rs.getInt("cpu_cores"));
        cpu.setNum_threads(rs.getInt("cpu_threads"));
        cpu.setCpu_speed(rs.getString("cpu_base_clock"));
        cpu.setCpu_maxspeed(rs.getString("cpu_max_clock"));
        cpu.setCache_size(rs.getString("cpu_cache"));
        laptop.setCpu(cpu);
        /*
        Ram_storage ram = new Ram_storage();
        ram.setRam_min(rs.getString("ram"));
        ram.setRam_type(rs.getString("ram_type"));
        ram.setRam_speed(rs.getString("ram_speed"));
        ram.setMax_ram(rs.getString("max_ram"));
        ram.setRam_storage(rs.getString("storage"));
        laptop.setRam(ram);
        
        Screen screen = new Screen();
        screen.setScreen_size(rs.getString("screen_size"));
        screen.setResolution(rs.getString("resolution"));
        screen.setRefresh_rate(rs.getString("refresh_rate"));
        screen.setColor_coverage(rs.getString("color_coverage"));
        screen.setScreen_technology(rs.getString("screen_technology"));
        laptop.setScreen(screen);
        
        Graphics_audio graphics_audio = new Graphics_audio();
        graphics_audio.setGraphics_card(rs.getString("graphics_card"));
        graphics_audio.setAudio_technology(rs.getString("audio_technology"));
        laptop.setGraphics_audio(graphics_audio);
        
        Ports_features portFeatures = new Ports_features();
        portFeatures.setPort_type(rs.getString("ports"));
        portFeatures.setWireless_connection(rs.getString("wireless"));
        portFeatures.setWebcam(rs.getString("webcam"));
        portFeatures.setExtra_features(rs.getString("extra_features"));
        portFeatures.setKeyboard_blacklight(rs.getString("keyboard_blacklight"));
        laptop.setPorts_features(portFeatures);
        
        Dimension_weight dimension = new Dimension_weight();
        dimension.setSize(rs.getString("dimensions"));
        dimension.setWeight(rs.getString("weight"));
        dimension.setMaterial(rs.getString("material"));
        laptop.setDimension_weight(dimension);
        
        Other_info other_info = new Other_info();
        other_info.setBatery_info(rs.getString("battery"));
        other_info.setCharger_power(rs.getString("charger_power"));
        other_info.setOperating_system(rs.getString("Operating_system"));
        other_info.setRelease_date(rs.getString("release_year"));
        laptop.setOther_info(other_info);*/
        return laptop;
    }
}
