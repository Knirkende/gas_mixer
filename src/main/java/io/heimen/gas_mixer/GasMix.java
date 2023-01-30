package io.heimen.gas_mixer;


record GasParameter (
        double tankSize,
        double currentPressure,
        double currentOxygen,
        double currentHelium,
        double topMixOxygen,
        double targetOxygen,
        double targetHelium,
        double targetPressure
) {}

public class GasMix {
    private static GasParameter params;
    public GasMix(GasParameter params) {
        this.params = params;
    }

    // returns required additional helium in bar
    private double getHeliumPressure() {
        return ((params.targetHelium() / 100) * params.targetPressure()
                - (params.currentHelium() / 100) * params.currentPressure());
    }

    //returns required additional nitrogen in bar
    private double getTopMixPressure() {
        double targetNitrogenBar = (
                (100 - params.targetOxygen() - params.targetHelium()) / 100) * params.targetPressure();
        double currentNitrogenBar = (
                (100 - params.currentOxygen() - params.currentHelium()) / 100) * params.currentPressure();
        double missingNitrogenBar = targetNitrogenBar - currentNitrogenBar;
        return missingNitrogenBar / ((100 - params.topMixOxygen()) / 100);
    }
    // getMix returns int[] of length 3: topMix, helium, oxygen
    public int[] getMix() {
        int missingHelium = (int) Math.round(getHeliumPressure());
        int missingTopMix = (int) Math.round(getTopMixPressure());
        int missingOxygen = (int) params.targetPressure() - missingHelium - missingTopMix;
        int[] result = {missingTopMix, missingHelium, missingOxygen};
        return result;
    }
}
