package lansedeniao.presentation.printer;

public class HelpPrinter {

    public void print() {
        System.out.println("----------------------------");
        System.out.println("Commands");
        System.out.println("         ");
        System.out.println("/login <username> <password>");
        System.out.println("/logout");
        System.out.println("/signup <login> <password> <birthday> <country> <gender>");
        System.out.println(" ");
        System.out.println("use /help for more commands");
        System.out.println("----------------------------");
    }
}
