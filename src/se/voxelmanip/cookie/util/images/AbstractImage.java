package se.voxelmanip.cookie.util.images;

import se.voxelmanip.cookie.interfaces.ImageInterface;
import se.voxelmanip.cookie.models.ImageModel;

import java.net.URL;
import java.util.Objects;

/**
 * Abstract class for image which implements the image interface
 */
public abstract class AbstractImage implements ImageInterface {

    /**
     * Get the full path to the file as an URL
     * @return Image URL path object
     */
    public URL getImageURL() {
        return Objects.requireNonNull(ImageModel.class.getClassLoader().getResource(getImage()));
    }

    /**
     * Get filename of the image
     * @return Image filename
     */
    public abstract String getImage();
}
