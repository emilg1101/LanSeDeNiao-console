package lansedeniao.presentation.model;

import lansedeniao.domain.entity.User;

public class UserModel {

    public String username;
    public String password;

    private UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserModel mapper(User from) {
        return new UserModel(from.getUsername(), from.getPassword());
    }
}
