package se.voxelmanip.cookie.views;

import java.awt.Image;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * View for the clickable button with a cookie image on it
 * @author ROllerozxa
 */
public class CookieView extends JButton {

    /**
     * Constructor method
     * @param cookieImage Image to be used for the cookie image
     */
    public CookieView(URL cookieImage) {
        int cookieHeight = 200;
        int cookieWidth = 200;

        try {
            ImageIcon cookieIcon = new ImageIcon(cookieImage);
            Image scaledImage = cookieIcon.getImage().getScaledInstance(cookieWidth, cookieHeight, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setPreferredSize(new Dimension(cookieWidth, cookieHeight));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
