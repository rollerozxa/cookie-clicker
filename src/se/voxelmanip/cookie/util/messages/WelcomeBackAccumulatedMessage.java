package se.voxelmanip.cookie.util.messages;

import se.voxelmanip.cookie.interfaces.MessageInterface;

/**
 * Welcome back message for returning players when an amount of cookies have been accumulated.
 * @author ROllerozxa
 */
public class WelcomeBackAccumulatedMessage implements MessageInterface {
    /**
     * Get the message string
     * @return Message string
     */
    public String getMessage() {
        return """
                Welcome back to Cookie Clicker.

                While you were away, your autoclickers have generated a grand total of
                %s cookies.""";
    }
}
