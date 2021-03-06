package lansedeniao.domain.repository;

import lansedeniao.domain.entity.User;

public interface UserRepository {

    User getUserById(long id);

    User getUserByUsername(String username);

    User addUser(User user);

    boolean hasLoggedInUser();

    User getLoggedInUser();

    void setLoggedInUser(User user);
}
