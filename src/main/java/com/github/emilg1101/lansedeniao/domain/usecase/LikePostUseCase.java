package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.repository.PostRepository;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikePostUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public void like(long postId) throws UserNotLoggedInException {
        if (!userRepository.hasLoggedInUser()) throw new UserNotLoggedInException();
        postRepository.setLike(postId, userRepository.getLoggedInUser().getId());
    }
}
