package com.qlsv.haugiang.repository;

import com.qlsv.haugiang.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonHocRepository extends JpaRepository<MonHoc,String> {
    boolean existsByMaMH(String MaMh);
}
