package es.ulpgc.dis.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import es.ulpgc.dis.model.PendulumData;

import javax.swing.*;
import java.util.List;

public class PendulumGraph {

    public static void plotPendulumData(PendulumData data) {
        XYSeries thetaSeries = createSeries(data.getTime(), data.getTheta(), "Theta (rad)");
        XYSeries omegaSeries = createSeries(data.getTime(), data.getOmega(), "Omega (rad/s)");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(thetaSeries);
        dataset.addSeries(omegaSeries);

        JFreeChart chart = createChart(dataset);
        displayChart(chart);
    }

    private static XYSeries createSeries(List<Double> time, List<Double> values, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        for (int i = 0; i < time.size(); i++) {
            series.add(time.get(i), values.get(i));
        }
        return series;
    }

    private static JFreeChart createChart(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Pendulum Simulation", "Time (s)", "Value", dataset);
        NumberAxis yAxis = (NumberAxis) chart.getXYPlot().getRangeAxis();
        yAxis.setAutoRangeIncludesZero(false);
        return chart;
    }

    private static void displayChart(JFreeChart chart) {
        JFrame frame = new JFrame("Pendulum Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}