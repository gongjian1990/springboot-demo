package com.gongj.springbootjpa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column
    private Integer uid;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer age;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
