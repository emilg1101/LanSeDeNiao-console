package com.github.emilg1101.lansedeniao.domain.entity;

import java.util.Date;

public class User {

    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Date registrationDate;
    private Date birthDate;
    private String country;
    private int gender;
    private int likesCount;
    private int postsCount;

    public User(long id, String username, String password, String name, String email, Date registrationDate, Date birthDate, String country, int gender, int likesCount, int postsCount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.birthDate = birthDate;
        this.country = country;
        this.gender = gender;
        this.likesCount = likesCount;
        this.postsCount = postsCount;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public int getGender() {
        return gender;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", likesCount=" + likesCount +
                ", postsCount=" + postsCount +
                '}';
    }
}
