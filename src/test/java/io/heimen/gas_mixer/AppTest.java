package io.heimen.gas_mixer;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for gas mixer app.
 */
class GasMixTests {

    @Test
    @DisplayName("21/35, empty cylinder = {123, 77, 20}")
    void calculatesStandardGasEmptyCylinder() {
        GasParameter params = new GasParameter(
                24,
                0,
                21,
                35,
                21,
                21,
                35,
                220
        );
        GasMix gas = new GasMix(params);
        int[] expected = {123, 77, 20};
        int[] actual = gas.getMix();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("21/35, mix already correct = {0, 0, 0}")
    void calculatesStandardGasNoneNeeded() {
        GasParameter params = new GasParameter(
                24,
                100,
                21,
                35,
                21,
                21,
                35,
                100
        );
        GasMix gas = new GasMix(params);
        int[] expected = {0, 0, 0};
        int[] actual = gas.getMix();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("21/35, non-empty cylinder = {95, 59, 16}")
    void calculatesStandardGasNonEmptyCylinder() {
        GasParameter params = new GasParameter(
                24,
                50,
                21,
                35,
                21,
                21,
                35,
                220
        );
        GasMix gas = new GasMix(params);
        int[] expected = {95, 60, 65};
        int[] actual = gas.getMix();
        Assertions.assertArrayEquals(expected, actual);
    }
}

class ValidatorTests {
    static Validator validator;
    @BeforeAll
    public static void init() {
        validator = new Validator();
    }

    @Test
    void verifyFormatValidation() {
        Assertions.assertFalse(validator.validateFormat("a"));
        Assertions.assertFalse(validator.validateFormat(" "));
        Assertions.assertFalse(validator.validateFormat("&"));
        Assertions.assertFalse(validator.validateFormat("x"));
        Assertions.assertFalse(validator.validateFormat("-1"));
        Assertions.assertFalse(validator.validateFormat("2.2"));
        Assertions.assertTrue(validator.validateFormat("1"));
        Assertions.assertTrue(validator.validateFormat("0"));
        Assertions.assertTrue(validator.validateFormat("02"));
    }

    @Test
    void verifyNonZeroValidator() {
        Assertions.assertFalse(validator.validateFormatNonZero("0"));
        Assertions.assertTrue(validator.validateFormat("1"));
    }

    @Test
    void verifySumIsValidPercentage() {
        Assertions.assertFalse(validator.validatePercentage("99", "2"));
        Assertions.assertTrue(validator.validatePercentage("99", "1"));
        Assertions.assertTrue(validator.validatePercentage("0", "1"));
        Assertions.assertTrue(validator.validatePercentage("0", "0"));
    }
}
