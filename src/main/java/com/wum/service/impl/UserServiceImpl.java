package com.wum.service.impl;

import com.wum.dao.UserDao;
import com.wum.entity.User;
import com.wum.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findAllByUid(int uid) {
        return userDao.findAllByUid(uid);
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteUserByUid(int uid) {
       userDao.deleteById(uid);
    }

    @Override
    public Page<User> findALL(int page, int pageSize) {
        PageRequest pageable= PageRequest.of(page,pageSize);
        return userDao.findAll(pageable);
    }
}
