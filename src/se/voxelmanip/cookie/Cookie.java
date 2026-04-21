package se.voxelmanip.cookie;

import se.voxelmanip.cookie.controllers.GameController;

import javax.swing.SwingUtilities;

/**
 * The main starting point for game.
 * @author ROllerozxa
 */
public final class Cookie {
    private Cookie() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main entry point of the program.
     * @param args Command arguments (unused).
     */
    public static void main(final String... args) {
        SwingUtilities.invokeLater(GameController::new);
    }
}
