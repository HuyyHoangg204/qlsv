package com.qlsv.haugiang.controller;


import com.qlsv.haugiang.dto.request.DiemRequest;
import com.qlsv.haugiang.entity.Diem;
import com.qlsv.haugiang.repository.DiemRepositoy;
import com.qlsv.haugiang.repository.LopRepository;
import com.qlsv.haugiang.repository.MonHocRepository;
import com.qlsv.haugiang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DiemController {
    @Autowired
    private DiemRepositoy diemRepositoy;

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private LopRepository lopRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-diem")
    public ResponseEntity<Diem> addDiem(@RequestBody DiemRequest diemRequest) {
        var lop = lopRepository.findById(diemRequest.getMaLop());
        var monHoc = monHocRepository.findById(diemRequest.getMaMH());
        var user = userRepository.findById(diemRequest.getMaSv());
        // Kiểm tra nếu không tìm thấy một trong các đối tượng
        // Kiểm tra nếu không tìm thấy một trong các đối tượng
        if (!lop.isPresent() || !monHoc.isPresent() || !user.isPresent()) {
            return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu không tìm thấy
        }
        // Chuyển đổi DiemRequest thành đối tượng Diem
        Diem diem = new Diem();
        diem.setDiemTX1(diemRequest.getDiemTX1());
        diem.setDiemTx2(diemRequest.getDiemTx2());
        diem.setDiemGiuaKy(diemRequest.getDiemGiuaKy());
        diem.setDiemCuoiKy(diemRequest.getDiemCuoiKy());
        diem.setDiemTichLuy(diemRequest.getDiemTichLuy());
        diem.setXepLoai(diemRequest.getXepLoai());
        diem.setLop(lop.get()); // Gán đối tượng Lop vào
        diem.setMonHoc(monHoc.get()); // Gán đối tượng MonHoc vào
        diem.setUser(user.get()); // Gán đối tượng User vào

        Diem savedDiem = diemRepositoy.save(diem);

        return ResponseEntity.ok(savedDiem );
    }

    @GetMapping("/diems")
    public ResponseEntity<List<Diem>> findAll() {
        List<Diem> diemList = diemRepositoy.findAll();
        return ResponseEntity.ok(diemList);
    }
    @Transactional
    @DeleteMapping("/diem/{diemId}")
    public ResponseEntity<String> deleteDiem(@PathVariable int diemId) {
        // Kiểm tra xem điểm có tồn tại không
        Optional<Diem> existingDiem = diemRepositoy.findById(diemId);
        if (!existingDiem.isPresent()) {
            // Nếu không tìm thấy, trả về lỗi 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Điểm với ID: " + diemId + " không tồn tại.");
        }
        // Nếu tìm thấy, tiến hành xóa
        System.out.println(diemId);
        diemRepositoy.deleteByDiemId(diemId);


        // Trả về phản hồi thành công
        return ResponseEntity.ok("Đã xóa thành công điểm với ID: " + diemId);
    }

    @PutMapping("/update-diem/{diemId}")
    public ResponseEntity<Diem> updateDiem(@PathVariable int diemId, @RequestBody DiemRequest diemRequest) {
        // Tìm điểm theo diemId
        Optional<Diem> existingDiem = diemRepositoy.findById(diemId);

        // Kiểm tra xem điểm có tồn tại không
        if (!existingDiem.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Trả về lỗi nếu không tìm thấy điểm
        }

        // Kiểm tra các đối tượng liên quan (lớp, môn học, sinh viên) có tồn tại không
        var lop = lopRepository.findById(diemRequest.getMaLop());
        var monHoc = monHocRepository.findById(diemRequest.getMaMH());
        var user = userRepository.findById(diemRequest.getMaSv());

        if (!lop.isPresent() || !monHoc.isPresent() || !user.isPresent()) {
            return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu không tìm thấy đối tượng liên quan
        }

        // Cập nhật các trường của Diem
        Diem diemToUpdate = existingDiem.get();
        diemToUpdate.setDiemTX1(diemRequest.getDiemTX1());
        diemToUpdate.setDiemTx2(diemRequest.getDiemTx2());
        diemToUpdate.setDiemGiuaKy(diemRequest.getDiemGiuaKy());
        diemToUpdate.setDiemCuoiKy(diemRequest.getDiemCuoiKy());
        diemToUpdate.setDiemTichLuy(diemRequest.getDiemTichLuy());
        diemToUpdate.setXepLoai(diemRequest.getXepLoai());
        diemToUpdate.setLop(lop.get());
        diemToUpdate.setMonHoc(monHoc.get());
        diemToUpdate.setUser(user.get());

        // Lưu lại điểm đã cập nhật
        Diem updatedDiem = diemRepositoy.save(diemToUpdate);

        // Trả về điểm đã được cập nhật
        return ResponseEntity.ok(updatedDiem);
    }


}
