package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;

public interface SignUpView extends View {

    void signUp();

    void usernameExistError();

    void emailValidationError();

    void passwordValidationError();

    void usernameValidationError();

    void nameValidationError();
}
