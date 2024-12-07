package com.example.laptops.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.laptops.model.laptop.*;

public class Laptop_MoneyRowMapper implements RowMapper<Laptop_Money> {
   

    @Override
    public Laptop_Money mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Laptop_Money laptop_money = new Laptop_Money();
        laptop_money.setSell_id(rs.getInt("sell_id"));
        Laptop laptop = new Laptop();
        laptop.setLaptop_id(rs.getInt("laptop_id"));
       // laptop.setLaptop_name(rs.getString("laptop_name"));
        laptop_money.setLaptop(laptop);
        laptop_money.setSoLuong(rs.getInt("soLuong"));
        laptop_money.setNgayBan(rs.getDate("ngayBan"));
        laptop_money.setDoanhThu(rs.getInt("doanhThu"));
        return laptop_money;
       // throw new UnsupportedOperationException("Unimplemented method 'mapRow'");
    }
   
}
