package se.voxelmanip.cookie.controllers;

import se.voxelmanip.cookie.enums.ImageType;
import se.voxelmanip.cookie.models.ClickUpgradeModel;
import se.voxelmanip.cookie.models.CookiePoolModel;
import se.voxelmanip.cookie.models.ImageModel;
import se.voxelmanip.cookie.views.CookieView;

/**
 * Controller class used for controlling the clicking of the cookie image button
 * @author ROllerozxa
 */
public class CookieController {
    private final CookieView cookieView;

    /**
     * Constructor method
     * @param cookiePoolModel Cookie pool model
     * @param clickUpgradeModel Click upgrade model
     * @param updateView Callback for updating a view
     */
    public CookieController(CookiePoolModel cookiePoolModel, ClickUpgradeModel clickUpgradeModel, Runnable updateView) {
        this.cookieView = new CookieView(new ImageModel(ImageType.COOKIE_IMAGE).getImage());

        cookieView.addActionListener(e -> {
            // When the cookie is clicked, produce a cookie.
            cookiePoolModel.increment();
            // Also add however many click upgrades we have
            cookiePoolModel.add(clickUpgradeModel.get());
            updateView.run();
        });
    }

    /**
     * Get cookie view
     * @return Cookie view
     */
    public CookieView getCookieView() {
        return cookieView;
    }
}
