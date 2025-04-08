package Problems.StackOverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Votable {
    private final int id;
    private final String title;
    private final String description;
    private final User user;
    private final Date createdAt;
    private final List<Comment> comments;
    private final List<Answer> answers;
    private final List<Vote> votes;
    private final List<Tag> tags;

    public Question(String title, String description, User user, List<String> tags) {
        this.id = generateId();
        this.title = title;
        this.description = description;
        this.user = user;
        this.createdAt = new Date();
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for (String tag : tags) {
            this.tags.add(new Tag(tag));
        }
    }

    public void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(Vote vote) {
        if (vote.getValue() != 1 && vote.getValue() != -1) {
            throw new IllegalArgumentException("Vote should be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(vote.getUser()));
        votes.add(vote);
        user.updateReputation(vote.getValue() * -5);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
