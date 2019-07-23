package com.wum.controller;

import com.wum.entity.User;
import com.wum.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserServiceImpl userService;

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        user.setName(UUID.randomUUID().toString());
        user.setAge(user.getAge());
        user.setGender(user.getGender());
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getUser(){
        List<User> user = userService.findAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> getUserByUid(@PathVariable int uid){
        User user = userService.findAllByUid(uid);
        return ResponseEntity.ok(user);
    }

   @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable int uid){
      userService.deleteUserByUid(uid);;
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> updateUser(@PathVariable Integer uid,
                                        @RequestParam("name") String name,
                                        @RequestParam("age") Integer age,
                                        @RequestParam("gender") User.Gender gender){
        User user = userService.findAllByUid(uid);
        user.setUid(uid);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        User user1 = userService.updateUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/pageUser")
    public ResponseEntity<?> pageUser(@RequestParam("page") int page,@RequestParam("limit") int limit){
        Page<User> pagedata = userService.findALL(page,limit);
            return ResponseEntity.ok(pagedata);
    }
}
