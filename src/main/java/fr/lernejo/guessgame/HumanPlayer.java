package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    public Logger logger = LoggerFactory.getLogger("player");
    public Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            logger.log("votre chiffre est inférieur par rapport au chiffre demandé .");
        } else {
            logger.log("votre chiffre est supérieur par rapport au chiffre demandé.");
        }
    }
}



