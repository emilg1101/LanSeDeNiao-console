package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.CommentsModel;

public interface CommentsView extends View {

    void getComments(CommentsModel commentsModel);

    void postExistError();
}
