package com.example.laptops.model.laptop;

import java.text.DateFormat;
import java.util.Date;

public class Laptop_Money {
    private int sell_id;
	private Laptop laptop;
    private int soLuong;
    private Date ngayBan;
    public int getDoanhThu() {
        return doanhThu;
    }
    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    private int doanhThu;
    public Laptop_Money(){
    }
    public int getSell_id() {
        return sell_id;
    }

    public void setSell_id(int sell_id) {
        this.sell_id = sell_id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }
    public Laptop_Money(int sell_id, int soLuong, Date ngayBan,int doanhThu) {
        this.sell_id = sell_id;
        this.soLuong = soLuong;
        this.ngayBan = ngayBan;
        this.doanhThu = doanhThu;
    }
    public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
    public void setSell_id(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSell_id'");
    }
}