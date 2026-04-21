package se.voxelmanip.cookie.util.messages;

import se.voxelmanip.cookie.interfaces.MessageInterface;

/**
 * Message for welcoming regular players.
 * @author ROllerozxa
 */
public class WelcomeBackMessage implements MessageInterface {
    /**
     * Get the message string
     * @return Message string
     */
    public String getMessage() {
        return """
                Welcome back to Cookie Clicker.

                You continue with the amount of cookies you had during
                the previous session.""";
    }
}
