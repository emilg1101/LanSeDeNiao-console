package com.github.emilg1101.lansedeniao.presentation.view;

import com.github.emilg1101.lansedeniao.presentation.base.MvpView;
import com.github.emilg1101.lansedeniao.presentation.model.CommentsModel;
import com.github.emilg1101.lansedeniao.presentation.model.PostModel;

public interface PostsView extends MvpView {

    void showPost(PostModel postModel);

    void showComments(CommentsModel commentsModel);

    void noPostsError();

    void userNotFoundError();

    void userNotLoggedInError();

    void addCommentError();
}
