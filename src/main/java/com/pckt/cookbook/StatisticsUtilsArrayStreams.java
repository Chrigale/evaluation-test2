package com.pckt.cookbook;


import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * This class is responsible for providing a set of statistical
 * values for an array of double values utilizing Java Streams.
 *
 */
public class StatisticsUtilsArrayStreams {
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
            throw new IllegalArgumentException("Input array for max calculation cannot be null or empty");
        }else {
            DoubleStream stream = Arrays.stream(given_array);
            this.max = stream.max().getAsDouble();
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
            throw new IllegalArgumentException("Input array min calculation cannot be null or empty");
        }else {
            DoubleStream stream = Arrays.stream(given_array);
            this.min = stream.min().getAsDouble();
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
            DoubleStream stream = Arrays.stream(given_array);
            this.mean = stream.average().getAsDouble();
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
            DoubleStream stream = Arrays.stream(given_array);
            this.median = stream.sorted().skip(Math.max(0, ((given_array.length + 1) / 2) - 1))
                    .limit(1 + (1 + given_array.length) % 2).average().getAsDouble();
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
            DoubleStream stream = Arrays.stream(given_array);
            double variance = stream
                    .map(i -> i - this.getMean(given_array))
                    .map(i -> i*i)
                    .sum();
            variance = variance/(given_array.length-1);
            this.standard_deviation = Math.sqrt(variance);
            return standard_deviation;
        }
    }
}
