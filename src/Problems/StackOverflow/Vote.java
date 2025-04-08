package Problems.StackOverflow;

public class Vote {
    private final User user;
    private final int value;

    public Vote(User user, int val) {
        this.user = user;
        this.value = val;
    }

    public User getUser() {
        return user;
    }

    public int getValue() {
        return value;
    }
}
