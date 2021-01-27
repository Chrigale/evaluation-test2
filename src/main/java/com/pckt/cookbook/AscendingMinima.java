package com.pckt.cookbook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*This class implements the Ascending Minima Algorithm
 */
public class AscendingMinima {
    Double[] requested_exit;


    /**
     * Gets an array of double values (size of n) along with a sliding window size (k) as it is described in the algorithm description
     * and returns an array of n-k+1 double values containing the minimum values per k elements of the original array
     * @param given_array  The input array of double values
     * @param window_size  The input sliding window size
     * @return The array of n-k+1 double values
     * @throws IllegalArgumentException If either invalid input array or window size are provided.
     *
     */
    public Double[] getRequested_exit(double[] given_array, int window_size){
        if (given_array == null ||given_array.length == 0 ){
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        if (window_size > given_array.length || window_size <= 0){
            throw new IllegalArgumentException("Window_size needs to be greater than zero but cannot be greater than array length");
        } else {
            System.out.println("Given array for sliding window : " + Arrays.toString(given_array) + " and size of the window :" +
                    window_size);
            /*  Initialize window list, ascending_minima and final_request*/
            List<Double> window = new ArrayList<>();
            List<Double> ascending_minima = new ArrayList<>();
            List<Double> final_request = new ArrayList<>();

            /*  Get first k values of input array into window list*/
            for (int i = 0; i < window_size; i++)
                window.add(given_array[i]);
            StatisticUtilsArrayList gun = new StatisticUtilsArrayList();
            /* Add the window's minimum value to ascending_minima remove previous values and repeat process until window is empty
             * First step of the provided algorithm */
            while (!window.isEmpty()) {
                ascending_minima.add(gun.getMin(window));
                window.subList(0, window.indexOf(gun.getMin(window)) + 1).clear();
            }

            /* Add the first of ascending_minima list to final_request list */
            final_request.add(ascending_minima.get(0));

            /* Set index to first element after the window */
            int new_element_index = window_size;
            /* Repeat the following for loop for each element while the index is less than n-k+1 */
            for (int k = 0; k <= (given_array.length - window_size); k++) {
                /* If this element is equal with the first element of the ascending_minima list remove this element from ascending_minima */
                if ((double) Array.get(given_array, k) == ascending_minima.get(0)) ascending_minima.remove(0);

                /* Check that new_element_index doesn't take values higher than n */
                if (new_element_index < given_array.length) {
                    /* Set new element */
                    double new_element = (double) Array.get(given_array, new_element_index);
                    new_element_index++;
                    /* Delete from ascending_minima all elements with value less than new_element */
                    ascending_minima.removeIf(m -> m > new_element);
                    ascending_minima.add(new_element);
                    /* Add first element from ascending_minima to final_request */
                    final_request.add(ascending_minima.get(0));
                }
            }
            this.requested_exit = final_request.toArray(new Double[0]);
            return requested_exit;
        }
    }
}
