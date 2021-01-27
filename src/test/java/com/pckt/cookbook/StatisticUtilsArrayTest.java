package com.pckt.cookbook;

import org.junit.Assume;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class StatisticUtilsArrayTest {
    enum Type {MAX, MIN,EXCEPTION,MEAN,MEDIAN,STAND_DEV,INFEXCEPTION}
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.MAX,new double[] {1,4,1,6,3,5}, 6},
                {Type.MAX,new double[] {-1,-4,-1}, -1},
                {Type.MIN,new double[] {5,8,5}, 5},
                {Type.MIN,new double[] {5,8,-5}, -5},
                {Type.MEAN,new double[] {9,10,12,13,13}, 11.4},
                {Type.MEAN,new double[] {0,0,0}, 0},
                {Type.MEDIAN,new double[] {9,10,12,13,13}, 12},
                {Type.STAND_DEV,new double[] {10,12,23,23}, 6.97614984548545},
                {Type.EXCEPTION,null, 5},
                {Type.INFEXCEPTION,new double[] {10,12,Double.POSITIVE_INFINITY,23}, 5},
                {Type.INFEXCEPTION,new double[] {10,12,Double.NEGATIVE_INFINITY,23}, 5},
                {Type.EXCEPTION,new double[] {}, 5}
        });
    }

    private final StatisticUtilsArray calculator;
    private final double[] array;
    private final double actual_value;
    private final Type type;

    public StatisticUtilsArrayTest(Type type,double[] array,
                                   double actual_value){
        this.type = type;
        this.calculator = new StatisticUtilsArray();
        this.array = array;
        this.actual_value = actual_value;
    }

    @Test
    public void testMax() {
        assumeTrue(type == Type.MAX);
        assertThat(calculator.getMax(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMin() {
        assumeTrue(type == Type.MIN);
        assertThat(calculator.getMin(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMean() {
        assumeTrue(type == Type.MEAN);
        assertThat(calculator.getMean(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testMedian() {
        assumeTrue(type == Type.MEDIAN);
        assertThat(calculator.getMedian(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testStandard_deviation() {
        assumeTrue(type == Type.STAND_DEV);
        assertThat(calculator.getStandard_deviation(array)).isEqualByComparingTo(actual_value);
    }

    @Test
    public void testExceptions() {
        assumeTrue(type == Type.EXCEPTION);
        try {
            calculator.getMax(array);
            fail("didn't throw an exception in getMax method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception  in getMax method in StatisticUtilsArray class");
        }
        try {
            calculator.getMin(array);
            fail("didn't throw an exception in getMin method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMin method in StatisticUtilsArray class");
        }
        try {
            calculator.getMedian(array);
            fail("didn't throw an exception in getMedian method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMedian method in StatisticUtilsArray class");
        }
        try {
            calculator.getMean(array);
            fail("didn't throw an exception in getMean method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getMean method in StatisticUtilsArray class");
        }
        try {
            calculator.getStandard_deviation(array);
            fail("didn't throw an exception in getStandard_deviation method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception in getStandard_deviation method in StatisticUtilsArray class");
        }
    }

    @Test
    public void testInfinityExceptions() {
        assumeTrue(type == Type.INFEXCEPTION);
        try {
            calculator.getMean(array);
            fail("didn't throw an Infinity Exception in getMean method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Infinity Exception  in getMean method in StatisticUtilsArray class");
        }
        try {
            calculator.getStandard_deviation(array);
            fail("didn't throw an Infinity Exception in getStandard_deviation method in StatisticUtilsArray class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Infinity Exception  in getStandard_deviation method in StatisticUtilsArray class");
        }
    }
}
