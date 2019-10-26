package lab3;

import utils.ChartUtils;

public class Lab3Main {
    public static void main(String[] args) {
        double[][] strategies = {
                {6, 5},
                {4, 6},
                {2, 7},
                {1, 8}
        };

        ChartUtils chartUtils = ChartUtils.INSTANCE;
        chartUtils.buildChart();
        chartUtils.addChartSeries(strategies);
        chartUtils.displayChart();
    }
}
