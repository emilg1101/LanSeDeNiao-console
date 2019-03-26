package lansedeniao.presentation.presenter;

import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.*;
import lansedeniao.domain.usecase.SignUpUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.view.SignUpView;

public class SignUpPresenter extends Presenter<SignUpView> {

    private SignUpUseCase signUpUseCase = new SignUpUseCase();

    public void signUp(String name, String email, String username, String password)
    {
        try
        {
            signUpUseCase.signup(name, email, username, password);
            getView().signUp();
        } catch (NameValidationException e) {
            getView().nameValidationError();
        } catch (PasswordValidationException e) {
            getView().passwordValidationError();
        } catch (EmailValidationException e) {
            getView().emailValidationError();
        } catch (UsernameExistsException e) {
            getView().usernameExistError();
        } catch (UsernameValidationException e) {
            getView().usernameValidationError();
        }
    }

}
