package io.heimen.gas_mixer;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        int[] expected = {95, 59, 16};
        int[] actual = gas.getMix();
        Assert.assertArrayEquals(expected, actual);
    }

}