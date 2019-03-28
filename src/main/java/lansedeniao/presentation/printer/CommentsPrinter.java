package lansedeniao.presentation.printer;

import lansedeniao.presentation.model.CommentModel;
import lansedeniao.presentation.model.CommentsModel;
import lansedeniao.presentation.model.PostModel;

public class CommentsPrinter {

    public void print(CommentsModel commentsModel) {
        System.out.println("==================================");
        for (CommentModel commentModel : commentsModel.getCommentModelList()) {
            System.out.println(commentModel.getUsername());
            System.out.println("");
            System.out.println(commentModel.getText());
            System.out.println("==================================");
        }
    }
}
