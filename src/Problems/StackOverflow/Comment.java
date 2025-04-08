package Problems.StackOverflow;

import java.util.Date;

public class Comment {
    private final int id;
    private final String comment;
    private final User user;
    private final Date createdAt;

    public Comment(User user, String comment) {
        this.id = generateId();
        this.user = user;
        this.comment = comment;
        this.createdAt = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
