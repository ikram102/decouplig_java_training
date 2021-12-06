package fr.lernejo.guessgame;
import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import java.security.SecureRandom;
public class Launcher {
    public static Simulation simulation;
    public static long maxLoop;
    //public static Logger logger = new ConsoleLogger();
    public static Logger logger = LoggerFactory.getLogger("launcher");
    public static void main(String[] args) {
        //Simulation simulation = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        //long randomNumber = random.nextLong();
        //long randomNumber = random.nextInt(100);
        long randomNumber = random.nextInt(100);
        if(args.length > 0 && args[0].equals("-interactive")) {
            simulation = new Simulation(new HumanPlayer());
            maxLoop = Long.MAX_VALUE;
            simulation.initialize(randomNumber);
        } else if (args.length > 1 && args[0].equals("-auto") && args[1].matches("-?\\d+(\\.\\d+)?")) {
            maxLoop = 1000;
            simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(Integer.parseInt(args[1]));
        } else {
            logger.log("il faut entrer l'argument pour jouer :\n - pour jouer, enter '-interactive'; \n - To let the computer play, enter '-auto' and a positiv number that it will try to find.");
            System.exit(-1);
        }
        logger.log("le membre est compris entre .");
        simulation.loopUntilPlayerSucceed(maxLoop);
    }
}
