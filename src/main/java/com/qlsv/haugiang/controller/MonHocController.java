package com.qlsv.haugiang.controller;

import com.qlsv.haugiang.dto.request.MonHocRequest;
import com.qlsv.haugiang.entity.Lop;
import com.qlsv.haugiang.entity.MonHoc;
import com.qlsv.haugiang.entity.User;
import com.qlsv.haugiang.mapper.MonHocMapper;
import com.qlsv.haugiang.repository.LopRepository;
import com.qlsv.haugiang.repository.MonHocRepository;
import com.qlsv.haugiang.service.impl.MonHocServiceImpl;
import com.qlsv.haugiang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MonHocController {
    @Autowired
    private MonHocServiceImpl monHocService;

    @Autowired
    private LopRepository lopRepository;

    @Autowired
    private MonHocRepository monHocRepository;

    @PostMapping("/add-monhoc")
    public ResponseEntity<MonHoc> addMonHoc(@RequestBody MonHocRequest monHocRequest) {
        Lop lop = lopRepository.findById(monHocRequest.getMaLop()).orElseThrow(null);

        // Kiểm tra xem lớp có tồn tại không
        if (lop == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        MonHocMapper monHocMapper = new MonHocMapper();

        MonHoc monHoc = monHocMapper.mapToMonHoc(monHocRequest,lop);

        MonHoc monHoc1 = monHocRepository.save(monHoc);
        return ResponseEntity.ok(monHoc1);
    }
    @GetMapping("/monhocs")
    public ResponseEntity<List<MonHoc>> findAll() {
        List<MonHoc> monHocs = monHocRepository.findAll();
        return ResponseEntity.ok(monHocs);
    }

    @DeleteMapping("/monhoc/{maMH}")
    public ResponseEntity<String> deleteMonHoc(@PathVariable String maMH) {
        // Kiểm tra xem môn học có tồn tại trong cơ sở dữ liệu không
        Optional<MonHoc> monHocOpt = monHocRepository.findById(maMH);

        if (!monHocOpt.isPresent()) {
            // Nếu không tồn tại, trả về lỗi 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Môn học với mã " + maMH + " không tồn tại.");
        }

        // Nếu tồn tại, thực hiện xóa môn học
        try {
            monHocRepository.deleteById(maMH);
            return ResponseEntity.ok("Đã xóa thành công môn học với mã: " + maMH);
        } catch (Exception e) {
            // Xử lý nếu có lỗi khi xóa
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đã xảy ra lỗi khi xóa môn học với mã: " + maMH);
        }
    }
    @PutMapping("/update-monhoc/{maMH}")
    public ResponseEntity<MonHoc> updateMonHoc(@PathVariable String maMH, @RequestBody MonHocRequest monHocRequest) {
        // Kiểm tra xem môn học có tồn tại không
        Optional<MonHoc> monHocOpt = monHocRepository.findById(maMH);
        if (!monHocOpt.isPresent()) {
            // Nếu môn học không tồn tại, trả về lỗi 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        // Lấy thông tin môn học hiện tại từ database
        MonHoc existingMonHoc = monHocOpt.get();
        // Cập nhật thông tin môn học
        existingMonHoc.setTenMH(monHocRequest.getTenMH());
        existingMonHoc.setSoTinChi(monHocRequest.getSoTinChi());
        existingMonHoc.setHocKy(monHocRequest.getHocKy());
        existingMonHoc.setTinChiBTL(monHocRequest.getTinChiBTL());
        existingMonHoc.setTinChiLT(monHocRequest.getTinChiLT());
        existingMonHoc.setTinChiTH(monHocRequest.getTinChiTH());

        // Kiểm tra và cập nhật thông tin lớp nếu cần
        if (monHocRequest.getMaLop() != null) {
            Lop lop = lopRepository.findById(monHocRequest.getMaLop())
                    .orElseThrow(() -> new RuntimeException("Lớp không tồn tại!"));
            existingMonHoc.setLop(lop);
        }

        // Lưu thông tin đã cập nhật vào cơ sở dữ liệu
        MonHoc updatedMonHoc = monHocRepository.save(existingMonHoc);

        // Trả về kết quả
        return ResponseEntity.ok(updatedMonHoc);
    }





}
