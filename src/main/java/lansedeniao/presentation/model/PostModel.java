package lansedeniao.presentation.model;

import lansedeniao.domain.entity.Post;

import java.util.Date;

public class PostModel {

    private String username;
    private String postName;
    private String text;
    private Date cdate;
    private int countLikes;
    private int countComments;
    private CommentsModel commentsModel;

    private PostModel(String username,
                      String postName,
                      String text,
                      Date cdate,
                      int countLikes,
                      int countComments,
                      CommentsModel commentsModel) {
        this.username = username;
        this.postName = postName;
        this.text = text;
        this.cdate = cdate;
        this.countLikes = countLikes;
        this.countComments = countComments;
        this.commentsModel = commentsModel;
    }

    public String getPostName() {
        return postName;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public Date getCdate() {
        return cdate;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public int getCountComments() {
        return countComments;
    }

    public CommentsModel getCommentsModel() {
        return commentsModel;
    }

    public static PostModel mapper(Post from) {
        return new PostModel(from.getUsername(),
                "",
                from.getText(),
                from.getCdate(),
                from.getLikesAmount(),
                from.getComments().size(),
                CommentsModel.mapper(from.getComments()));
    }
}
