package se.voxelmanip.cookie.util.messages;

import se.voxelmanip.cookie.interfaces.MessageInterface;

/**
 * Message for welcoming new players
 * @author ROllerozxa
 */
public class WelcomeMessage implements MessageInterface {
    /**
     * Get the message string
     * @return Message string
     */
    public String getMessage() {
        return """
                Cookie clicker is an idle game with a simple premise - Click the cookie.
                When you have enough cookies, you can buy autoclickers which will click for
                you, one cookie per second for each autoclicker.

                Can you collect enough cookies to break the fabric of reality?
                (read: the 64-bit integer limit)""";
    }
}
