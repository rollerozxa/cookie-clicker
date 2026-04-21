package se.voxelmanip.cookie.util.images;

import se.voxelmanip.cookie.interfaces.ImageInterface;

/**
 * Full sized cookie image
 * @author ROllerozxa
 */
public class CookieImage extends AbstractImage implements ImageInterface {
    /**
     * Get filename of the image
     * @return Image filename
     */
    public String getImage() {
        return "cookie.png";
    }
}
