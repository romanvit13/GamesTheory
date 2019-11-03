package utils;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import javax.swing.*;
import java.awt.*;

public enum XYChartUtils {

    INSTANCE;

    private XYChart chart;

    public void buildChart() {
        chart = new XYChartBuilder()
                .width(700)
                .height(500)
                .title("Chart")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();
    }

    public void addChartSeries(double[][] strategies) {
        double[] xData = new double[]{0, 1};
        for (int i = 0; i < strategies.length; i++) {
            chart.addSeries(Integer.toString(i), xData, new double[]{strategies[i][0], strategies[i][1]});
        }
    }

    public void displayChart() {
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Create and set up the window.
            JFrame frame = new JFrame();

            // chart
            JPanel chartPanel = new XChartPanel<>(chart);
            frame.add(chartPanel, BorderLayout.CENTER);

            // label
            JLabel label = new JLabel("Graphic method for decisions in the Games Theory", SwingConstants.CENTER);
            frame.add(label, BorderLayout.SOUTH);

            // Display the window.
            frame.pack();
            frame.setVisible(true);
        });
    }
}
