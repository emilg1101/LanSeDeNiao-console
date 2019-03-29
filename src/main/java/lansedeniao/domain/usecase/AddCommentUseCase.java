package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.Comment;
import lansedeniao.domain.exception.AddCommentException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

public class AddCommentUseCase {

    private PostRepository postRepository = RepositoryFactory.getPostRepository();
    private UserRepository userRepository = RepositoryFactory.getUserRepository();

    public Comment addComment(long postId, String text) throws UserNotLoggedInException, AddCommentException {
        if (!userRepository.hasLoggedInUser()) throw new UserNotLoggedInException();
        Comment comment = postRepository.addComment(
                postId,
                userRepository.getLoggedInUser().getId(),
                text
        );
        if (comment != null) {
            return comment;
        }
        throw new AddCommentException();
    }
}
