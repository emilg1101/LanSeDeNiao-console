package lansedeniao.data.dao.provider;

import lansedeniao.data.dao.CommentDao;
import lansedeniao.data.dao.LikeDao;
import lansedeniao.data.dao.PostDao;
import lansedeniao.data.dao.UserDao;
import lansedeniao.data.dao.db.CommentDaoImpl;
import lansedeniao.data.dao.db.LikeDaoImpl;
import lansedeniao.data.dao.db.PostDaoImpl;
import lansedeniao.data.dao.db.UserDaoImpl;

public class DaoProvider {

    public static UserDao provideUserDao() {
        return new UserDaoImpl();
    }

    public static PostDao providePostDao() {
        return new PostDaoImpl();
    }

    public static LikeDao provideLikeDao() {
        return new LikeDaoImpl();
    }

    public static CommentDao provideCommentDao() {
        return new CommentDaoImpl();
    }
}
