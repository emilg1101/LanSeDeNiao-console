package lansedeniao.presentation.printer;

import lansedeniao.presentation.model.UserModel;

public class LoginPrinter {

    public void print(UserModel userModel) {
        System.out.println("================================");
        System.out.println("username " + userModel.username);
        System.out.println("password " + userModel.password);
        System.out.println("================================");
    }
}
