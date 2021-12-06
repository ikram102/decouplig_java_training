package fr.lernejo.logger;
public class LoggerFactory {
    public static Logger getLogger(String name) {
        //return new ContextualLogger(new ConsoleLogger(), name);

        return new CompositeLogger(new ContextualLogger(new FileLogger("fileLog"), name), new ContextualLogger(new ConsoleLogger(), name));
    }
}
