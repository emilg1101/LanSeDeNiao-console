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

    public PostModel(String username, String postName, String text, Date cdate, int countLikes, int countComments) {
        this.username = username;
        this.postName = postName;
        this.text = text;
        this.cdate = cdate;
        this.countLikes = countLikes;
        this.countComments = countComments;
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

    public static PostModel mapper(Post from) {
        return new PostModel(from.getUsername(), "", from.getText(), from.getCdate(), from.getLikesAmount(), 0);
    }

}
