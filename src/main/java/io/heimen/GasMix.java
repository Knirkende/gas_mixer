package io.heimen;

/*
        'tankSize': 24,
        'currentPressure': 0,
        'currentOxygen': 21,
        'currentHelium': 35,
        'topMixOxygen': 21,
        'targetOxygen': 21,
        'targetHelium': 35,
        'targetPressure': 220
 */

record GasParameter (
        int tankSize,
        int currentPressure,
        int currentOxygen,
        int currentHelium,
        int topMixOxygen,
        int targetOxygen,
        int targetHelium,
        int targetPressure
) {}

public class GasMix {
    public GasMix(GasParameter params) {
    }

    // getMix returns int[] of length 3: topMix, helium, oxygen
    public int[] getMix() {
        int[] tempResult = {0, 0, 0};
        return tempResult;
    }
}
