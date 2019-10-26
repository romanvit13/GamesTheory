package lab2;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.OptionalInt;

class Lab2GameModel {

    private final int[][] strategies;
    private int[] rowStrSum;
    private int[] colStrSum;
    private final int stepsAmount;
    private final ArrayUtils utils;

    Lab2GameModel(int[][] strategies, int stepsAmount) {
        this.strategies = strategies;
        this.stepsAmount = stepsAmount;
        rowStrSum = new int[strategies.length];
        colStrSum = new int[strategies.length];
        utils = ArrayUtils.INSTANCE;
        utils.initArray(rowStrSum);
        utils.initArray(colStrSum);
    }

    double[] calculatePrices() {

        double[] prices = new double[stepsAmount];

        for (int k = 1; k <= stepsAmount; k++) {
            int i = getRandom(strategies.length);
            int j = getRandom(strategies.length);

            rowStrSum = utils.sumArrays(strategies[i], rowStrSum);
            utils.printArray(rowStrSum, "Row str sum: ");

            colStrSum = utils.sumArrays(utils.getArrayFromColumn(j, strategies), colStrSum);
            utils.printArray(rowStrSum, "Col str sum: ");

            OptionalInt optionalMin = Arrays.stream(rowStrSum).min();
            double min = optionalMin.isPresent() ? optionalMin.getAsInt() : 0;
            double vMin = min / k;

            OptionalInt optionalMax = Arrays.stream(colStrSum).max();
            double max = optionalMax.isPresent() ? optionalMax.getAsInt() : 0;
            double vMax = max / k;

            double v = (vMax - vMin) / 2;
            prices[k - 1] = v;
        }

        return prices;
    }

    private int getRandom(int scope) {
        return (int) (Math.random() * (scope - 1));
    }
}
