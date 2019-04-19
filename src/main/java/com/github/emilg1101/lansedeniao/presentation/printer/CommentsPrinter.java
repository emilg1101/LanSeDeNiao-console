package com.github.emilg1101.lansedeniao.presentation.printer;

import com.github.emilg1101.lansedeniao.presentation.model.CommentModel;
import com.github.emilg1101.lansedeniao.presentation.model.CommentsModel;

public class CommentsPrinter {

    public void print(CommentsModel commentsModel) {
        System.out.println("==================================");
        for (CommentModel commentModel : commentsModel.getCommentModelList()) {
            System.out.println(commentModel.getUsername());
            System.out.println("");
            System.out.println(commentModel.getText());
            System.out.println("==================================");
        }
    }
}
