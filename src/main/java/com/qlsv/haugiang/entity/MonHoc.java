package com.qlsv.haugiang.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "monhoc")
public class MonHoc {
    @Id
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private int tinChiTH;
    private int tinChiLT;
    private int tinChiBTL;
    private int hocKy;
    @ManyToOne
    @JoinColumn(name = "maLop")  // Thêm khóa ngoại 'maLop' liên kết với lớp
    private Lop lop;


    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, int soTinChi, int tinChiTH, int tinChiLT, int tinChiBTL, int hocKy, Lop lop) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTinChi = soTinChi;
        this.tinChiTH = tinChiTH;
        this.tinChiLT = tinChiLT;
        this.tinChiBTL = tinChiBTL;
        this.hocKy = hocKy;
        this.lop = lop;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getTinChiTH() {
        return tinChiTH;
    }

    public void setTinChiTH(int tinChiTH) {
        this.tinChiTH = tinChiTH;
    }

    public int getTinChiLT() {
        return tinChiLT;
    }

    public void setTinChiLT(int tinChiLT) {
        this.tinChiLT = tinChiLT;
    }

    public int getTinChiBTL() {
        return tinChiBTL;
    }

    public void setTinChiBTL(int tinChiBTL) {
        this.tinChiBTL = tinChiBTL;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}
