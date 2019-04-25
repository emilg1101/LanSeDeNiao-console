package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.entity.Post;
import com.github.emilg1101.lansedeniao.domain.exception.AddPostException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.usecase.AddPostUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.model.PostModel;
import com.github.emilg1101.lansedeniao.presentation.view.AddPostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPostPresenter extends MvpPresenter<AddPostView> {

    @Autowired
    private AddPostUseCase addPostUseCase;

    public void addPost(String text) {
        if (text.length() > 100) {
            getView().lengthException();
            return;
        }
        try {
            Post post = addPostUseCase.addPost(text);
            getView().showPost(PostModel.mapper(post));
        } catch (UserNotLoggedInException e) {
            getView().loggedInError();
        } catch (AddPostException e) {
            getView().wtfError();
        }
    }
}
