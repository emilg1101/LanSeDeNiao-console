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
            System.out.println("Username " + username + " already exists. Try another one!");
        } catch (EmailValidationException e) {
            System.out.println("your email have invalid format");
        } catch (PasswordValidationException e) {
            System.out.println("Please, write password more 6 letters");
        } catch (UsernameValidationException e) {
            System.out.println("Please, write username more 3 letters");
        } catch (NameValidationException e) {
            System.out.println("Please, write name more 3 letters");
        }
    }
}
