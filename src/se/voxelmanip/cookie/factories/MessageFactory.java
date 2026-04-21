package se.voxelmanip.cookie.factories;

import se.voxelmanip.cookie.enums.MessageType;
import se.voxelmanip.cookie.interfaces.MessageInterface;
import se.voxelmanip.cookie.util.messages.WelcomeBackAccumulatedMessage;
import se.voxelmanip.cookie.util.messages.WelcomeBackMessage;
import se.voxelmanip.cookie.util.messages.WelcomeMessage;

/**
 * Factory class for generating message objects (see MessageTypes enum for types)
 * @author ROllerozxa
 */
public class MessageFactory {
    /**
     * Produce a message object of given type
     * @param type Message type
     * @return Message object
     */
    public MessageInterface produceMessage(MessageType type) {
        return switch (type) {
            case WELCOME -> new WelcomeMessage();
            case WELCOME_BACK -> new WelcomeBackMessage();
            case WELCOME_BACK_ACCUMULATED -> new WelcomeBackAccumulatedMessage();
            case WIN -> throw new RuntimeException("Unimplemented");
        };
    }
}
