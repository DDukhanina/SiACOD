package ru.vsu.cs.siacod.gr12_2.dukhanina_d_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class Main {

    public static void main(String[] args) {
        List<Integer> sizes = new ArrayList<>();
        List<Integer> sizes1 = new ArrayList<>();
        List<Double> heapTimes = new ArrayList<>();
        List<Double> lazyTimes = new ArrayList<>();
        Random random = new Random();

        for (int i = 1000; i <= 9000; i += 1000) {
            sizes1.add(i);
            BinaryHeapPriorityQueue heapQueue1 = new BinaryHeapPriorityQueue();
            LinkedListPriorityQueue lazyQueue1 = new LinkedListPriorityQueue();

            for (int j = 0; j < i; j++) {
                int value = random.nextInt(1000);
                heapQueue1.insert(value, value);
                lazyQueue1.insert(value, value);
            }
        }

        for (int i = 1000; i <= 5000; i += 1000) {
            sizes.add(i);
            BinaryHeapPriorityQueue heapQueue = new BinaryHeapPriorityQueue();
            LinkedListPriorityQueue lazyQueue = new LinkedListPriorityQueue();

            for (int j = 0; j < i; j++) {
                int value = random.nextInt(1000);
                heapQueue.insert(value, value);
                lazyQueue.insert(value, value);
            }

            long startHeap = System.nanoTime();
            heapQueue.insert(10,10);
            long endHeap = System.nanoTime();
            heapTimes.add((double) (endHeap - startHeap) / 10000);

            long startLazy = System.nanoTime();
            lazyQueue.insert(10,10);
            long endLazy = System.nanoTime();
            lazyTimes.add((double) (endLazy - startLazy) / 1000000);
        }

        TimeSeries heapSeries = new TimeSeries("Heap Times");
        TimeSeries lazySeries = new TimeSeries("Lazy Times");

        for (int i = 1; i < sizes.size(); i++) {
            FixedMillisecond period = new FixedMillisecond(sizes.get(i));
            heapSeries.addOrUpdate(period, heapTimes.get(i));
            lazySeries.addOrUpdate(period, lazyTimes.get(i));
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(heapSeries);
        dataset.addSeries(lazySeries);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Time Series Chart Example",
                "Time",
                "Milliseconds",
                dataset,
                false,
                false,
                false
        );

        JFrame frame = new JFrame("Time Series Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);

        frame.setVisible(true);
    }
}