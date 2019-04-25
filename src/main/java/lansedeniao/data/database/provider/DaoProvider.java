package lansedeniao.data.database.provider;

import lansedeniao.data.database.dao.CommentDao;
import lansedeniao.data.database.dao.LikeDao;
import lansedeniao.data.database.dao.PostDao;
import lansedeniao.data.database.dao.UserDao;
import lansedeniao.data.database.jdbc.dao.CommentDaoImpl;
import lansedeniao.data.database.jdbc.dao.LikeDaoImpl;
import lansedeniao.data.database.jdbc.dao.PostDaoImpl;
import lansedeniao.data.database.jdbc.dao.UserDaoImpl;

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
