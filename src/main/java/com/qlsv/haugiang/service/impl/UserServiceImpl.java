package com.qlsv.haugiang.service.impl;

import com.qlsv.haugiang.entity.User;
import com.qlsv.haugiang.repository.UserRepository;
import com.qlsv.haugiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User dto) {
        User savedUser = userRepository.save(dto);

        return savedUser;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User update(int id, User dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
