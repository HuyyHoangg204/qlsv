package com.qlsv.haugiang.repository;

import com.qlsv.haugiang.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LopRepository extends JpaRepository<Lop,String> {
    boolean existsByMaLop(String maLop);
}
