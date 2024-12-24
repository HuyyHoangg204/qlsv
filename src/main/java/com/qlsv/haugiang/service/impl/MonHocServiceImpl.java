package com.qlsv.haugiang.service.impl;

import com.qlsv.haugiang.entity.MonHoc;
import com.qlsv.haugiang.repository.MonHocRepository;
import com.qlsv.haugiang.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocServiceImpl implements MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;




    @Override
    public MonHoc create(MonHoc dto) {
        MonHoc res = monHocRepository.save(dto);
        return res;
    }

    @Override
    public List<MonHoc> getAll() {
        return null;
    }

    @Override
    public MonHoc getById(int id) {
        return null;
    }

    @Override
    public MonHoc update(int id, MonHoc dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
