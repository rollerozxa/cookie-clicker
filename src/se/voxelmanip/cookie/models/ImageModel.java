package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.enums.ImageType;
import se.voxelmanip.cookie.factories.ImageFactory;

import java.net.URL;

/**
 * Model class which provides the URL for a cookie image.
 * @author ROllerozxa
 */
public class ImageModel {
    private final URL image;

    /**
     * Constructor for the image model class
     * @param imageType Type of image
     */
    public ImageModel(ImageType imageType) {
        this.image = new ImageFactory().produceImage(imageType).getImageURL();
    }

    /**
     * Get the cookie image as an URL
     * @return Cookie image URL
     */
    public URL getImage() {
        return this.image;
    }
}
