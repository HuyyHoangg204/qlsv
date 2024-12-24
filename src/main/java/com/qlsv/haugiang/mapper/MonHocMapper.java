package com.qlsv.haugiang.mapper;

import com.qlsv.haugiang.dto.request.MonHocRequest;
import com.qlsv.haugiang.entity.Lop;
import com.qlsv.haugiang.entity.MonHoc;

public class MonHocMapper {

    public MonHoc mapToMonHoc(MonHocRequest monHocRequest, Lop lop) {
        MonHoc monHoc = new MonHoc();

        // Gán các thuộc tính từ MonHocRequest cho MonHoc
        monHoc.setMaMH(monHocRequest.getMaMH());
        monHoc.setTenMH(monHocRequest.getTenMH());
        monHoc.setSoTinChi(monHocRequest.getSoTinChi());
        monHoc.setTinChiTH(monHocRequest.getTinChiTH());
        monHoc.setTinChiLT(monHocRequest.getTinChiLT());
        monHoc.setTinChiBTL(monHocRequest.getTinChiBTL());
        monHoc.setHocKy(monHocRequest.getHocKy());

        // Gán lớp vào môn học
        monHoc.setLop(lop);

        return monHoc;
    }
}
