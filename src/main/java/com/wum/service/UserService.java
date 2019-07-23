package com.wum.service;

import com.wum.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    /*
     *添加用户
     *
     */
    User addUser(User user);
    /*
     *查询所有用户信息
     *
     */
    List<User> findAll();
    /*
     *根据uid
     *查询用户信息
     */
    User findAllByUid(int uid);
    /*
     *根据uid
     *删除用户信息
     */
    void deleteUserByUid(int uid);
    /*
     *更新用户信息
     *
     */
    User updateUser(User user);
    /*
     *分页查询
     * 用户信息
     */
    Page<User> findALL(int page, int pageSize);
}
