package com.qlsv.haugiang.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "lop")
@Entity
public class Lop {
    @Id
    private String maLop;
    private String tenLop;
    private String tenGiangVien;
    private String diaDiem;
    private String thoiGianHoc;

    @OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    @JsonIgnore  // Dùng để tránh tuần tự hóa trường monHoc trong Lop
    private List<MonHoc> monHoc;

    public Lop() {
    }

    public Lop(String maLop, String tenLop, String tenGiangVien, String diaDiem, String thoiGianHoc, List<MonHoc> monHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tenGiangVien = tenGiangVien;
        this.diaDiem = diaDiem;
        this.thoiGianHoc = thoiGianHoc;
        this.monHoc = monHoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(String thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public List<MonHoc> getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(List<MonHoc> monHoc) {
        this.monHoc = monHoc;
    }
}
