package com.pckt.cookbook;

import java.lang.reflect.Array;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
*This class implements the Ascending Minima Algorithm
 */
public class AscendingMinima {
    private int windowSize;
    private double[] givenArray;


    /**
     *This is a null constructor
     */
    public AscendingMinima(){}

    /**
     *This is a constructor of AscendingMinima that gets a
     */
    public AscendingMinima(double[] givenArray, int defaultWindowSize){

        setArray(givenArray);
        setWindowSize(defaultWindowSize);

    }

    public void setWindowSize(int windowSize){
        if (windowSize <= 0)

            throw new IllegalArgumentException("Window_size needs to be greater than zero.");

        if (givenArray != null && givenArray.length < windowSize)

            throw new IllegalArgumentException("Window_size needs to be greater than array length.");

        this.windowSize = windowSize;


    }

    public void setArray(double[] givenArray){
        if (givenArray == null ||givenArray.length == 0 || givenArray.length < windowSize)

            throw new IllegalArgumentException("Input array cannot be null or empty or smaller than window size.");


        this.givenArray = givenArray;

    }


    public double[] getGivenArray() {

        return this.givenArray;


    }
    public int getWindowSize() {

        return this.windowSize;

    }

    List<Double> getFirstWindow(){

        if (this.windowSize == 0 || this.givenArray == null)

            throw new IllegalArgumentException("You forgot to set windowSize or givenArray arguments.");

        return Arrays.stream(this.givenArray).limit(this.windowSize).boxed().collect(Collectors.toList());

    }

    List<Double> getFirstAscendingMinima(){

        List<Double> window = getFirstWindow();
        StatisticUtilsArrayList gun = new StatisticUtilsArrayList();
        List<Double> ascendingMinima = new ArrayList<>();

        while (!window.isEmpty()) {

            ascendingMinima.add(gun.getMin(window));
            window.subList(0, window.indexOf(gun.getMin(window)) + 1).clear();

        }

        return ascendingMinima;
    }


    /**
     * Gets an array of double values (size of n) along with a sliding window size (k) as it is described in the algorithm description
     * and returns an array of n-k+1 double values containing the minimum values per k elements of the original array
     *
     * @return The array of n-k+1 double values
     *
     * @throws IllegalArgumentException If either invalid input array or window size are provided.
     */

    public double[] getAscendingMinima(){

        System.out.println("Given array for sliding window : " + Arrays.toString(this.givenArray) + " and size of the window :" +
                this.windowSize);



        List<Double> finalAscendingMinima = new ArrayList<>();
        List<Double> ascendingMinima = getFirstAscendingMinima();

        /* Add the first of ascending_minima list to finalExit list */
        finalAscendingMinima.add(ascendingMinima.get(0));

        /* Set index to first element after the window */
        int newElementIndex = this.windowSize;


        /* Repeat the following for loop for each element while the index is less than n-k+1 */
        for (int k = 0; k <= (givenArray.length - windowSize); k++) {


            /* If this element is equal with the first element of the ascending_minima list remove this element from ascending_minima */
            if ((double) Array.get(givenArray, k) == ascendingMinima.get(0)) ascendingMinima.remove(0);

            /* Check that new_element_index doesn't take values higher than n */
            if (newElementIndex < givenArray.length) {

                /* Set new element */
                double newElement = (double) Array.get(givenArray, newElementIndex);
                newElementIndex++;

                /* Delete from ascending_minima all elements with value less than new_element */
                ascendingMinima.removeIf(m -> m > newElement);
                ascendingMinima.add(newElement);

                /* Add first element from ascending_minima to final_request */
                finalAscendingMinima.add(ascendingMinima.get(0));

            }
        }

        return finalAscendingMinima.stream().mapToDouble(i -> i).toArray();
    }


}
