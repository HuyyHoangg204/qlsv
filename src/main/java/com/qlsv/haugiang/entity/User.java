package com.qlsv.haugiang.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")

public class User {
    @Id
    private String maSv;
    private String diachi;
    private String soDienThoai;
    private String taiKhoan;
    private String hoTen;
    private String hinhAnh;
    private String quyen;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Diem diem;



    public User() {
    }

    public User(String maSv, String diachi, String soDienThoai, String taiKhoan, String hoTen, String hinhAnh, String quyen, String gioiTinh, LocalDate ngaySinh, String email) {
        this.maSv = maSv;
        this.diachi = diachi;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.hoTen = hoTen;
        this.hinhAnh = hinhAnh;
        this.quyen = quyen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
