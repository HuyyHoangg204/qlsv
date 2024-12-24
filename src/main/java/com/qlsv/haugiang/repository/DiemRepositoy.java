package com.qlsv.haugiang.repository;

import com.qlsv.haugiang.entity.Diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiemRepositoy extends JpaRepository<Diem,Integer> {
    @Modifying
    @Query("DELETE FROM Diem d WHERE d.diemId = :id")
    void deleteByDiemId( @Param("id") int id);
}
