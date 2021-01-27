package com.pckt.cookbook;


import java.util.List;

/**
 * This class is responsible for providing a set of statistical
 * values for an array list of double values utilizing Java Streams.
 *
 */
public class StatisticsUtilsArrayListStreams {
    double max;
    double min;
    double mean;
    double median;
    double standard_deviation;

    /**
     * Gets an array list of double values as input and returns the maximum of these values
     * @param given_list  The input array list of double values
     * @return Max value of input array list
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMax(List<Double> given_list) {
        if (given_list == null || given_list.size() == 0) {
            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");
        }else {
            this.max = given_list.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
            return max;
        }
    }
    /**
     * Gets an array list of double values as input and returns the minimum of these values
     * @param given_list  The input array list of double values
     * @return Min value of input array list
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMin(List<Double> given_list) {
        if (given_list == null || given_list.size() == 0) {
            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");
        }else {
            this.min = given_list.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
            return min;
        }
    }

    /**
     * Gets an array list of double values as input and returns the mean of these values
     * @param given_list  The input array list of double values
     * @return Mean value of input array list
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMean(List<Double> given_list) {
        if (given_list == null || given_list.size() == 0) {
            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");
        }
        if (given_list.contains(Double.NEGATIVE_INFINITY) || given_list.contains(Double.POSITIVE_INFINITY)){
            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");
        } else {
            this.mean = given_list.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            return mean;
        }
    }

    /**
     * Gets an array list of double values as input and returns the median of these values
     * @param given_list  The input array list of double values
     * @return Median value of input array list
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getMedian(List<Double> given_list) {
        if (given_list == null || given_list.size() == 0) {
            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");
        }else {
            this.median = given_list.stream().sorted().skip(Math.max(0, ((given_list.size() + 1) / 2) - 1))
                    .limit(1 + (1 + given_list.size()) % 2).mapToDouble(Double::doubleValue).average().getAsDouble();
            return median;
        }
    }

    /**
     * Gets an array list of double values as input and returns the Standard deviation of these values
     * @param given_list  The input array list of double values
     * @return Standard deviation value of input array list
     * @throws IllegalArgumentException If an invalid input array is provided.
     *
     */
    public double getStandard_deviation(List<Double> given_list) {
        if (given_list == null || given_list.size() == 0) {
            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");
        }
        if (given_list.contains(Double.NEGATIVE_INFINITY) || given_list.contains(Double.POSITIVE_INFINITY)){
            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");
        }else {
            double variance = given_list.stream()
                    .map(i -> i - this.getMean(given_list))
                    .map(i -> i*i)
                    .mapToDouble(i -> i).sum();
            variance = variance/(given_list.size()-1);
            this.standard_deviation = Math.sqrt(variance);
            return standard_deviation;
        }
    }

}
