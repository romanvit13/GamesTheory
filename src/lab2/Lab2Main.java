package lab2;


import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

class Lab2Main {
    public static void main(String[] args) {
        int[][] strategies = new int[][]{
                {2, 4, -1, 6},
                {3, 5, 1, 2},
                {7, 3, 2, -2},
                {4, 1, 2, 3},
        };
        int stepsAmount = 20;

        Lab2GameModel gameModel = new Lab2GameModel(strategies, stepsAmount);

        double[] prices = gameModel.calculatePrices();
        drawChart(prices, stepsAmount);
    }

    private static void drawChart(double[] array, int stepsAmount) {
        double[] xData = new double[array.length];
        double[] yData = new double[array.length];

        for (int i = 0; i < stepsAmount; i++) {
            xData[i] = i + 1;
            yData[i] = array[i];
        }

        XYChart chart = QuickChart.getChart("Chart", "X", "Y", "y(x)", xData, yData);
        new SwingWrapper<>(chart).displayChart();
    }
}
