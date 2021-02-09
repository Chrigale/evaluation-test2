package com.pckt.cookbook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the Ascending Minima Algorithm
 */
public class AscendingMinima {

    /**
     * Τhe size of sliding window to be used for minima calculation of given array.
     */
    private int windowSize = 0;

    /**
     * The array of which the ascending minima will be calculated.
     */
    private double[] givenArray = {};

    /**
     * This is a void constructor
     */
    public AscendingMinima(){}

    /**
     * This is a constructor of AscendingMinima class that sets the values of variables givenArray and defaultWindowSize
     * for the calculation of ascending minima.
     *
     * @param givenArray        The array of which the ascending minima will be calculated, as an array of double numbers.
     * @param defaultWindowSize The size of sliding window to be used for minima calculation of given array, as an int.
     */
    public AscendingMinima(int defaultWindowSize,double[] givenArray){

        setArray(givenArray);
        setWindowSize(defaultWindowSize);
    }

    /**
     * This is a method that returns the value of windowSize variable.
     *
     * @return the windowSize, as an int.
     */
    public int getWindowSize() {

        return this.windowSize;
    }

    /**
     * This is a method that returns the value of givenArray variable.
     *
     * @return the givenArray, as an array of double numbers.
     */
    public double[] getGivenArray() {

        return this.givenArray;
    }

    /**
     * This is a method that set the value of defaultWindowSize variable.
     *
     * @param windowSize The size of sliding window to be used for minima calculation of given array, as an int.
     *
     * @throws IllegalArgumentException if windowSize is not a positive number.
     * @throws IllegalArgumentException if windowSize is smaller than the length of the givenArray,only if the latter is
     * not empty.
     */

    public void setWindowSize(int windowSize){

        if (windowSize <= 0)

            throw new IllegalArgumentException("Window_size needs to be greater than zero.");

        if (givenArray.length != 0 && givenArray.length < windowSize)

            throw new IllegalArgumentException("Window_size needs to be greater than array length.");

        this.windowSize = windowSize;
    }

    /**
     * This is a method that set the value of givenArray variable.
     *
     * @param givenArray The array of which the ascending minima will be calculated.
     *
     * @throws IllegalArgumentException if givenArray is null or empty or smaller than windowSize.
     */

    public void setArray(double[] givenArray){

        if (givenArray == null ||givenArray.length == 0 || givenArray.length < windowSize)

            throw new IllegalArgumentException("Input array cannot be null or empty or smaller than window size.");

        this.givenArray = givenArray;
    }

    /**
     * This is a method that returns an array of n-k-1 values containing the minimum values per k elements of the
     * givenArray,
     * where n is the size of the latter and k is the value of slidingWindow variable.
     *
     * @return The aforementioned array of n-k+1 double values,as an array of double values.
     */
    public double[] getAscendingMinima(){

        System.out.println("Given array for sliding window : " + Arrays.toString(this.givenArray) + " and size of the " +
                "window :" +
                this.windowSize);

        List<Double> finalAscendingMinima = new ArrayList<>();
        List<Double> ascendingMinima      = getFirstAscendingMinima();

        /* Add the first of ascending_minima list to finalExit list */
        finalAscendingMinima.add(ascendingMinima.get(0));

        int loop_index = givenArray.length - windowSize+1;
        /* Repeat the following for loop for each element while the index is less than n-k+1 */
        for (int k = 0; k <= loop_index; k++) {

            /* If this element is equal with the first element of the ascending_minima list remove this element from ascending_minima */
            if ((double) Array.get(givenArray, k) == ascendingMinima.get(0)) ascendingMinima.remove(0);

            /* Check that new_element_index doesn't take values higher than n */
            if (windowSize < givenArray.length) {

                /* Set new element */
                double newElement = (double) Array.get(givenArray, windowSize);
                windowSize++;

                /* Delete from ascending_minima all elements with value less than new_element */
                ascendingMinima.removeIf(m -> m > newElement);
                ascendingMinima.add(newElement);

                /* Add first element from ascending_minima to final_request */
                finalAscendingMinima.add(ascendingMinima.get(0));
            }
        }

        return finalAscendingMinima.stream().mapToDouble(i -> i).toArray();
    }

    /**
     * This is a method that adds the minimum of window array list to ascendingMinima array list and delete all values
     * preceding
     * the selected minimum along with it from window and repeat process until window is empty.
     *
     * @return ascendingMinima The aforementioned array list, as an array list of Double objects.
     */
    List<Double> getFirstAscendingMinima(){

        // Initializing auxiliary variables
        List<Double> ascendingMinima = new ArrayList<>();
        List<Double> window          = getFirstWindow();

        // Retrieving the first window
        for (int i=0; i < windowSize ; i++){

            if (window.get(0) == StatisticUtilsArrayList.getMin(window))

                ascendingMinima.add(window.get(0));

            window.remove(0);
        }

        return ascendingMinima;
    }

    /**
     * This is a method that returns an array list of only the first n values of givenArray, where n is windowSize value.
     *
     * @return the aforementioned array list, as an array list of Double objects.
     *
     * @throws IllegalArgumentException if windowSize is zero or givenArray is empty.
     */
    List<Double> getFirstWindow(){

        if (this.windowSize == 0 || this.givenArray.length == 0)

            throw new IllegalArgumentException("You forgot to set windowSize or givenArray arguments.");

        return Arrays.stream(this.givenArray).limit(this.windowSize).boxed().collect(Collectors.toList());
    }
}
