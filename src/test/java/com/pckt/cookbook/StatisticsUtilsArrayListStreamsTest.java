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

public class StatisticsUtilsArrayListStreamsTest {

    // Initializing auxiliary variables.
    private StatisticsUtilsArrayListStreams calculator;

    /**
     * This method is setting up the test environment by creating a calculator object using the void constructor.
     */
    @BeforeEach
    public void setUpBeforeClass(){
        this.calculator = new StatisticsUtilsArrayListStreams();
    }

    static Stream<Arguments> testMaxProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 4.3),
                Arguments.of( Arrays.asList(1.38, 2.56, 4.0), 4.0),
                Arguments.of( Arrays.asList(-1.0, -4.0, -1.0), -1.0)
        );
    }

    /**
     * This method is used for testing the getMax() method of the StatisticsUtilsArrayListStreams class.
     **/
    @ParameterizedTest
    @MethodSource("testMaxProvider")
    public void testMax(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMax(input));
    }

    static Stream<Arguments> testMinProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 1.38),
                Arguments.of( Arrays.asList(5.0, 8.0, -5.0), -5.0)
        );
    }

    /**
     * This method is used for testing the getMin() method of the StatisticsUtilsArrayListStreams class.
     **/
    @ParameterizedTest
    @MethodSource("testMinProvider")
    public void testMin(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMin(input));
    }


    static Stream<Arguments> testMeanProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 11.4),
                Arguments.of( Arrays.asList(0.0, 0.0, 0.0), 0.0)
        );
    }
    /**
     * This method is used for testing the getMean() method of the StatisticsUtilsArrayListStreams class.
     **/
    @ParameterizedTest
    @MethodSource("testMeanProvider")
    public void testMean(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMean(input));
    }

    static Stream<Arguments> testMedianProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9.0, 10.0, 12.0, 13.0, 13.0), 12.0),
                Arguments.of( Arrays.asList(0.0, 0.0, 0.0), 0.0)
        );
    }

    /**
     * This method is used for testing the getMedian() method of the StatisticsUtilsArrayListStreams class.
     **/
    @ParameterizedTest
    @MethodSource("testMedianProvider")
    public void testMedian(List<Double> input, double expected) {
        assertEquals(expected, calculator.getMedian(input));
    }


    static Stream<Arguments> testStandardDeviationProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(10.0, 12.0, 23.0, 23.0), 6.97614984548545)
        );
    }

    /**
     * This method is used for testing the getStandardDeviation() method of the StatisticsUtilsArrayListStreams class.
     **/
    @ParameterizedTest
    @MethodSource("testStandardDeviationProvider")
    public void testStandardDeviation(List<Double> input, double expected) {
        assertEquals(expected, calculator.getStandardDeviation(input));
    }


    /**
     * This method is used for testing the getMax() , getMin() , getMean() , getMedian() , getStandardDeviation() methods of StatisticsUtilsArrayListStreams class
     * for null and empty inputs.
     */
    @ParameterizedTest
    @NullAndEmptySource
    void testMaxForNullAndEmptyArrays(List<Double> input) {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMax(input),
                        "didn't throw an exception in getMax method in StatisticsUtilsArrayListStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMin(input),
                        "didn't throw an exception in getMin method in StatisticsUtilsArrayListStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an exception in getMean method in StatisticsUtilsArrayListStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMedian(input),
                        "didn't throw an exception in getMedian method in StatisticsUtilsArrayListStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an exception in getStandardDeviation method in StatisticsUtilsArrayListStreams class!")
        );

    }

    static Stream<Arguments> testInfinityExceptionsProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38,POSITIVE_INFINITY, 4.3)),
                Arguments.of( Arrays.asList(1.38, NEGATIVE_INFINITY, 4.3))
        );
    }

    /**
     * This method is used for testing the getMean() and getStandardDeviation() methods of StatisticsUtilsArrayListStreams class
     * for inputs that contains infinity as a value.
     */
    @ParameterizedTest
    @MethodSource("testInfinityExceptionsProvider")
    public void testInfinityExceptions(List<Double> input) {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getMean(input),
                        "didn't throw an infinity exception in getMean method in StatisticsUtilsArrayListStreams class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> calculator.getStandardDeviation(input),
                        "didn't throw an infinity exception in getStandardDeviation method in StatisticsUtilsArrayListStreams class!")
        );
    }
}