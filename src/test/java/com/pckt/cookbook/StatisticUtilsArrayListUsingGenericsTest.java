package com.pckt.cookbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticUtilsArrayListUsingGenericsTest<T extends Number> {

    // Initializing auxiliary variables.
    private StatisticUtilsArrayListUsingGenerics<Integer> IntegerCalculator;
    private StatisticUtilsArrayListUsingGenerics<Double>  DoubleCalculator;

    /**
     * This method is setting up the test environment by creating an IntegerCalculator and a DoubleCalculator object using the void constructor.
     */
    @BeforeEach
    void setUpBeforeClass(){

        IntegerCalculator = new StatisticUtilsArrayListUsingGenerics<>();
        DoubleCalculator  = new StatisticUtilsArrayListUsingGenerics<>();
    }

    static Stream<Arguments> testMaxIntegerInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1, 2, 4), 4),
                Arguments.of( Arrays.asList(1, 2, 5), 5),
                Arguments.of( Arrays.asList(-1, -4, -1), -1)
        );
    }

    /**
     * This method is used for testing the getMax() method of the StatisticUtilsArrayListUsingGenerics class for Integer objects.
     **/
    @ParameterizedTest
    @MethodSource("testMaxIntegerInputProvider")
    public void testMaxIntegerInput(List<Integer> input, double expected) { assertEquals(expected, IntegerCalculator.getMax(input));}



    static Stream<Arguments> testMaxDoubleInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 4.3),
                Arguments.of( Arrays.asList(1.38, 2.56, 4.0), 4.0),
                Arguments.of( Arrays.asList(-1.0, -4.0, -1.0), -1.0)
        );
    }

    /**
     * This method is used for testing the getMax() method of the StatisticUtilsArrayListUsingGenerics class for Double objects.
     **/
    @ParameterizedTest
    @MethodSource("testMaxDoubleInputProvider")
    public void testMaxDoubleInput(List<Double> input, double expected) { assertEquals(expected, DoubleCalculator.getMax(input)); }



    static Stream<Arguments> testMinIntegerInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1, 2, 4), 1),
                Arguments.of( Arrays.asList( 2, 5), 2),
                Arguments.of( Arrays.asList(-1, -4, -1), -4)
        );
    }

    /**
     * This method is used for testing the getMin() method of the StatisticUtilsArrayListUsingGenerics class for Integer objects.
     **/
    @ParameterizedTest
    @MethodSource("testMinIntegerInputProvider")
    public void testMinIntegerInput(List<Integer> input, double expected) { assertEquals(expected, IntegerCalculator.getMin(input));}



    static Stream<Arguments> testMinDoubleInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(1.38, 2.56, 4.3), 1.38),
                Arguments.of( Arrays.asList(2.56, 4.0), 2.56),
                Arguments.of( Arrays.asList(-1.0, -4.0, -1.0), -4.0)
        );
    }

    /**
     * This method is used for testing the getMin() method of the StatisticUtilsArrayListUsingGenerics class for Double objects.
     **/
    @ParameterizedTest
    @MethodSource("testMinDoubleInputProvider")
    public void testMinDoubleInput(List<Double> input, double expected) { assertEquals(expected, DoubleCalculator.getMin(input)); }



    static Stream<Arguments> testMeanIntegerInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9, 10, 12, 13, 13), 11.4),
                Arguments.of( Arrays.asList( 2, 5), 3.5)
        );
    }

    /**
     * This method is used for testing the getMean() method of the StatisticUtilsArrayListUsingGenerics class for Integer objects.
     **/
    @ParameterizedTest
    @MethodSource("testMeanIntegerInputProvider")
    public void testMeanIntegerInput(List<Integer> input, double expected) { assertEquals(expected, IntegerCalculator.getMean(input));}



    static Stream<Arguments> testMeanDoubleInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9d, 10d, 12d, 13d, 13d), 11.4),
                Arguments.of( Arrays.asList(0d, 0d, 0d), 0d)
        );
    }

    /**
     * This method is used for testing the getMean() method of the StatisticUtilsArrayListUsingGenerics class for Double objects.
     **/
    @ParameterizedTest
    @MethodSource("testMeanDoubleInputProvider")
    public void testMeanDoubleInput(List<Double> input, double expected) { assertEquals(expected, DoubleCalculator.getMean(input)); }



    static Stream<Arguments> testMedianIntegerInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9, 10, 12, 13, 13), 12),
                Arguments.of( Arrays.asList( 2, 5), 3.5)
        );
    }

    /**
     * This method is used for testing the getMedian() method of the StatisticUtilsArrayListUsingGenerics class for Integer objects.
     **/
    @ParameterizedTest
    @MethodSource("testMedianIntegerInputProvider")
    public void testMedianIntegerInput(List<Integer> input, double expected) { assertEquals(expected, IntegerCalculator.getMedian(input));}



    static Stream<Arguments> testMedianDoubleInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(9d, 10d, 12d, 13d, 13d), 12d),
                Arguments.of( Arrays.asList(0d, 0d, 0d), 0d)
        );
    }

    /**
     * This method is used for testing the getMedian() method of the StatisticUtilsArrayListUsingGenerics class for Double objects.
     **/
    @ParameterizedTest
    @MethodSource("testMedianDoubleInputProvider")
    public void testMedianDoubleInput(List<Double> input, double expected) { assertEquals(expected, DoubleCalculator.getMedian(input)); }



    static Stream<Arguments> testStandardDeviationIntegerInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(10, 12, 23, 23), 6.97614984548545),
                Arguments.of( Arrays.asList( 2, 5), 2.1213203435596424)
        );
    }

    /**
     * This method is used for testing the getStandardDeviation() method of the StatisticUtilsArrayListUsingGenerics class for Integer objects.
     **/
    @ParameterizedTest
    @MethodSource("testStandardDeviationIntegerInputProvider")
    public void testStandardDeviationIntegerInput(List<Integer> input, double expected) { assertEquals(expected, IntegerCalculator.getStandardDeviation(input));}


    static Stream<Arguments> testStandardDeviationDoubleInputProvider() {

        return Stream.of(
                Arguments.of( Arrays.asList(10d, 12d, 23d, 23d), 6.97614984548545),
                Arguments.of( Arrays.asList(0d, 0d, 0d), 0d)
        );
    }

    /**
     * This method is used for testing the getStandardDeviation() method of the StatisticUtilsArrayListUsingGenerics class for Double objects.
     **/
    @ParameterizedTest
    @MethodSource("testStandardDeviationDoubleInputProvider")
    public void testStandardDeviationDoubleInput(List<Double> input, double expected) { assertEquals(expected, DoubleCalculator.getStandardDeviation(input)); }



    /**
     * This method is used for testing the getMax() , getMin() , getMean() , getMedian() , getStandardDeviation() methods of
     * StatisticUtilsArrayListUsingGenerics<Integer> class for null and empty inputs.
     */
    @ParameterizedTest
    @NullAndEmptySource
    void testForNullAndEmptyIntegerArrays(List<Integer> input) {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getMax(input),
                        "didn't throw an exception in getMax method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getMin(input),
                        "didn't throw an exception in getMin method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getMean(input),
                        "didn't throw an exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getMedian(input),
                        "didn't throw an exception in getMedian method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getStandardDeviation(input),
                        "didn't throw an exception in getStandardDeviation method in StatisticUtilsArrayList class!")
        );
    }

    /**
     * This method is used for testing the getMax() , getMin() , getMean() , getMedian() , getStandardDeviation() methods of
     * StatisticUtilsArrayListUsingGenerics<Double> class for null and empty inputs.
     */
    @ParameterizedTest
    @NullAndEmptySource
    void testForNullAndEmptyDoubleArrays(List<Double> input) {

        assertAll(

                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getMax(input),
                        "didn't throw an exception in getMax method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getMin(input),
                        "didn't throw an exception in getMin method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getMean(input),
                        "didn't throw an exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getMedian(input),
                        "didn't throw an exception in getMedian method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getStandardDeviation(input),
                        "didn't throw an exception in getStandardDeviation method in StatisticUtilsArrayList class!")
        );
    }

    static Stream<Arguments> testInfinityExceptionsProvider() {
        return Stream.of(
                Arguments.of( Arrays.asList(1.38,POSITIVE_INFINITY, 4.3)),
                Arguments.of( Arrays.asList(1.38, NEGATIVE_INFINITY, 4.3))
        );
    }

    /**
     * This method is used for testing the getMean() and getStandardDeviation() methods of StatisticUtilsArrayListUsingGenerics<Double> class
     * for inputs that contains infinity as a value.
     */
    @ParameterizedTest
    @MethodSource("testInfinityExceptionsProvider")
    public void testInfinityExceptions(List<Double> input) {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getMean(input),
                        "didn't throw an infinity exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> DoubleCalculator.getStandardDeviation(input),
                        "didn't throw an infinity exception in getStandardDeviation method in StatisticUtilsArrayList class!")
        );
    }



    static Stream<Arguments> testInfinityExceptionsForIntegerArrayProvider() {
        return Stream.of(
                Arguments.of( Arrays.asList(1,POSITIVE_INFINITY, 4)),
                Arguments.of( Arrays.asList(1, NEGATIVE_INFINITY, 4))
        );
    }

    /**
     * This method is used for testing the getMean() and getStandardDeviation() methods of StatisticUtilsArrayListUsingGenerics<Integer> class
     * for inputs that contains infinity as a value.
     */
    @ParameterizedTest
    @MethodSource("testInfinityExceptionsForIntegerArrayProvider")
    public void testInfinityExceptionsForIntegerArray(List<Integer> input) {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getMean(input),
                        "didn't throw an infinity exception in getMean method in StatisticUtilsArrayList class!"),


                () -> assertThrows(IllegalArgumentException.class, () -> IntegerCalculator.getStandardDeviation(input),
                        "didn't throw an infinity exception in getStandardDeviation method in StatisticUtilsArrayList class!")
        );
    }
}