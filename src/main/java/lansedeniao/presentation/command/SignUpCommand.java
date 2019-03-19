package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.exception.*;
import lansedeniao.domain.usecase.SignUpUseCase;
import lansedeniao.presentation.printer.HelpPrinter;

public class SignUpCommand implements Command {

    private SignUpUseCase signUpUseCase = new SignUpUseCase();

    @Override
    public void execute(Arguments arguments) {

        String name = arguments.getString("name");
        String email = arguments.getString("email");
        String username = arguments.getString("username");
        String password = arguments.getString("password");

        try {
            signUpUseCase.signup(name, email, username, password);
            new HelpPrinter().print();
        } catch (UsernameExistsException e) {
            //TODO: process exception message
            System.out.println("Username " + username + " already exists. Try another one!");
        } catch (EmailValidationException e) {
            //TODO: process exception message
        } catch (PasswordValidationException e) {
            //TODO: process exception message
        } catch (UsernameValidationException e) {
            //TODO: process exception message
        } catch (NameValidationException e) {
            //TODO: process exception message
        }
    }
}
