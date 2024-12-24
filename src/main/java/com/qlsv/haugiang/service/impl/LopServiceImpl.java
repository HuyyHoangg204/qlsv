package com.qlsv.haugiang.service.impl;

import com.qlsv.haugiang.entity.Lop;
import com.qlsv.haugiang.repository.LopRepository;
import com.qlsv.haugiang.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LopServiceImpl implements LopService {
    @Autowired
    private LopRepository lopRepository;

    @Override
    public Lop create(Lop dto) {


        Lop res = lopRepository.save(dto);
        return res;
    }

    @Override
    public List<Lop> getAll() {
        List<Lop> res = lopRepository.findAll();
        return res;
    }

    @Override
    public Lop getById(int id) {
        return null;
    }

    @Override
    public Lop update(int id, Lop dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
