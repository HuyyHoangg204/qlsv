package com.qlsv.haugiang.entity;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name = "diem")
@Entity
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diemId;
    private double diemTX1;
    private double diemTx2;
    private double diemGiuaKy;
    private double diemCuoiKy;
    private double diemTichLuy;
    private String xepLoai;


    @ManyToOne
    @JoinColumn(name = "maLop")
    private Lop lop;

    @ManyToOne
    @JoinColumn(name = "maMH")
    private MonHoc monHoc;

    @OneToOne
    @JoinColumn(name = "maSv", referencedColumnName = "maSv") // Trường khóa ngoại sẽ là maSv từ bảng User
    private User user;

    public Diem() {
    }

    public Diem(int diemId, double diemTX1, double diemTx2, double diemGiuaKy, double diemCuoiKy, double diemTichLuy, String xepLoai, Lop lop, MonHoc monHoc, User user) {
        this.diemId = diemId;
        this.diemTX1 = diemTX1;
        this.diemTx2 = diemTx2;
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
        this.diemTichLuy = diemTichLuy;
        this.xepLoai = xepLoai;
        this.lop = lop;
        this.monHoc = monHoc;
        this.user = user;
    }

    public int getDiemId() {
        return diemId;
    }

    public void setDiemId(int diemId) {
        this.diemId = diemId;
    }

    public double getDiemTX1() {
        return diemTX1;
    }

    public void setDiemTX1(double diemTX1) {
        this.diemTX1 = diemTX1;
    }

    public double getDiemTx2() {
        return diemTx2;
    }

    public void setDiemTx2(double diemTx2) {
        this.diemTx2 = diemTx2;
    }

    public double getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(double diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "diemId=" + diemId +
                ", diemTX1=" + diemTX1 +
                ", diemTx2=" + diemTx2 +
                ", diemGiuaKy=" + diemGiuaKy +
                ", diemCuoiKy=" + diemCuoiKy +
                ", diemTichLuy=" + diemTichLuy +
                ", xepLoai='" + xepLoai + '\'' +
                ", lop=" + lop +
                ", monHoc=" + monHoc +
                ", user=" + user +
                '}';
    }
}
