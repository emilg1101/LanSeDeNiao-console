package com.github.emilg1101.lansedeniao.presentation.view;

import com.github.emilg1101.lansedeniao.presentation.base.MvpView;
import com.github.emilg1101.lansedeniao.presentation.model.PostModel;

public interface AddPostView extends MvpView {

    void showPost(PostModel postModel);

    void lengthException();

    void loggedInError();

    void wtfError();
}
