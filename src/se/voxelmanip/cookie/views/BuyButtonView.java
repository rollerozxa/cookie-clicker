package se.voxelmanip.cookie.views;

import se.voxelmanip.cookie.interfaces.StoreInterface;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.text.DecimalFormat;

/**
 * View class representing a button for which a player can purchase a given amount of an item in the store
 * @author ROllerozxa
 */
public class BuyButtonView extends JButton {
    private final DecimalFormat formatter;

    /**
     * Constructor method
     * @param info Information about the button that should be put in the button text label
     * @param formatter Formatter object for formatting numbers
     */
    public BuyButtonView(StoreInterface info, DecimalFormat formatter) {
        this.formatter = formatter;

        initText(info);
    }

    /**
     * Construct a text string from item information
     * @param info Store item info
     * @return Label string
     */
    private String constructText(StoreInterface info) {
        return String.format("Buy %s (%s cookies)", formatter.format(info.getAmount()), formatter.format(info.getTotalCost()));
    }

    /**
     * Initialise the button text
     * @param info Store item info
     */
    private void initText(StoreInterface info) {
        setText(constructText(info));
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
