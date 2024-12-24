package com.qlsv.haugiang.controller;

import com.qlsv.haugiang.entity.Lop;

import com.qlsv.haugiang.repository.LopRepository;
import com.qlsv.haugiang.service.impl.LopServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class LopController {
    @Autowired
    private LopServiceImpl lopService;

    @Autowired
    private LopRepository lopRepository;

    @PostMapping("/add-lop")
    public ResponseEntity<Lop> addMonHoc(@RequestBody Lop lop) {
        Lop lop1 = lopService.create(lop);
        return ResponseEntity.ok(lop1);
    }
    @GetMapping("/lops")
    public ResponseEntity<List<Lop>> findAll() {
        List<Lop> lops = lopService.getAll();
        return ResponseEntity.ok(lops);
    }

    @DeleteMapping("/lop/{maLop}")
    public ResponseEntity<String> deleteLop(@PathVariable String maLop) {
        // Kiểm tra xem lớp có tồn tại không
        Optional<Lop> lop = lopRepository.findById(maLop);
        if (!lop.isPresent()) {
            // Nếu lớp không tồn tại, trả về lỗi 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lớp với mã " + maLop + " không tồn tại.");
        }

        // Kiểm tra nếu lớp có liên kết với điểm, môn học hoặc sinh viên
//        if (lop.get(). != null && !lop.get().getDiems().isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Không thể xóa lớp vì lớp này có liên kết với điểm.");
//        }

        // Xóa lớp
        lopRepository.deleteById(maLop);

        // Trả về phản hồi thành công
        return ResponseEntity.ok("Đã xóa thành công lớp với mã " + maLop);
    }

    @PutMapping("/update_lop/{maLop}")
    public ResponseEntity<Lop> updateLop(@RequestBody Lop lop, @PathVariable String maLop) {
        // Tìm kiếm lớp trong cơ sở dữ liệu theo maLop từ URL
        Optional<Lop> existingLopOpt = lopRepository.findById(maLop);

        // Nếu không tìm thấy lớp, trả về lỗi 404
        if (!existingLopOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Lấy đối tượng Lop hiện tại từ cơ sở dữ liệu
        Lop existingLop = existingLopOpt.get();

        // Cập nhật các trường của lớp từ request body
        existingLop.setTenLop(lop.getTenLop());
        existingLop.setDiaDiem(lop.getDiaDiem());
        existingLop.setThoiGianHoc(lop.getThoiGianHoc());
        existingLop.setTenGiangVien(lop.getTenGiangVien());

        // Lưu lại thông tin đã cập nhật vào cơ sở dữ liệu
        Lop updatedLop = lopRepository.save(existingLop);

        // Trả về kết quả với thông tin lớp đã được cập nhật
        return ResponseEntity.ok(updatedLop);
    }

}
