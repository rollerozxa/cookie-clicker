package se.voxelmanip.cookie.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Entity providing a formatter object initialised with a given pattern and a provided formatter symbol object
 * @author ROllerozxa
 */
public class FormatterModel {
    private final DecimalFormat formatter;

    /**
     * Constructor method
     * @param symbols Decimal formatter symbols object
     */
    public FormatterModel(DecimalFormatSymbols symbols) {
        this.formatter = new DecimalFormat("#,###", symbols);
    }

    /**
     * Get decimal formatter object
     * @return Decimal formatter
     */
    public DecimalFormat getFormatter() {
        return formatter;
    }
}
