package com.wum.dao;

import com.wum.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User ,Integer> , JpaSpecificationExecutor<User> {

    List<User> findAll();

    User findAllByUid(@Param("uid") int uid);




}
