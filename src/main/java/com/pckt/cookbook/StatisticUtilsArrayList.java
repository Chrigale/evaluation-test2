package com.pckt.cookbook;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;


/**
 * This class is responsible for providing a set of statistical
 * values for an array list of double values.
 *
 */
public class StatisticUtilsArrayList {
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
            Double[] array = given_list.toArray(new Double[0]);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double aDouble : array) stats.addValue(aDouble);
            this.max = stats.getMax();
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
            throw new IllegalArgumentException("Input arraylist min calculation cannot be null or empty");
        }else {
            Double[] array = given_list.toArray(new Double[0]);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double aDouble : array) stats.addValue(aDouble);
            this.min = stats.getMin();
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
            throw new IllegalArgumentException("Input arraylist mean calculation cannot be null or empty");
        }
        if (given_list.contains(Double.NEGATIVE_INFINITY) || given_list.contains(Double.POSITIVE_INFINITY)){
            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");
        }else{
            Double[] array = given_list.toArray(new Double[0]);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double aDouble : array) stats.addValue(aDouble);
            this.mean = stats.getMean();
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
            throw new IllegalArgumentException("Input arraylist median calculation cannot be null or empty");
        }else {
            Double[] array = given_list.toArray(new Double[0]);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double aDouble : array) stats.addValue(aDouble);
            this.median = stats.getPercentile(50);
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
            throw new IllegalArgumentException("Input arraylist standard_deviation calculation cannot be null or empty");
        }if (given_list.contains(Double.NEGATIVE_INFINITY) || given_list.contains(Double.POSITIVE_INFINITY)){
            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");
        }else {
            Double[] array = given_list.toArray(new Double[0]);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for (Double aDouble : array) stats.addValue(aDouble);
            this.standard_deviation = stats.getStandardDeviation();
            return standard_deviation;
        }
    }

}

