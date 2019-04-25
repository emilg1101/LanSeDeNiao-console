package com.github.emilg1101.lansedeniao.data.database.jpa.repository;

import com.github.emilg1101.lansedeniao.data.database.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT *, (SELECT count(id) FROM new_schema.post WHERE user_id = new_schema.user.id) AS posts_amount,\n" +
            "          (SELECT count(post.id) FROM new_schema.post INNER JOIN new_schema.like ON post.id = new_schema.like.post_id AND post.user_id = new_schema.user.id) AS likes_amount\n" +
            "FROM new_schema.user WHERE new_schema.user.id = ?")
    Optional<User> getUserById(long id);

    @Query(nativeQuery = true, value = "SELECT *, (SELECT count(id) FROM new_schema.post WHERE user_id = new_schema.user.id) AS posts_amount,\n" +
            "          (SELECT count(post.id) FROM new_schema.post INNER JOIN new_schema.like ON post.id = new_schema.like.post_id AND post.user_id = new_schema.user.id) AS likes_amount\n" +
            "FROM new_schema.user WHERE new_schema.user.username = ?")
    Optional<User> getUserByUsername(String username);

    User save(User user);
}
