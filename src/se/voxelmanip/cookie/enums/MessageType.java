package se.voxelmanip.cookie.enums;

/**
 * Enum for different message types that can be produced with the MessageFactory
 * @author ROllerozxa
 */
public enum MessageType {
    /**
     * Welcome message
     */
    WELCOME,

    /**
     * Welcome back message
     */
    WELCOME_BACK,

    /**
     * Welcome back message, with placeholder for displaying accumulated cookies
     */
    WELCOME_BACK_ACCUMULATED,

    /**
     * Win message
     */
    WIN
}
