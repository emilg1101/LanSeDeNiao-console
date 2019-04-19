package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.Post;
import com.github.emilg1101.lansedeniao.domain.exception.AddPostException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.repository.PostRepository;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPostUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public Post addPost(String text) throws UserNotLoggedInException, AddPostException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        Post addedPost = postRepository.addPost(userRepository.getLoggedInUser().getId(), text);
        if (addedPost == null) {
            throw new AddPostException();
        }
        return addedPost;
    }
}
