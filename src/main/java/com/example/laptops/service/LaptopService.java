package com.example.laptops.service;

import java.util.List;
import java.sql.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.laptops.LaptopDAO;
import com.example.laptops.model.laptop.CPU;
import com.example.laptops.model.laptop.Dimension_weight;
import com.example.laptops.model.laptop.Graphics_audio;
import com.example.laptops.model.laptop.Laptop;
import com.example.laptops.model.laptop.Laptop_Money;
import com.example.laptops.model.laptop.Other_info;
import com.example.laptops.model.laptop.Ports_features;
import com.example.laptops.model.laptop.Ram_storage;
import com.example.laptops.model.laptop.Screen;
//import com.example.laptops.repository.LaptopRepository;
import com.example.laptops.rowmapper.CPURowMapper;
import com.example.laptops.rowmapper.DimensionRowMapper;
import com.example.laptops.rowmapper.Graphics_audioRowMapper;
import com.example.laptops.rowmapper.LaptopRowMapper;
import com.example.laptops.rowmapper.Laptop_MoneyRowMapper;
import com.example.laptops.rowmapper.Other_infoRowMapper;
import com.example.laptops.rowmapper.Port_featureRowMapper;
import com.example.laptops.rowmapper.RamStorageRowMapper;
import com.example.laptops.rowmapper.ScreenRowMapper;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
@Service
public class LaptopService {

	@Autowired
    //phân trang maybe
    

    //public Page<Laptop> getProductsSortedByName() {
        //return LaptopRepository.findAll(Sort.by("laptop_name"));
        //return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
   // }

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	/*public int addLaptop(Laptop laptop) {
        String sql = "INSERT INTO Laptops (laptop_id,product_name, price) VALUES (:laptop_id, :laptop_name, :laptop_price)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", laptop.getLaptop_id());
        params.addValue("name", laptop.getLaptop_name());
        params.addValue("price", laptop.getLaptop_price());

        return namedParameterJdbcTemplate.update(sql, params);
    }*/
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public void addLaptopAndDetails(Laptop laptop, CPU cpuDetails, Ram_storage ramStorage, 
                                     Screen screenDetails, Graphics_audio graphicsAudio, 
                                     Ports_features portsFeatures, Dimension_weight dimensionsWeight, 
                                     Other_info otherInfo) {
        // Thêm laptop vào bảng Laptops và lấy laptop_id
        String sqlLaptop = "INSERT INTO Laptops (laptop_name, laptop_price) VALUES (?, ?)";
        jdbcTemplate.update(sqlLaptop, laptop.getLaptop_name(), laptop.getLaptop_price());

        // Lấy laptop_id vừa được tạo
        String sqlGetLaptopId = "SELECT SCOPE_IDENTITY()";
        //int laptopId = jdbcTemplate.queryForObject(sqlGetLaptopId, Integer.class);
        Long laptopId = jdbcTemplate.queryForObject(sqlGetLaptopId, Long.class);

        // Thêm chi tiết CPU vào bảng CPU_Details
        String sqlCpuDetails = "INSERT INTO CPU_Details (laptop_id, cpu_technology, cpu_cores, cpu_threads, cpu_base_clock, cpu_max_clock, cpu_cache) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlCpuDetails, laptopId, cpuDetails.getCpu_technology(), cpuDetails.getNum_cores(), 
                            cpuDetails.getNum_threads(), cpuDetails.getCpu_speed(), cpuDetails.getCpu_maxspeed(), 
                            cpuDetails.getCache_size());

