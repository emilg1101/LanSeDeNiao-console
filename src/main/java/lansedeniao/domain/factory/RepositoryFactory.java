package lansedeniao.domain.factory;

import lansedeniao.data.repository.PostRepositoryImpl;
import lansedeniao.data.repository.UserRepositoryImpl;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

public class RepositoryFactory {

    private static UserRepository userRepositoryInstance;

    public static UserRepository getUserRepository() {
        if (userRepositoryInstance == null) {
            userRepositoryInstance = new UserRepositoryImpl();
        }
        return userRepositoryInstance;
    }

    public static PostRepository getPostRepository() {
        return new PostRepositoryImpl();
    }
}
