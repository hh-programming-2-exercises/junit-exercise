package price.formatter;

import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {

    /**
     * Format the price to a string with the following format: 123 456,78 €.
     *
     * A space is used as thousand separator and a comma as decimal separator.
     * The decimal part must be rounded to two digits, unless the decimal part is 0,
     * in which case it is omitted. The currency symbol € is added at the end of the
     * string.
     *
     * @param price the price to format, as a double
     * @return the formatted price as a string
     */
    public String formatPrice(double price) {
        // This method is expected to work correctly and you SHOULD NOT MODIFY IT.
        // Instead, write unit tests that verify the correctness of this method.
        // When checking your submission, we will inject bugs into this method and
        // see if your tests can detect them.

        // See discussion about this solution at https://stackoverflow.com/a/5054217
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        return formatter
                .format(price)
                .replace(",00", "")
                .replace(".", " ")
                + " €";
    }
}
