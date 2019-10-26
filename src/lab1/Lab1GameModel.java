package lab1;

import utils.ArrayUtils;

class Lab1GameModel {
    private final int[][] strategies;
    private final ArrayUtils utils;

    Lab1GameModel(int[][] strategies) {
        this.strategies = strategies;
        utils = ArrayUtils.INSTANCE;
    }

    PriceIndex getMaxiMin() {
        PriceIndex max = new PriceIndex(0, 0);
        for (int i = 0; i < strategies.length; i++) {
            PriceIndex min = new PriceIndex(i, strategies[i][0]);
            for (int j = 1; j < strategies[i].length; j++) {
                if (strategies[i][j] < min.getPrice()) {
                    min.setIndex(i);
                    min.setPrice(strategies[i][j]);
                }
            }
            if (min.getPrice() > max.getPrice()) {
                max = min;
            }
        }
        return max;
    }


    PriceIndex getMiniMax() {
        PriceIndex min = new PriceIndex(0, 0);
        for (int j = 0; j < strategies.length; j++) {
            PriceIndex max = new PriceIndex(0, 0);
            for (int i = 0; i < strategies[j].length; i++) {
                if (strategies[i][j] > max.getPrice()) {
                    max.setIndex(j);
                    max.setPrice(strategies[i][j]);
                }
            }
            if (j == 0) {
                min = max;
            } else if (max.getPrice() < min.getPrice()) {
                min = max;
            }
        }
        return min;
    }

    int[] getMaxiMinStrategy() {
        return strategies[getMaxiMin().getIndex()];
    }

    int[] getMiniMaxStrategy() {
        return utils.getArrayFromColumn(getMiniMax().getIndex(), strategies);
    }

    String getSaddlePoint() {
        return getMaxiMin().getPrice() == getMiniMax().getPrice() ? "\nSaddle point: " + getMaxiMin().getPrice() :
                "It is no saddle point has been found.";
    }
}
