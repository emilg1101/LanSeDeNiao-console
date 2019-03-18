package lansedeniao.presentation.model;

import lansedeniao.domain.entity.User;

import java.util.Date;

public class ProfileModel {

    private String username;
    private String email;
    private Date dateOfRegistration;
    private Date birthDay;
    private int countOfLikes;
    private int countOfPosts;
    private String country;
    private int gender;

    public ProfileModel(String username,
                     String email,
                     Date dateOfRegistration,
                     Date birthDay,
                     int countOfLikes,
                     int countOfPosts,
                     String country,
                     int gender)
    {
        this.username = username;
        this.email = email;
        this.dateOfRegistration = dateOfRegistration;
        this.birthDay = birthDay;
        this.countOfLikes = countOfLikes;
        this.countOfPosts = countOfPosts;
        this.country = country;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public int getCountOfPosts() {
        return countOfPosts;
    }

    public String getCountry() {
        return country;
    }

    public int getGender() {
        return gender;
    }

    public static ProfileModel mapper(User from) {
        return new ProfileModel(
                from.getUsername(),
                from.getEmail(),
                from.getRegistrationDate(),
                from.getBirthDate(),
                from.getLikesCount(),
                from.getPostsCount(),
                from.getCountry(),
                from.getGender()
        );
    }
}
