package com.qlsv.haugiang.repository;

import com.qlsv.haugiang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByMaSv(String masv);
}
