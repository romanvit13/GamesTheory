package lab1;

import utils.ArrayUtils;

class Lab1Main {

    public static void main(String[] args) {
        final int[][] strategies = new int[][]{
                {2, 4, -1, 6},
                {3, 5, 1, 2},
                {7, 3, 2, -2},
                {4, 1, 1, 3},
        };
        ArrayUtils utils = ArrayUtils.INSTANCE;

        Lab1GameModel gameModel = new Lab1GameModel(strategies);
        int maxiMin = gameModel.getMaxiMin().getPrice();
        int miniMax = gameModel.getMiniMax().getPrice();

        System.out.println("Maxi min price: " + maxiMin);
        System.out.println("Mini max price: " + miniMax);

        utils.printArray(gameModel.getMaxiMinStrategy(), "Maxi min strategy: ");
        utils.printArray(gameModel.getMiniMaxStrategy(), "Mini max strategy: ");

        System.out.println("\n" + gameModel.getSaddlePoint());
    }
}
