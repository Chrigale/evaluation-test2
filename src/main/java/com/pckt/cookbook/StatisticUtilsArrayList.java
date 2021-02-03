package com.pckt.cookbook;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;


/**
 * This class is responsible for providing a set of statistical values for an array list of double values.
 */
public class StatisticUtilsArrayList {

    /**
     * Gets an array list of double values as input and returns the maximum of these values
     *
     * @param givenList  The input array list of double values
     *
     * @return Max value of input array list
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMax(List<Double> givenList) {

        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        double[] array = givenList.stream().mapToDouble(i -> i).toArray();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double aDouble : array) stats.addValue(aDouble);
        return stats.getMax();


    }

    /**
     * Gets an array list of double values as input and returns the minimum of these values
     *
     * @param givenList  The input array list of double values
     *
     * @return Min value of input array list
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMin(List<Double> givenList) {
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist min calculation cannot be null or empty");


        double[] array = givenList.stream().mapToDouble(i -> i).toArray();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double aDouble : array) stats.addValue(aDouble);
        return stats.getMin();


    }

    /**
     * Gets an array list of double values as input and returns the mean of these values
     *
     * @param givenList  The input array list of double values
     *
     * @return Mean value of input array list
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMean(List<Double> givenList) {
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist mean calculation cannot be null or empty");


        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))

            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");

        double[] array = givenList.stream().mapToDouble(i -> i).toArray();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double aDouble : array) stats.addValue(aDouble);
        return stats.getMean();

    }

    /**
     * Gets an array list of double values as input and returns the median of these values
     *
     * @param givenList  The input array list of double values
     *
     * @return Median value of input array list
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMedian(List<Double> givenList) {
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist median calculation cannot be null or empty");


        double[] array = givenList.stream().mapToDouble(i -> i).toArray();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double aDouble : array) stats.addValue(aDouble);
        return stats.getPercentile(50);


    }


    /**
     * Gets an array list of double values as input and returns the Standard deviation of these values
     *
     * @param givenList  The input array list of double values
     *
     * @return Standard deviation value of input array list
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getStandardDeviation(List<Double> givenList) {
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist standard_deviation calculation cannot be null or empty");


        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))
            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");


        double[] array = givenList.stream().mapToDouble(i -> i).toArray();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (Double aDouble : array) stats.addValue(aDouble);
        return stats.getStandardDeviation();


    }

}

