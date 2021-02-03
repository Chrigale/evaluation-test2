package com.pckt.cookbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsUtilsArrayStreamsTest {

    private StatisticsUtilsArrayStreams calculator;

    @BeforeEach
    public void setUpBeforeClass(){
        this.calculator = new StatisticsUtilsArrayStreams();
    }

    @ParameterizedTest
    @MethodSource
    public void testMax(double[] input, double expected) {
        assertEquals(expected, calculator.getMax(input));
    }

    static Stream<Arguments> testMax() {

        return Stream.of(
                Arguments.of(new double[] {1.38, 2.56, 4.3}, 4.3),
                Arguments.of(new double[] {1.38, 2.56, 4.0}, 4.0),
                Arguments.of(new double[]  {-1.0, -4.0, -1.0}, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMin(double[] input, double expected) {
        assertEquals(expected, calculator.getMin(input));
    }

    static Stream<Arguments> testMin() {

        return Stream.of(
                Arguments.of(new double[]  {1.38, 2.56, 4.3}, 1.38),
                Arguments.of(new double[]  {5.0, 8.0, -5.0}, -5.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMean(double[] input, double expected) {
        assertEquals(expected, calculator.getMean(input));
    }

    static Stream<Arguments> testMean() {

        return Stream.of(
                Arguments.of(new double[] {9.0, 10.0, 12.0, 13.0, 13.0}, 11.4),
                Arguments.of(new double[] {0.0, 0.0, 0.0}, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMedian(double[] input, double expected) {
        assertEquals(expected, calculator.getMedian(input));
    }

    static Stream<Arguments> testMedian() {

        return Stream.of(
                Arguments.of(new double[] {9.0, 10.0, 12.0, 13.0, 13.0}, 12.0),
                Arguments.of(new double[] {0.0, 0.0, 0.0}, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testStandardDeviation(double[] input, double expected) { assertEquals(expected, calculator.getStandardDeviation(input)); }


    static Stream<Arguments> testStandardDeviation() {

        return Stream.of(
                Arguments.of(new double[] {10.0, 12.0, 23.0, 23.0}, 6.97614984548545)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testMaxForNullAndEmptyArrays(double[] input) {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMax(input),
                        "didn't throw an exception in getMax method in StatisticsUtilsArrayStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMin(input),
                        "didn't throw an exception in getMin method in StatisticsUtilsArrayStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an exception in getMean method in StatisticsUtilsArrayStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMedian(input),
                        "didn't throw an exception in getMedian method in StatisticsUtilsArrayStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an exception in getStandardDeviation method in StatisticsUtilsArrayStreams class!")
        );

    }


    @ParameterizedTest
    @MethodSource
    public void testInfinityExceptions(double[] input) {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an infinity exception in getMean method in StatisticsUtilsArrayStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an infinity exception in getStandardDeviation method in StatisticsUtilsArrayStreams class!")
        );

    }

    static Stream<Arguments> testInfinityExceptions() {

        return Stream.of(
                Arguments.of(new double[] {1.38,POSITIVE_INFINITY, 4.3}),
                Arguments.of(new double[] {1.38, NEGATIVE_INFINITY, 4.3})
        );
    }



}