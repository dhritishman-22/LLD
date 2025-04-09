package Problems.LoggingFrameWork;

public class LogMessage {
    private final LogLevel level;
    private final long timestamp;
    private final String message;

    public LogMessage(LogLevel logLevel, String message) {
        this.level = logLevel;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public LogLevel getLevel() {
        return level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[" + level + "] " + timestamp + " - " + message;
    }
}
