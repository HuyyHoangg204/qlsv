package com.qlsv.haugiang.mapper;

import com.qlsv.haugiang.dto.request.DiemRequest;
import com.qlsv.haugiang.entity.Diem;
import com.qlsv.haugiang.entity.Lop;
import com.qlsv.haugiang.entity.MonHoc;
import com.qlsv.haugiang.entity.User;

public class DiemMapper {

    public Diem mapToDiem(DiemRequest diemRequest, Lop lop, MonHoc monHoc, User user) {
        Diem diem = new Diem();

        // Set giá trị cho các trường của Diem từ DiemRequest
        diem.setDiemTX1(diemRequest.getDiemTX1());
        diem.setDiemTx2(diemRequest.getDiemTx2());
        diem.setDiemGiuaKy(diemRequest.getDiemGiuaKy());
        diem.setDiemCuoiKy(diemRequest.getDiemCuoiKy());
        diem.setDiemTichLuy(diemRequest.getDiemTichLuy());
        diem.setXepLoai(diemRequest.getXepLoai());

        // Set Lop, MonHoc và User từ các tham số
        diem.setLop(lop);
        diem.setMonHoc(monHoc);
        diem.setUser(user);

        return diem;

    }
}
