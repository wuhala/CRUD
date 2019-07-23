package com.wum.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public enum Gender {
        F,M;
}
    @Id
    @Basic
    @Column(name = "uid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String name;
    private Integer age;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User() {
        super();
    }



    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
