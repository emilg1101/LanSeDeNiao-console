package lansedeniao.presentation.printer;

import lansedeniao.presentation.model.PostModel;

public class PostPrinter {

    public void print(PostModel postModel)
    {
        System.out.println("==============================");
        System.out.println(postModel.getUsername());
        System.out.println(" ");
        System.out.println("Date of creating: " + postModel.getCdate());
        System.out.println(" ");
        System.out.println(postModel.getText());
        System.out.println(" ");
        System.out.println("Likes: " + postModel.getCountLikes() + "   Comments " + postModel.getCountComments());
        System.out.println("==============================");
    }
}
