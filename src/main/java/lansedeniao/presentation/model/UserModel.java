package lansedeniao.presentation.model;

import lansedeniao.domain.entity.User;

public class UserModel {

    private String username;
    private String password;

    UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static UserModel mapper(User from) {
        return new UserModel(from.getUsername(), from.getPassword());
    }
}
