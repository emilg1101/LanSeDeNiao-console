package lansedeniao.presentation.printer;

import lansedeniao.presentation.model.PostModel;

public class CommentsPrinter {

    public void print(PostModel postModel) {
        System.out.println("==================================");
        System.out.println("Post: " + postModel.getPostName());
        System.out.println(" ");
        System.out.println("Comments: " + postModel.getCountComments());
        for (int i = 0; i < postModel.getCountComments(); i++)
            //TODO list of comments
            System.out.println("==================================");
    }
}
