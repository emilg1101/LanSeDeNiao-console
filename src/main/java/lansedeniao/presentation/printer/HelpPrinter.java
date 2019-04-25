package lansedeniao.presentation.printer;

public class HelpPrinter {

    public static void print() {
        System.out.println("----------------------------");
        System.out.println("Commands");
        System.out.println("         ");
        System.out.println("/login <username> <password>");
        System.out.println("/logout");
        System.out.println("/signup <login> <password> <birthday> <country> <gender>");
        System.out.println("/addPost <text>");
        System.out.println("/posts <username>");
        System.out.println(" ");
        System.out.println("commands for posts:");
        System.out.println("/next");
        System.out.println("/prev");
        System.out.println("/like");
        System.out.println("/comments");
        System.out.println("/back");
        System.out.println("/addComment <text>");
        System.out.println(" ");
        System.out.println("use /help for more commands");
        System.out.println("----------------------------");
    }
}
