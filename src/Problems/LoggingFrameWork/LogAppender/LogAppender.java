package Problems.LoggingFrameWork.LogAppender;

import Problems.LoggingFrameWork.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
