package com.github.emilg1101.lansedeniao.presentation.printer;

import com.github.emilg1101.lansedeniao.presentation.model.PostModel;

public class PostPrinter {

    public void print(PostModel postModel) {
        System.out.println("==============================");
        System.out.println(postModel.getUsername());
        System.out.println(" ");
        System.out.println("Date of creating: " + postModel.getCdate());
        System.out.println(" ");
        System.out.println(postModel.getText());
        System.out.println(" ");
        System.out.println("Likes: " + postModel.getCountLikes() + "   Comments " + postModel.getCountComments());
        System.out.println("==============================");
    }
}
