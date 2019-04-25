package com.github.emilg1101.lansedeniao.data.database.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    public Long id;
    public String username;
    public String password;
    public String name;
    public String email;
    public Date bdate;
    public String country;
    public Integer gender;
    public Date rdate;
    @Column(name = "likes_amount")
    public Integer likesAmount;
    @Column(name = "posts_amount")
    public Integer postsAmount;
}
