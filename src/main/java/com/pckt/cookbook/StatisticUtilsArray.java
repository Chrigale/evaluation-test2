package com.pckt.cookbook;
import org.apache.commons.math3.stat.StatUtils;
import  org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.Arrays;


/**
 * This class is responsible for providing a set of statistical
 * values for an array of double values.
 *
 */
class StatisticUtilsArray {
    double max;
    double min;
    double mean;
    double median;
    double standard_deviation;

    /**
     * Gets an array of double values as input and returns the maximum of these values
     * @param given_array  The input array of double values
     * @return Max value of input array
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMax(double[] given_array) {
        if (given_array == null || given_array.length == 0){
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }else {
            this.max = StatUtils.max(given_array);
            return max;
        }
    }

    /**
     * Gets an array of double values as input and returns the minimum of these values
     * @param given_array  The input array of double values
     * @return Min value of input array
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMin(double[] given_array) {
        if (given_array == null || given_array.length == 0){
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }else {
            this.min = StatUtils.min(given_array);
            return min;
        }
    }

    /**
     * Gets an array of double values as input and returns the mean of these values
     * @param given_array  The input array of double values
     * @return Mean value of input array
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMean(double[] given_array) {
        if (given_array == null || given_array.length == 0) {
            throw new IllegalArgumentException("Input array mean calculation cannot be null or empty");
        }
        if(Arrays.toString(given_array).contains("Infinity")){
            throw new IllegalArgumentException("Input array median calculation cannot contain infinity");
        }else {
            this.mean = StatUtils.mean(given_array);
            return mean;
        }
    }

    /**
     * Gets an array of double values as input and returns the median of these values
     * @param given_array  The input array of double values
     * @return Median value of input array
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMedian(double[] given_array) {
        if (given_array == null || given_array.length == 0){
            throw new IllegalArgumentException("Input array median calculation cannot be null or empty");
        }else {
            Median media = new Median();
            this.median = media.evaluate(given_array);
            return median;
        }
    }

    /**
     * Gets an array of double values as input and returns the Standard deviation of these values
     * @param given_array  The input array of double values
     * @return Standard deviation value of input array
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getStandard_deviation(double[] given_array) {
        if (given_array == null || given_array.length == 0){
            throw new IllegalArgumentException("Input array standard_deviation calculation cannot be null or empty");
        }
        if(Arrays.toString(given_array).contains("Infinity")){
            throw new IllegalArgumentException("Input array standard_deviation calculation cannot be null or empty");
        }
        else {
            StandardDeviation sdv = new StandardDeviation();
            this.standard_deviation = sdv.evaluate(given_array);
            return standard_deviation;
        }
    }
}
