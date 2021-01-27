package com.pckt.cookbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

@RunWith(Parameterized.class)
public class StatisticsUtilsArrayListStreamsTest {
    enum Type {MAX, MIN, EXCEPTION, MEAN, MEDIAN, STAND_DEV, INF_EXCEPTION}

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {StatisticsUtilsArrayListStreamsTest.Type.MAX, Arrays.asList(1.38, 2.56, 4.3), 4.3},
                {StatisticsUtilsArrayListStreamsTest.Type.MIN, Arrays.asList(1.38, 2.56, 4.3), 1.38},
                {StatisticsUtilsArrayListStreamsTest.Type.EXCEPTION, Collections.emptyList(), 1.38},
                {StatisticsUtilsArrayListStreamsTest.Type.MAX, Arrays.asList(-1.0, -4.0, -1.0), -1.0},
                {StatisticsUtilsArrayListStreamsTest.Type.MIN, Arrays.asList(5.0, 8.0, -5.0), -5.0},
                {StatisticsUtilsArrayListStreamsTest.Type.MEAN, Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 11.4},
                {StatisticsUtilsArrayListStreamsTest.Type.MEAN, Arrays.asList(0.0, 0.0, 0.0), 0.0},
                {StatisticsUtilsArrayListStreamsTest.Type.MEDIAN, Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 12.0},
                {StatisticsUtilsArrayListStreamsTest.Type.STAND_DEV, Arrays.asList(10.0, 12.0, 23.0, 23.0), 6.97614984548545},
                {StatisticsUtilsArrayListStreamsTest.Type.EXCEPTION, null, 12.0},
                {StatisticsUtilsArrayListStreamsTest.Type.INF_EXCEPTION, Arrays.asList(1.38, Double.POSITIVE_INFINITY, 4.3), 4.3},
                {StatisticsUtilsArrayListStreamsTest.Type.INF_EXCEPTION, Arrays.asList(1.38, Double.NEGATIVE_INFINITY, 4.3), 4.3}
        });
    }

    private final StatisticsUtilsArrayListStreams calculator;
    private final List<Double> array;
    private final double actual_value;
    private final StatisticsUtilsArrayListStreamsTest.Type type;

    public StatisticsUtilsArrayListStreamsTest(StatisticsUtilsArrayListStreamsTest.Type type, List<Double> array,
                                       double actual_value) {
        this.type = type;
        this.calculator = new StatisticsUtilsArrayListStreams();
        this.array = array;
        this.actual_value = actual_value;
    }

    @Test
    public void testMax() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.MAX == type);
        assertThat(calculator.getMax(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMin() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.MIN == type);
        assertThat(calculator.getMin(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMean() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.MEAN == type);
        assertThat(calculator.getMean(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMedian() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.MEDIAN == type);
        assertThat(calculator.getMedian(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testStandard_deviation() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.STAND_DEV == type);
        assertThat(calculator.getStandard_deviation(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testExceptions() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.EXCEPTION == type);
        try {
            calculator.getMax(array);
            fail("didn't throw an exception in getMax method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception  in getMax method in StatisticUtilsArrayList class");
        }
        try {
            calculator.getMin(array);
            fail("didn't throw an exception in getMin method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMin method in StatisticUtilsArrayList class");
        }
        try {
            calculator.getMedian(array);
            fail("didn't throw an exception in getMedian method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMedian method in StatisticUtilsArrayList class");
        }
        try {
            calculator.getMean(array);
            fail("didn't throw an exception in getMean method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMean method in StatisticUtilsArrayList class");
        }
        try {
            calculator.getStandard_deviation(array);
            fail("didn't throw an exception in getStandard_deviation method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getStandard_deviation method in StatisticUtilsArrayList class");
        }
    }

    @Test
    public void testInfinityExceptions() {
        assumeTrue(StatisticsUtilsArrayListStreamsTest.Type.INF_EXCEPTION == type);
        try {
            calculator.getMean(array);
            fail("didn't throw an infinity exception in getMean method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Infinity Exception  in getMean method in StatisticUtilsArrayList class");
        }
        try {
            calculator.getStandard_deviation(array);
            fail("didn't throw an infinity exception in getStandard_deviation method in StatisticUtilsArrayList class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Infinity Exception  in getStandard_deviation method in StatisticUtilsArrayList class");
        }
    }

}