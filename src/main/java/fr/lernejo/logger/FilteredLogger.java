
package fr.lernejo.logger;
import java.util.function.Predicate;
public class FilteredLogger implements Logger {
    private final Predicate<String> condition;
    private final Logger logger;
    public FilteredLogger(Logger logger, Predicate<String> condition) {
        this.condition = condition;
        this.logger = logger;
    }
    @Override
    public void log(String message) {
        if (condition.test(message))
            logger.log(message);
    }
}
