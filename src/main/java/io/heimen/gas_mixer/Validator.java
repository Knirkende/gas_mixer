package io.heimen.gas_mixer;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.NumberFormat;

public class Validator {
    protected String FORMAT_ERROR = "Enter a non-negative integer.";
    protected String FORMAT_ERROR_NON_ZERO = "Enter an integer greater than zero.";
    protected String PERCENTAGE_ERROR = "Gases in mix exceed 100%.";
    private boolean errorState = false;

    public void setErrorState(boolean s) {
        this.errorState = s;
    }

    public boolean getErrorState() {
        return this.errorState;
    }

    public boolean validateFormat(String inp) {
        try {
            Integer.parseInt(inp);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return Integer.parseInt(inp) >= 0;
    }

    public boolean validateFormatNonZero(String inp) {
        return validateFormat(inp) && (Integer.parseInt(inp) > 0);
    }

    public boolean validatePercentage(String one, String two) {
        return validateFormat(one)
                && validateFormat(two)
                && (Integer.parseInt(one) + Integer.parseInt(two) <= 100);
    }

}