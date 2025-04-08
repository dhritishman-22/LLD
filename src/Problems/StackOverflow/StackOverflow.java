package Problems.StackOverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<Integer, Tag> tags;

    public StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {
        int id = users.size() + 1;
        User user = new User(id, username, email);
        users.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String description, List<String> tags) {
        Question question = new Question(title, description, user, tags);
        questions.put(question.getId(), question);
        for (Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getId(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String answerContent) {
        Answer answer = new Answer(user, question, answerContent);
        answers.put(answer.getId(), answer);
        return answer;
    }

    // Delegation Pattern
    // This is classic delegation—System doesn’t perform the work itself; it passes it on to another class (User) that knows how to do it.
    public Comment addComment(User user, Commentable commentable, String comment) {
        return user.addComment(commentable, comment);
    }

    public void voteQuestion(User user, Question question, int value) {
        question.vote(new Vote(user, value));
    }

    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(new Vote(user, value));
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(question -> question.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        question.getDescription().toLowerCase().contains(query.toLowerCase()) ||
                        question.getTags().stream().anyMatch(tag -> tag.getTag().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }

}
