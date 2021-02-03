package com.pckt.cookbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticUtilsArrayListTest {

    private StatisticUtilsArrayList calculator;

    @BeforeEach
    void setUpBeforeClass(){
        calculator = new StatisticUtilsArrayList();
    }

    @ParameterizedTest
    @MethodSource
    public void testMax(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMax(input));
    }

    static Stream<Arguments> testMax() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 4.3),
                Arguments.of( Arrays.asList(1.38, 2.56, 4.0), 4.0),
                Arguments.of( Arrays.asList(-1.0, -4.0, -1.0), -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMin(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMin(input));
    }

    static Stream<Arguments> testMin() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 1.38),
                Arguments.of( Arrays.asList(5.0, 8.0, -5.0), -5.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMean(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMean(input));
    }

    static Stream<Arguments> testMean() {

        return Stream.of(
                Arguments.of( Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 11.4),
                Arguments.of( Arrays.asList(0.0, 0.0, 0.0), 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMedian(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMedian(input));
    }

    static Stream<Arguments> testMedian() {

        return Stream.of(
                Arguments.of( Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 12.0),
                Arguments.of( Arrays.asList(0.0, 0.0, 0.0), 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testStandardDeviation(List<Double> input, double expected) {
        assertEquals(expected, calculator.getStandardDeviation(input));
    }

    static Stream<Arguments> testStandardDeviation() {

        return Stream.of(
                Arguments.of( Arrays.asList(10.0, 12.0, 23.0, 23.0), 6.97614984548545)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testForNullAndEmptyArrays(List<Double> input) {
        assertAll(

                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMax(input),
                        "didn't throw an exception in getMax method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMin(input),
                        "didn't throw an exception in getMin method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMedian(input),
                        "didn't throw an exception in getMedian method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an exception in getStandardDeviation method in StatisticUtilsArrayList class!")

        );

    }


    @ParameterizedTest
    @MethodSource
    public void testInfinityExceptions(List<Double> input) {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an infinity exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an infinity exception in getStandardDeviation method in StatisticUtilsArrayList class!")
        );

    }

    static Stream<Arguments> testInfinityExceptions() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38,POSITIVE_INFINITY, 4.3)),
                Arguments.of( Arrays.asList(1.38, NEGATIVE_INFINITY, 4.3))
        );
    }




}