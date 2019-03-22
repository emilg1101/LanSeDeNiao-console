package lansedeniao.domain.entity;

import java.util.Date;

public class Post {

    private long id;
    private String text;
    private Date cdate;
    private int likesAmount;
    private long userId;
    private String username;

    public Post(long id, String text, Date cdate, int likesAmount, long userId, String username) {
        this.id = id;
        this.text = text;
        this.cdate = cdate;
        this.likesAmount = likesAmount;
        this.userId = userId;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCdate() {
        return cdate;
    }

    public int getLikesAmount() {
        return likesAmount;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
