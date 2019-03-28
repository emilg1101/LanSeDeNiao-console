package lansedeniao.presentation.model;

import java.util.ArrayList;
import java.util.List;

public class CommentsModel {

    List<CommentModel> commentModelList;

    public CommentsModel(List<CommentModel> commentModels)
    {
        this.commentModelList = commentModels;
    }

    public List<CommentModel> getCommentModelList() {
        return commentModelList;
    }
}
