package se.voxelmanip.cookie.interfaces;

import java.net.URL;

/**
 * Interface implemented for images, providing a common interface for retrieving a file's name and full path as URL.
 * @author ROllerozxa
 */
public interface ImageInterface {

    /**
     * Get filename of the image
     * @return Image filename
     */
    String getImage();

    /**
     * Get the full path to the file as an URL
     * @return Image URL path object
     */
    URL getImageURL();
}
