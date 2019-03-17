package domain.repository;

import domain.entity.User;

public interface UserRepository {

    User getUserById(long id);

    User getUserByUsername(String username);
}
