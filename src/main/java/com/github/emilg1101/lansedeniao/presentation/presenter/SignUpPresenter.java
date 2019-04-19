package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.exception.*;
import com.github.emilg1101.lansedeniao.domain.usecase.SignUpUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.view.SignUpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpPresenter extends MvpPresenter<SignUpView> {

    @Autowired
    private SignUpUseCase signUpUseCase;

    public void signUp(String name, String email, String username, String password) {
        try {
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
