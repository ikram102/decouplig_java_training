package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    public Logger logger = LoggerFactory.getLogger("computer");
    public long randomNumber;
    public int low = 0;
    public int up = 100;
    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        randomNumber = random.nextInt(low, up);
        logger.log("Le numéro de l'ordinateur : " + randomNumber);
        return randomNumber;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            logger.log("Le numéro de l'ordinateur est inférieur au numéro à trouver");
            low = (int) randomNumber;
        } else {
            logger.log("Le numéro de l'ordinateur est supérieur au numéro à trouver.");
            up = (int) randomNumber;
        }
    }
}
