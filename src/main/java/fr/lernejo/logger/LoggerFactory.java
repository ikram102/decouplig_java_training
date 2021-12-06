package fr.lernejo.logger;
import java.util.function.Predicate;
public class LoggerFactory {
    public static Logger getLogger(String name) {
        //return new ContextualLogger(new ConsoleLogger(), name);
        //return new CompositeLogger(new ContextualLogger(new FileLogger("fileLog"), name), new ContextualLogger(new ConsoleLogger(), name));
        Predicate<String> condition = message -> message.contains("simulation");
        return new CompositeLogger(new ContextualLogger(name, new FilteredLogger(new FileLogger("fileLog"), condition)), new ContextualLogger(name, new ConsoleLogger()));
    }

}

