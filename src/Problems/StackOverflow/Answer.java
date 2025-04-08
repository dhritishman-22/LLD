package Problems.StackOverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable {
    private final int id;
    private final String answer;
    private final User user;
    private final Question question;
    private boolean isAccepted;
    private final Date createdAt;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(User user, Question question, String answer) {
        this.id = generateId();
        this.user = user;
        this.question = question;
        this.answer = answer;
        this.createdAt = new Date();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.isAccepted = false;
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
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("Answer already accepted");
        }
        isAccepted = true;
        user.updateReputation(15);
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public User getUser() {
        return user;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
