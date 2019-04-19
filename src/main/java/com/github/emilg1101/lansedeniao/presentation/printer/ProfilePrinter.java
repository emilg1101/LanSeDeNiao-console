package com.github.emilg1101.lansedeniao.presentation.printer;

import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;

public class ProfilePrinter {

    public void print(ProfileModel profileModel) {
        System.out.println("==========================================");
        System.out.println("UserName               @" + profileModel.getUsername());
        System.out.println("Name                   " + profileModel.getName());
        System.out.println("Your email             " + profileModel.getEmail());
        System.out.println("Date of registration   " + profileModel.getDateOfRegistration());
        if (profileModel.getBirthDay() == null)
            System.out.println("Birthday               undefined");
        else
            System.out.println("Birthday               " + profileModel.getBirthDay());
        System.out.println("Likes                  " + profileModel.getCountOfLikes());
        System.out.println("Posts                  " + profileModel.getCountOfPosts());
        if (profileModel.getCountry() == null || profileModel.getCountry().isEmpty())
            System.out.println("Country                undefined");
        else
            System.out.println("Country               " + profileModel.getCountry());
        if (profileModel.getGender() == 0)
            System.out.println("Gender                 female");
        else if (profileModel.getGender() == 1) System.out.println("Gender               male");
        else System.out.println("Gender                 undefined");
        System.out.println("==========================================");
    }
}
