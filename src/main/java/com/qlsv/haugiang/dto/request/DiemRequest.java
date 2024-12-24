package com.qlsv.haugiang.dto.request;

public class DiemRequest {
    private int diemId;
    private double diemTX1;
    private double diemTx2;
    private double diemGiuaKy;
    private double diemCuoiKy;
    private double diemTichLuy;
    private String xepLoai;
    private String maLop;
    private String maSv;
    private String maMH;

    public DiemRequest() {
    }

    public DiemRequest(int diemId, double diemTX1, double diemTx2, double diemGiuaKy, double diemCuoiKy, double diemTichLuy, String xepLoai, String maLop, String maSv, String maMH) {
        this.diemId = diemId;
        this.diemTX1 = diemTX1;
        this.diemTx2 = diemTx2;
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
        this.diemTichLuy = diemTichLuy;
        this.xepLoai = xepLoai;
        this.maLop = maLop;
        this.maSv = maSv;
        this.maMH = maMH;
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

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }
}
