package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.Comment;
import com.github.emilg1101.lansedeniao.domain.exception.AddCommentException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.repository.PostRepository;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCommentUseCase {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addComment(long postId, String text) throws UserNotLoggedInException, AddCommentException {
        if (!userRepository.hasLoggedInUser()) throw new UserNotLoggedInException();
        Comment comment = postRepository.addComment(
                postId,
                userRepository.getLoggedInUser().getId(),
                text
        );
        if (comment != null) {
            return comment;
        }
        throw new AddCommentException();
    }
}
