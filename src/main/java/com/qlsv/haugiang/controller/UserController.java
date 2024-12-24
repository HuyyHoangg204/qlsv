package com.qlsv.haugiang.controller;

import com.qlsv.haugiang.entity.User;
import com.qlsv.haugiang.repository.UserRepository;
import com.qlsv.haugiang.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User user1 = userService.create(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/user/{maSv}")
    public ResponseEntity<String> deleteUser(@PathVariable String maSv) {
// Kiểm tra nếu người dùng tồn tại
        Optional<User> user = userRepository.findById(maSv);

        if (user.isPresent()) {
            // Nếu tồn tại, xóa người dùng
            userRepository.delete(user.get());
            return ResponseEntity.ok("User with maSv " + maSv + " has been deleted.");
        } else {
            // Nếu không tìm thấy người dùng, trả về lỗi
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with maSv " + maSv + " not found.");
        }
    }
    @PostMapping("/update_user/{maSV}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String maSV) {
        // Tìm kiếm người dùng trong cơ sở dữ liệu theo maSV từ URL
        Optional<User> existingUserOpt = userRepository.findById(maSV);

        // Nếu không tìm thấy người dùng, trả về lỗi 404
        if (!existingUserOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Lấy đối tượng User hiện tại từ cơ sở dữ liệu
        User existingUser = existingUserOpt.get();

        // Cập nhật các trường của người dùng từ request body
        existingUser.setDiachi(user.getDiachi());
        existingUser.setSoDienThoai(user.getSoDienThoai());
        existingUser.setTaiKhoan(user.getTaiKhoan());
        existingUser.setHoTen(user.getHoTen());
        existingUser.setHinhAnh(user.getHinhAnh());
        existingUser.setQuyen(user.getQuyen());
        existingUser.setGioiTinh(user.getGioiTinh());
        existingUser.setNgaySinh(user.getNgaySinh());
        existingUser.setEmail(user.getEmail());


        // Lưu lại thông tin đã cập nhật vào cơ sở dữ liệu
        User updatedUser = userRepository.save(existingUser);

        // Trả về kết quả với thông tin người dùng đã được cập nhật
        return ResponseEntity.ok(updatedUser);
    }

}
