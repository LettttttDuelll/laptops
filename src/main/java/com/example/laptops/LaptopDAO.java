package com.example.laptops;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.laptops.model.laptop.Laptop;
public class LaptopDAO {
    private Connection connection;

    public LaptopDAO(Connection connection) {
        this.connection = connection;
    }

    // Phương thức phân trang
    public List<Laptop> getLaptopsByPage(int page, int size) throws SQLException {
        List<Laptop> laptops = new ArrayList<>();
        String sql = "SELECT * FROM laptops ORDER BY laptop_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
       // String sql = "SELECT * FROM laptops ORDER BY laptop_id OFFSET 1 ROWS FETCH NEXT 20 ROWS ONLY";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            int offset = (page - 1) * size; // Tính toán vị trí bắt đầu
            ps.setInt(1, offset);
            ps.setInt(2, size);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Laptop laptop = new Laptop();
                    laptop.setLaptop_id(rs.getInt("laptop_id"));
                    laptop.setLaptop_name(rs.getString("laptop_name"));
                    laptop.setLaptop_price(rs.getInt("laptop_price"));
                    laptops.add(laptop);
                }
            }
            System.out.println("SQL Query: " + sql);
        System.out.println("Offset: " + offset + ", Size: " + size);
        }
        return laptops;
        
    }

    // Phương thức để tính tổng số trang
    public int getTotalPages(int size) throws SQLException {
        String sql = "SELECT COUNT(*) FROM laptops";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                int totalRecords = rs.getInt(1);
                return (int) Math.ceil((double) totalRecords / size);
            }
        }
        return 0;
    
   
}}
