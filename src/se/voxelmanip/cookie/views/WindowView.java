package se.voxelmanip.cookie.views;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.net.URL;

/**
 * Window view that creates a Swing frame window.
 * @author ROllerozxa
 */
public class WindowView extends JFrame {
    /**
     * Constructor method for Window view
     * @param cookieImage Image to be used as the window icon
     */
    public WindowView(URL cookieImage) {
        setLayout(new BorderLayout());
        setSize(1000, 420);
        setResizable(false);
        setVisible(true);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setTitle("Cookie Clicker");

        // Set icon to the cookie
        var iconImage = new ImageIcon(cookieImage);
        setIconImage(iconImage.getImage());

        // We handle exit ourselves, saving first
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * Show a message box
     * @param message Message to show in the box
     */
    public void showMessageBox(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
