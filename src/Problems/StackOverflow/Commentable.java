package Problems.StackOverflow;

import java.util.List;

public interface Commentable {
    void addComment(Comment comment);

    List<Comment> getComments();
}
