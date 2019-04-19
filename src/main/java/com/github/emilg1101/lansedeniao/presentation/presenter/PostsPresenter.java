package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.entity.Comment;
import com.github.emilg1101.lansedeniao.domain.entity.Post;
import com.github.emilg1101.lansedeniao.domain.exception.AddCommentException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.usecase.AddCommentUseCase;
import com.github.emilg1101.lansedeniao.domain.usecase.LikePostUseCase;
import com.github.emilg1101.lansedeniao.domain.usecase.UserPostsUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.model.CommentsModel;
import com.github.emilg1101.lansedeniao.presentation.model.PostModel;
import com.github.emilg1101.lansedeniao.presentation.view.PostsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsPresenter extends MvpPresenter<PostsView> {

    @Autowired
    private UserPostsUseCase userPostsUseCase;

    @Autowired
    private LikePostUseCase likePostUseCase;

    @Autowired
    private AddCommentUseCase addCommentUseCase;

    private int postPosition = 0;

    private List<Post> posts;

    private String username;

    public void loadPosts(String username) {
        try {
            this.username = username;
            posts = userPostsUseCase.getPosts(username);
            if (posts.size() > 0) {
                showPost();
            } else {
                getView().noPostsError();
            }
        } catch (UserNotFoundException e) {
            posts = null;
            getView().userNotFoundError();
        }
    }

    public void nextPost() {
        postPosition++;
        showPost();
    }

    public void prevPost() {
        postPosition--;
        showPost();
    }

    public void like() {
        if (posts == null) {
            getView().userNotFoundError();
        } else {
            try {
                likePostUseCase.like(posts.get(postPosition).getId());
            } catch (UserNotLoggedInException e) {
                getView().userNotLoggedInError();
            }
            loadPosts(username);
        }
    }

    public void comments() {
        if (posts == null) {
            getView().userNotFoundError();
        } else {
            getView().showComments(CommentsModel.mapper(posts.get(postPosition).getComments()));
        }
    }

    public void back() {
        showPost();
    }

    public void addComment(String text) {
        if (posts == null) {
            getView().userNotFoundError();
        } else {
            if (posts.size() > 0) {
                try {
                    Comment comment = addCommentUseCase.addComment(posts.get(postPosition).getId(), text);
                    posts.get(postPosition).getComments().add(comment);
                    getView().showComments(
                            CommentsModel.mapper(posts.get(postPosition).getComments())
                    );
                } catch (UserNotLoggedInException e) {
                    getView().userNotLoggedInError();
                } catch (AddCommentException e) {
                    getView().addCommentError();
                }
            } else {
                getView().noPostsError();
            }
        }
    }

    private void showPost() {
        if (posts == null) {
            getView().userNotFoundError();
        } else {
            if (postPosition == posts.size()) postPosition = 0;
            if (postPosition < 0) postPosition = posts.size() - 1;
            getView().showPost(PostModel.mapper(posts.get(postPosition)));
        }
    }

    @Override
    public void onDestroy() {
        postPosition = 0;
        posts = null;
    }
}
