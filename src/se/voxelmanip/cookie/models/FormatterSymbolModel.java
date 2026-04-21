package se.voxelmanip.cookie.models;

import java.text.DecimalFormatSymbols;

/**
 * Model for creating a formatter symbols object with the appropriate configuration
 * @author ROllerozxa
 */
public class FormatterSymbolModel {
    private final DecimalFormatSymbols symbols;

    /**
     * Constructor method
     */
    public FormatterSymbolModel() {
        this.symbols = new DecimalFormatSymbols();
        applyGroupingSeparator();
    }

    /**
     * Set the grouping separator to use separators for the thousands separator
     */
    private void applyGroupingSeparator() {
        symbols.setGroupingSeparator(' ');
    }

    /**
     * Get the symbols format object
     * @return Format symbols object
     */
    public DecimalFormatSymbols getSymbols() {
        return symbols;
    }
}
