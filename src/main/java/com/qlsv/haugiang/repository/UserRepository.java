package com.qlsv.haugiang.repository;

import com.qlsv.haugiang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByMaSv(String masv);
    Optional<User> findByTaiKhoan(String taikhoan);
}
