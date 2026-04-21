package se.voxelmanip.cookie.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Main view for the game contents
 * @author ROllerozxa
 */
public class GameView extends JPanel {
    private final JLabel gameStatusLabel;
    private final DecimalFormat formatter;

    /**
     * Constructor method
     * @param formatter Formatter object for number formatting
     */
    public GameView(DecimalFormat formatter) {
        this.gameStatusLabel = new JLabel("");
        this.formatter = formatter;
    }

    /**
     * Get the string for the game status label
     * @param cookies Amount of cookies
     * @param cookiesAllTime Amount of cookies for all time
     * @param autoclickers Amount of autoclickers
     * @param clickUpgrades Amount of click upgrades
     */
    private String getGameStatusString(long cookies, long cookiesAllTime, long autoclickers, long clickUpgrades) {
        return String.format("Cookies: %s (%s all time, %s c/sec)", formatter.format(cookies), formatter.format(cookiesAllTime), formatter.format(autoclickers));
    }

    /**
     * Set the top-left label showing the current game status
     * @param cookies Amount of cookies
     * @param cookiesAllTime Amount of cookies for all time
     * @param autoclickers Amount of autoclickers
     * @param clickUpgrades Amount of click upgrades
     */
    public void setGameStatus(long cookies, long cookiesAllTime, long autoclickers, long clickUpgrades) {
        gameStatusLabel.setText(getGameStatusString(cookies, cookiesAllTime, autoclickers, clickUpgrades));
    }

    /**
     * Construct the store panel
     * @param label Top label for store panel
     * @param btns Buttons to populate it with
     * @return Constructed store panel
     */
    public JPanel constructStorePanel(String label, List<JButton> btns) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Fill out button widths in the gridbag
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Store label gets Y=0 in the grid
        gbc.gridy = 0;
        panel.add(new JLabel(label), gbc);

        int i = 1;
        for (JButton component : btns) {
            // Then increment the Y for each button to be added
            gbc.gridy = i++;
            panel.add(component, gbc);
        }

        return panel;
    }

    /**
     * Construct a panel consisting of multiple store panels flowing horizontally
     * @param panels List of panel objects
     * @return One panel containing all passed panels inside of it
     */
    public JPanel constructStorePanels(List<JPanel> panels) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        int i = 0;
        for (JPanel component : panels) {
            // Then increment the X for each panel to be added
            gbc.gridx = i++;
            panel.add(component, gbc);
        }

        return panel;
    }

    /**
     * Construct a layout when given a JPanel window and some separate UI elements
     * @param window Window object to put the layout inside of
     * @param cookieButton Cookie button to be clicked
     * @param autoclickerBtns List of autoclicker purchase buttons to be put in the store panel
     * @param clickUpgradeBtns List of click upgrade buttons to be put in the store panel
     */
    public void constructLayout(JFrame window, JButton cookieButton, List<JButton> autoclickerBtns, List<JButton> clickUpgradeBtns) {
        window.add(this);
        window.setVisible(true);

        setLayout(new BorderLayout());

        // Top row for game status label, starting from top-left corner
        add(gameStatusLabel, BorderLayout.NORTH);

        // Cookie button in left column
        add(cookieButton, BorderLayout.CENTER);

        // Autoclicker store in right column
        JPanel autoclickerStore = constructStorePanel("Autoclicker Store:", autoclickerBtns);

        JPanel clickUpgradeStore = constructStorePanel("Click Upgrade Store:", clickUpgradeBtns);

        JPanel storePanel = constructStorePanels(Arrays.asList(autoclickerStore, clickUpgradeStore));

        add(storePanel, BorderLayout.EAST);
    }
}
