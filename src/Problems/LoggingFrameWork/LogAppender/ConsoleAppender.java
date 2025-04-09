package Problems.LoggingFrameWork.LogAppender;

import Problems.LoggingFrameWork.LogMessage;

public class ConsoleAppender implements LogAppender {

    @Override
    public synchronized void append(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
