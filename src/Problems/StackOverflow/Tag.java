package Problems.StackOverflow;

import java.util.UUID;

public class Tag {
    private final int id;
    private final String tag;

    public Tag(String tag) {
        this.id = generateId();
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
