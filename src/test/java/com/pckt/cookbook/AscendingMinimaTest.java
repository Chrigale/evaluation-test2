package com.pckt.cookbook;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;


public class AscendingMinimaTest {

    // Initializing auxiliary variables.
    private AscendingMinima calculator;

    /**
     * This method is setting up the test environment by creating a calculator object using the void constructor.
     */
    @BeforeEach
    public void setUpBeforeClass(){ calculator = new AscendingMinima(); }

    /**
     * This is a testing method for the initial state of the givenArray variable of the AscendingMinima class.
     **/
    @Test
    public void getGivenArrayInitialState() {

        assertNull(calculator.getGivenArray());

    }

    /**
     * This is a testing method for the initial state of the windowSize variable of the AscendingMinima class.
     **/
    @Test
    public void getWindowSizeInitialState() {

        assertEquals(0, calculator.getWindowSize());

    }

    /**
     * This method is used for testing the setter method for the givenArray variable of the AscendingMinima class.
     * In this parameterized test case the input is null and empty.
     **/
    @ParameterizedTest
    @NullAndEmptySource
    void setArrayNullOrEmptyInput(double[] input) {

        getGivenArrayInitialState();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.setArray(input));

        assertEquals("Input array cannot be null or empty or smaller than window size.", exception.getMessage());

    }

    /**
     * This method is used for testing the setter method for the givenArray variable of the AscendingMinima class.
     * In this test case the input is an array of smaller than windowSize value length.
     **/
    @Test
    public void setArrayWithLengthSmallerThanWindowSize() {

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.setArray(new double[] {-5, -4, 10, 20, 50}));

        assertEquals("Input array cannot be null or empty or smaller than window size.", exception.getMessage());


    }


    /**
     * This method is used for testing the setter method for the windowSize variable of the AscendingMinima class.
     * In this parameterized test case the input is zero or negative.
     **/
    @ParameterizedTest
    @ValueSource(ints = {0,-6})
    public void setWindowSizeNegativeAndZeroInput(int value) {

        getWindowSizeInitialState();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.setWindowSize(value));

        assertEquals("Window_size needs to be greater than zero.", exception.getMessage());


    }

    /**
     * This method is used for testing the setter method for the windowSize variable of the AscendingMinima class.
     * In this parameterized test case the input is a positive number.
     **/
    @ParameterizedTest
    @ValueSource(ints = {5,6})
    public void setWindowSizePositiveInput(int value) {

        getWindowSizeInitialState();

        calculator.setWindowSize(value);

        assertEquals(value,calculator.getWindowSize());


    }

    /**
     * This method is used for testing the setter method for the givenArray variable of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void setArrayInput(double[] value) {

        calculator.setArray(value);

        assertArrayEquals(value,calculator.getGivenArray());


    }

    static Stream<Arguments> setArrayInput() {
        return Stream.of(
                Arguments.of(new double[] {-5, -4, 10, 20, 50}),
                Arguments.of(new double[] {-5, -4, 10, 20, 50})
        );
    }

    /**
     * This method is used for testing the setter method for the windowSize variable of the AscendingMinima class.
     * In this test case the input is an windowSize with value of greater than givenArray length.
     **/
    @Test
    public void setWindowSizeGreaterThanArrayLength() {

        getWindowSizeInitialState();
        getGivenArrayInitialState();

        calculator.setArray(new double[] {-5, -4, 10, 20, 50});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.setWindowSize(10));

        assertEquals("Window_size needs to be greater than array length.", exception.getMessage());


    }

    /**
     * This method is used for testing the void constructor of the AscendingMinima class.
     **/
    @Test
    public void checkIfNullConstructorGivesNullObject() {

        assertNotNull(calculator);


    }

    /**
     * This method is used for testing the main constructor of the AscendingMinima class.
     **/
    @Test
    public void Constructor() {

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        double[] array      = {-5, -4, 10, 20, 50};
        int      windowSize = 3;

        calculator = new AscendingMinima(array, windowSize);

        assertNotNull(calculator);
        assertEquals(windowSize, calculator.getWindowSize());
        assertArrayEquals(array,calculator.getGivenArray());


    }

    /**
     * This method is used for testing the getFirstWindow method of the AscendingMinima class.
     * In this test case windowSize is not initialized, so an exception is expected.
     **/
    @Test
    public void getFirstWindowZeroWindowSizeInput() {

        getWindowSizeInitialState();

        calculator.setArray(new double[] {-5, -4, 10, 20, 50});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.getFirstWindow());

        assertEquals("You forgot to set windowSize or givenArray arguments.", exception.getMessage());

    }

    /**
     * This method is used for testing the getFirstWindow method of the AscendingMinima class.
     * In this test case givenArray is not initialized, so an exception is expected.
     **/
    @Test
    public void getFirstWindowNullArrayInput() {

        getGivenArrayInitialState();

        calculator.setWindowSize(5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.getFirstWindow());

        assertEquals("You forgot to set windowSize or givenArray arguments.", exception.getMessage());

    }

    /**
     * This method is a positive scenario test of the getFirstWindow method of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void getFirstWindowTrueTest(double[] inputArray, int windowSize, List<Double> outputArray){

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(windowSize);
        calculator.setArray(inputArray);
        assertEquals(outputArray,calculator.getFirstWindow());

    }


    static Stream<Arguments> getFirstWindowTrueTest() {

        return Stream.of(
                Arguments.of( new double[] {-5, -4, 10, 20, 50}, 4 ,Arrays.asList(-5d, -4d, 10d, 20d)),
                Arguments.of( new double[] {-5, -4, 10, 20, 50}, 2 , Arrays.asList(-5d, -4d))
        );
    }

    /**
     * This method is a negative scenario test of the getFirstWindow method of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void getFirstWindowFalseTest(double[] inputArray, int windowSize, List<Double> outputArray){

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(windowSize);
        calculator.setArray(inputArray);
        assertNotEquals(outputArray,calculator.getFirstWindow());

    }


    static Stream<Arguments> getFirstWindowFalseTest() {

        return Stream.of(
                Arguments.of( new double[] {-5, -4, 10, 20, 50}, 4 ,Arrays.asList(-5d, -4d, 10d)),
                Arguments.of( new double[] {-5, -4, 10, 20, 50}, 2 , Arrays.asList(-5d, -4d,20d,30d))
        );
    }

    /**
     * This method is a positive scenario test of the getFirstAscendingMinima method of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void getFirstAscendingMinimaTest(double[] inputArray, int windowSize, List<Double> outputArray){

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(windowSize);
        calculator.setArray(inputArray);
        assertEquals(outputArray,calculator.getFirstAscendingMinima());

    }


    static Stream<Arguments> getFirstAscendingMinimaTest() {

        return Stream.of(
                Arguments.of( new double[] {9d,5d,10d,4d,3d}, 3 ,Arrays.asList(5d, 10d)),
                Arguments.of( new double[] {5d,-8d,-8d, 10d,1d}, 2 , singletonList(-8d))
        );
    }

    /**
     * This method is a negative scenario test of the getFirstAscendingMinima method of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void getFirstAscendingMinimaFalseTest(double[] inputArray, int windowSize, List<Double> outputArray){

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(windowSize);
        calculator.setArray(inputArray);
        assertNotEquals(outputArray,calculator.getFirstAscendingMinima());

    }


    static Stream<Arguments> getFirstAscendingMinimaFalseTest() {

        return Stream.of(
                Arguments.of( new double[] {9d,5d,10d,4d,3d}, 3 , singletonList(5d)),
                Arguments.of( new double[] {5d,-8d,-8d, 10d,1d}, 2 , Arrays.asList(-8d,-8d))
        );
    }

    /**
     * This method is a positive scenario test of the getAscendingMinima method of the AscendingMinima class.
     **/
    @ParameterizedTest
    @MethodSource
    public void getAscendingMinimaTest(double[] inputArray, int windowSize, double[] outputArray){

        getGivenArrayInitialState();
        getWindowSizeInitialState();

        calculator.setWindowSize(windowSize);
        calculator.setArray(inputArray);
        assertArrayEquals(outputArray,calculator.getAscendingMinima());

    }


    static Stream<Arguments> getAscendingMinimaTest() {

        return Stream.of(
                Arguments.of( new double[] {9d,5d,10d,4d,3d}, 3 ,new double[] {5d,4d,3d}),
                Arguments.of( new double[] {5d,-8d,-8d, 10d,1d}, 2 , new double[] {-8d,-8d,-8d,1d}),
                Arguments.of( new double[] {5d,-8d,15d, 0d,-1d,9d}, 4 , new double[] {-8d,-8d,-1d})
        );
    }

}