        // Thêm RAM và Storage vào bảng RAM_Storage
        String sqlRamStorage = "INSERT INTO RAM_Storage (laptop_id, ram, ram_type, ram_speed, max_ram, storage) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlRamStorage, laptopId, ramStorage.getRam_min(), ramStorage.getRam_type(), 
                            ramStorage.getRam_speed(), ramStorage.getMax_ram(), ramStorage.getRam_storage());

        // Thêm chi tiết màn hình vào bảng Screen_Details
        String sqlScreenDetails = "INSERT INTO Screen_Details (laptop_id, screen_size, resolution, refresh_rate, color_coverage, screen_technology) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlScreenDetails, laptopId, screenDetails.getScreen_size(), screenDetails.getResolution(), 
                            screenDetails.getRefresh_rate(), screenDetails.getColor_coverage(), screenDetails.getScreen_technology());

        // Thêm Graphics và Audio vào bảng Graphics_Audio
        String sqlGraphicsAudio = "INSERT INTO Graphics_Audio (laptop_id, graphics_card, audio_technology) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlGraphicsAudio, laptopId, graphicsAudio.getGraphics_card(), graphicsAudio.getAudio_technology());

        // Thêm Ports và Features vào bảng Ports_Features
        String sqlPortsFeatures = "INSERT INTO Ports_Features (laptop_id, portss, wireless, webcam, extra_features, keyboard_backlight) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlPortsFeatures, laptopId, portsFeatures.getPort_type(), portsFeatures.getWireless_connection(), 
                            portsFeatures.getWebcam(), portsFeatures.getExtra_features(), portsFeatures.getKeyboard_blacklight());

        // Thêm Dimensions và Weight vào bảng Dimensions_Weight
        String sqlDimensionsWeight = "INSERT INTO Dimensions_Weight (laptop_id, dimensions, weightt, material) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlDimensionsWeight, laptopId, dimensionsWeight.getDimension(), dimensionsWeight.getWeight(), 
                            dimensionsWeight.getMaterial());

        // Thêm thông tin khác vào bảng Other_Info
        String sqlOtherInfo = "INSERT INTO Other_Info (laptop_id, battery, charger_power, operating_system, release_year) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlOtherInfo, laptopId, otherInfo.getBatery_info(), otherInfo.getCharger_power(), 
                            otherInfo.getOperating_system(), otherInfo.getRelease_date());
    }
    // Thêm laptop
    /*public int addLaptop(Laptop laptop) {
        String sql = "INSERT INTO Laptops (laptop_name, laptop_price) VALUES (?, ?)";
        return jdbcTemplate.update(sql, laptop.getLaptop_name(), laptop.getLaptop_price());
    }

    // Thêm CPU Details
    public int addCpuDetails(CPU cpuDetails) {
        String sql = "INSERT INTO CPU_Details (laptop_id, cpu_technology, cpu_cores, cpu_threads, cpu_base_clock, cpu_max_clock, cpu_cache) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, cpuDetails.getLaptop().getLaptop_id(), cpuDetails.getCpu_technology(), cpuDetails.getNum_cores(), cpuDetails.getNum_threads(), cpuDetails.getCpu_maxspeed(), cpuDetails.getCpu_maxspeed(), cpuDetails.getCache_size());
    }

    // Thêm RAM và Storage
    public int addRamStorage(Ram_storage ramStorage) {
        String sql = "INSERT INTO RAM_Storage (laptop_id, ram, ram_type, ram_speed, max_ram, storage) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, ramStorage.getLaptop().getLaptop_id(), ramStorage.getRam_min(), ramStorage.getRam_type(), ramStorage.getRam_speed(), ramStorage.getMax_ram(), ramStorage.getRam_storage());
    }

    // Thêm Screen Details
    public int addScreenDetails(Screen screenDetails) {
        String sql = "INSERT INTO Screen_Details (laptop_id, screen_size, resolution, refresh_rate, color_coverage, screen_technology) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, screenDetails.getLaptop().getLaptop_id(), screenDetails.getScreen_size(), screenDetails.getResolution(), screenDetails.getRefresh_rate(), screenDetails.getColor_coverage(), screenDetails.getScreen_technology());
    }

    // Thêm Graphics and Audio
    public int addGraphicsAudio(Graphics_audio graphicsAudio) {
        String sql = "INSERT INTO Graphics_Audio (laptop_id, graphics_card, audio_technology) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, graphicsAudio.getLaptop().getLaptop_id(), graphicsAudio.getGraphics_card(), graphicsAudio.getAudio_technology());
    }

    // Thêm Ports and Features
    public int addPortsFeatures(Ports_features portsFeatures) {
        String sql = "INSERT INTO Ports_Features (laptop_id, portss, wireless, webcam, extra_features, keyboard_backlight) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, portsFeatures.getLaptop().getLaptop_id(), portsFeatures.getPort_type(), portsFeatures.getWireless_connection(), portsFeatures.getWebcam(), portsFeatures.getExtra_features(), portsFeatures.getKeyboard_blacklight());
    }

    // Thêm Dimensions and Weight
    public int addDimensionsWeight(Dimension_weight dimensionsWeight) {
        String sql = "INSERT INTO Dimensions_Weight (laptop_id, dimensions, weightt, material) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, dimensionsWeight.getLaptop().getLaptop_id(), dimensionsWeight.getDimension(), dimensionsWeight.getWeight(), dimensionsWeight.getMaterial());
    }

    // Thêm Other Info
    public int addOtherInfo(Other_info otherInfo) {
        String sql = "INSERT INTO Other_Info (laptop_id, battery, charger_power, operating_system, release_year) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, otherInfo.getLaptop().getLaptop_id(), otherInfo.getBatery_info(), otherInfo.getCharger_power(), otherInfo.getOperating_system(), otherInfo.getRelease_date());
    }
*/
    public int updateLaptop(Laptop laptop) {
        String sql = "UPDATE Laptops SET  laptop_name = :laptop_name, laptop_price = :laptop_price WHERE laptop_id = :laptop_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("laptop_id", laptop.getLaptop_id());
        params.addValue("laptop_name", laptop.getLaptop_name());
        params.addValue("laptop_price", laptop.getLaptop_price());

        return namedParameterJdbcTemplate.update(sql, params);
    }
   
    public int deleteLaptop(long id) {
        String sql = "DELETE FROM Laptops WHERE laptop_id = :laptop_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("laptop_id", id);

        return namedParameterJdbcTemplate.update(sql, params);
    }
    public Laptop getLaptopById(Integer laptop_id) {
        String sql = "SELECT * FROM Laptops WHERE laptop_id = :laptop_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("laptop_id", laptop_id);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new LaptopRowMapper());
        } catch (EmptyResultDataAccessException e) {
          
            System.out.println("Laptop not found with id: " + laptop_id);
            return null;  
        }
    }
    public CPU getCPUById(Integer laptop_id) {
        String sql = "SELECT * FROM CPU_Details WHERE laptop_id = :laptop_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("laptop_id", laptop_id);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new CPURowMapper());
        } catch (EmptyResultDataAccessException e) {
          
            System.out.println("Laptop not found with id: " + laptop_id);
            return null;  
        }
    }
    public List<Laptop> getAllLaptops() {
        String sql = "SELECT * FROM Laptops";  
        return namedParameterJdbcTemplate.query(sql, new LaptopRowMapper());
    }
    public List<Laptop_Money> getAllLaptop_Moneys(){
        String sql ="Select * from Laptop_Money";
        return namedParameterJdbcTemplate.query(sql, new Laptop_MoneyRowMapper());
    }
    public List<String> getAllThang(){
        String sql = "SELECT MONTH(ngayBan) AS Month FROM Laptop_Money GROUP BY MONTH(ngayBan)";
        return namedParameterJdbcTemplate.query(sql,
                (rs, rowNum) -> "Tháng " + rs.getInt("Month")) ;
    }
    public List<Integer> getAllSoLuong(){
        String sql="SELECT MONTH(ngayBan) AS Month, SUM(soLuong) AS TotalSales FROM Laptop_Money GROUP BY MONTH(ngayBan) ORDER BY Month;";
        return namedParameterJdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getInt("TotalSales"));
    }
    public List<Integer> getAllDoanhThu(){
        String sql = "SELECT MONTH(ngayBan) AS Month, SUM(doanhThu) AS TotalSales FROM Laptop_Money GROUP BY MONTH(ngayBan) ORDER BY Month;";
        return namedParameterJdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getInt("TotalSales"));
    }
    public List<Integer> getAllSoLuongThang(int month) {
        String sql = "SELECT d.day, COALESCE(SUM(lm.soLuong), 0) AS sl " +
                     "FROM (" +
                     "SELECT 1 AS day UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL " +
                     "SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL " +
                     "SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL " +
                     "SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 UNION ALL " +
                     "SELECT 13 UNION ALL SELECT 14 UNION ALL SELECT 15 UNION ALL " +
                     "SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL " +
                     "SELECT 19 UNION ALL SELECT 20 UNION ALL SELECT 21 UNION ALL " +
                     "SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL " +
                     "SELECT 25 UNION ALL SELECT 26 UNION ALL SELECT 27 UNION ALL " +
                     "SELECT 28 UNION ALL SELECT 29 UNION ALL SELECT 30 UNION ALL " +
                     "SELECT 31) AS d " +
                     "LEFT JOIN Laptop_Money lm ON DAY(lm.ngayBan) = d.day AND MONTH(lm.ngayBan) = :month " +
                     "GROUP BY d.day " +
                     "ORDER BY d.day";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("month", month);
        return namedParameterJdbcTemplate.query(sql,params, (rs, rowNum) -> rs.getInt("sl"));
    }    
    public Laptop getDetailsLaptopById(Integer laptop_id) {
    	 	String sqlLaptop = "SELECT * FROM Laptops WHERE laptop_id = :laptop_id";
    	    String sqlCPU = "SELECT * FROM CPU_Details WHERE laptop_id = :laptop_id";
    	    String sqlRam = "SELECT * FROM RAM_Storage WHERE laptop_id = :laptop_id";
    	    String sqlScreen = "SELECT * FROM Screen_Details WHERE laptop_id = :laptop_id";
    	    String sqlGraphics_audio = "SELECT * FROM Graphics_Audio WHERE laptop_id = :laptop_id";
    	    String sqlPorts_features = "SELECT * FROM Ports_Features WHERE laptop_id = :laptop_id";
    	    String sqlDimension_weight = "SELECT * FROM Dimensions_Weight WHERE laptop_id = :laptop_id";
    	    String sqlOther_info = "SELECT * FROM Other_Info WHERE laptop_id = :laptop_id";
    	    Laptop laptop = namedParameterJdbcTemplate.queryForObject(sqlLaptop, new MapSqlParameterSource("laptop_id", laptop_id), new LaptopRowMapper());
    	    CPU cpu = namedParameterJdbcTemplate.queryForObject(sqlCPU, new MapSqlParameterSource("laptop_id", laptop_id), new CPURowMapper());
    	    Ram_storage ram = namedParameterJdbcTemplate.queryForObject(sqlRam, new MapSqlParameterSource("laptop_id", laptop_id), new RamStorageRowMapper());
    	    Screen screen = namedParameterJdbcTemplate.queryForObject(sqlScreen, new MapSqlParameterSource("laptop_id", laptop_id), new ScreenRowMapper());
    	    Graphics_audio graphics_audio = namedParameterJdbcTemplate.queryForObject(sqlGraphics_audio, new MapSqlParameterSource("laptop_id", laptop_id), new Graphics_audioRowMapper());
    	    Ports_features port_features = namedParameterJdbcTemplate.queryForObject(sqlPorts_features, new MapSqlParameterSource("laptop_id", laptop_id), new Port_featureRowMapper());
    	    Dimension_weight dimension_weight = namedParameterJdbcTemplate.queryForObject(sqlDimension_weight, new MapSqlParameterSource("laptop_id", laptop_id), new DimensionRowMapper());
    	    Other_info other_info = namedParameterJdbcTemplate.queryForObject(sqlOther_info, new MapSqlParameterSource("laptop_id", laptop_id), new Other_infoRowMapper());
    	    laptop.setCpu(cpu);
    	    laptop.setRam(ram);
    	    laptop.setScreen(screen);
    	    laptop.setGraphics_audio(graphics_audio);
    	    laptop.setPorts_features(port_features);
    	    laptop.setDimension_weight(dimension_weight);
    	    laptop.setOther_info(other_info);
    	return laptop;
    }
    private LaptopDAO laptopDAO;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        Connection connection = dataSource.getConnection();
        this.laptopDAO = new LaptopDAO(connection);
    }

    public List<Laptop> getLaptopsByPage(int page, int size) throws SQLException {
        return laptopDAO.getLaptopsByPage(page, size);
    }

    public int getTotalPages(int size) throws SQLException {
        return laptopDAO.getTotalPages(size);
    }
     

    public void deleteLaptop(Integer laptop_id) {
        String sql = "DELETE FROM Laptops WHERE laptop_id = ?";
        jdbcTemplate.update(sql, laptop_id);
    }
}

