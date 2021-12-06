package fr.lernejo.logger;

public class LoggerFactory {
    private static final Logger baseLogger = new FileLogger("log.txt");
    public static Logger getLogger(String name) {
        //return new ConsoleLogger();
        return new ContextualLogger(baseLogger, name);
    }
}

