package lansedeniao.presentation.model;

public class CommentModel {

    private long postId;
    private long commentId;
    private String username;
    private String text;

    public CommentModel(long postId, long commentId, String username, String text) {
        this.postId = postId;
        this.commentId = commentId;
        this.username = username;
        this.text = text;
    }

    public long getPostId() {
        return postId;
    }

    public long getCommentId() {
        return commentId;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }
}
