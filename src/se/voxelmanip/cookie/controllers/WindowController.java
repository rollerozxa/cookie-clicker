package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.enums.ImageType;
import se.voxelmanip.cookie.enums.MessageType;
import se.voxelmanip.cookie.factories.MessageFactory;
import se.voxelmanip.cookie.models.FormatterModel;
import se.voxelmanip.cookie.models.FormatterSymbolModel;
import se.voxelmanip.cookie.models.ImageModel;
import se.voxelmanip.cookie.views.WindowView;

/**
 * Controller for the program window view
 * @author ROllerozxa
 */
public class WindowController {
    private final WindowView windowView;
    private final FormatterModel formatterModel;

    /**
     * Constructor method
     */
    public WindowController() {
        this.windowView = new WindowView(new ImageModel(ImageType.COOKIE_ICON_IMAGE).getImage());
        this.formatterModel = new FormatterModel(new FormatterSymbolModel().getSymbols());
    }

    /**
     * Show startup message
     * @param firstTime Whether there is an existing save that has been loaded from
     *                  (A different startup message is displayed in that case)
     * @param accumulatedCookies Amount of cookies that have been accumulated since last playtime
     */
    public void showStartupMessage(boolean firstTime, long accumulatedCookies) {
        MessageFactory messageFactory = new MessageFactory();

        if (!firstTime) {
            if (accumulatedCookies > 0L) {
                // Welcome back message when there have been cookies accumulated since last playtime
                String str = String.format(
                        messageFactory.produceMessage(MessageType.WELCOME_BACK_ACCUMULATED).getMessage(),
                        formatterModel.getFormatter().format(accumulatedCookies));

                windowView.showMessageBox(str);
            } else {
                // Show welcome back if it's not the player's first time playing
                windowView.showMessageBox(
                        messageFactory.produceMessage(MessageType.WELCOME_BACK).getMessage());
            }
        } else {
            // Show welcome if it's a new player
            windowView.showMessageBox(
                    messageFactory.produceMessage(MessageType.WELCOME).getMessage());
        }
    }

    /**
     * Get window view
     * @return Window virew
     */
    public WindowView getView() {
        return this.windowView;
    }
}
