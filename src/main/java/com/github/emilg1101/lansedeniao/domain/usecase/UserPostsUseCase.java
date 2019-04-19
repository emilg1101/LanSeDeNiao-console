package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.Post;
import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.repository.PostRepository;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPostsUseCase {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> getPosts(String username) throws UserNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) throw new UserNotFoundException();
        return postRepository.getPostsByUserId(user.getId());
    }
}
