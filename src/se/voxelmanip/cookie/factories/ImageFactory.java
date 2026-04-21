package se.voxelmanip.cookie.factories;

import se.voxelmanip.cookie.interfaces.ImageInterface;
import se.voxelmanip.cookie.util.images.CookieIconImage;
import se.voxelmanip.cookie.util.images.CookieImage;

import se.voxelmanip.cookie.enums.ImageType;

/**
 * Image factory class for producing instances of different types of images
 * @author ROllerozxa
 */
public class ImageFactory {

    /**
     * Produce an image instance
     * @param type Type of image
     * @return Image object
     */
    public ImageInterface produceImage(ImageType type) {
        return switch (type) {
            case COOKIE_IMAGE -> new CookieImage();
            case COOKIE_ICON_IMAGE -> new CookieIconImage();
        };
    }
}
