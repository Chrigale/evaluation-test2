package com.pckt.cookbook;


import java.util.List;

import static java.lang.Double.*;
import static java.lang.Math.*;

/**
 * This class is responsible for providing a set of statistical values for an array list of double values utilizing Java Streams.
 *
 */
public class StatisticsUtilsArrayListStreams {
    /**
     * This method gets an array list of double values as input and returns the maximum of these values.
     *
     * @param givenList  The input array list of double values.
     *
     * @return Max value of input array list, as double value.
     *
     * @throws IllegalArgumentException If an null or empty array list is provided.
     */
    public double getMax(List<Double> givenList) {
        if (givenList == null || givenList.isEmpty())

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        return givenList.stream().mapToDouble(Double::doubleValue).max().orElse(-1);


    }
    /**
     * This method gets an array list of double values as input and returns the minimum of these values.
     *
     * @param givenList  The input array list of double values.
     *
     * @return Min value of input array list, as double value.
     *
     * @throws IllegalArgumentException If an null or empty array list is provided.
     */
    public double getMin(List<Double> givenList) {
        if (givenList == null || givenList.isEmpty())

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        return givenList.stream().mapToDouble(Double::doubleValue).min().orElse(-1);

    }

    /**
     * This method gets an array list of double values as input and returns the mean of these values.
     *
     * @param givenList  The input array list of double values.
     *
     * @return Mean value of input array list, as double value.
     *
     * @throws IllegalArgumentException If an null or empty array list is provided.
     * @throws IllegalArgumentException If an array list that contains infinity as a value is provided.
     */
    public double getMean(List<Double> givenList) {
        if (givenList == null || givenList.isEmpty())

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");

        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))

            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");


        return givenList.stream().mapToDouble(Double::doubleValue).average().orElse(-1);


    }

    /**
     * This method gets an array list of double values as input and returns the median of these values.
     *
     * @param givenList  The input array list of double values.
     *
     * @return Median value of input array list, as double value.
     *
     * @throws IllegalArgumentException If an null or empty array list is provided.
     */
    public double getMedian(List<Double> givenList) {
        if (givenList == null || givenList.isEmpty())

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        return givenList.stream().sorted().skip(max(0, ((givenList.size() + 1) / 2) - 1))
                    .limit(1 + (1 + givenList.size()) % 2).mapToDouble(Double::doubleValue).average().orElse(-1);

    }

    /**
     * This method gets an array list of double values as input and returns the Standard deviation of these values.
     *
     * @param givenList  The input array list of double values.
     *
     * @return Standard deviation value of input array list, as double value.
     *
     * @throws IllegalArgumentException If an null or empty array list is provided.
     * @throws IllegalArgumentException If an array list that contains infinity as a value is provided.
     */
    public double getStandardDeviation(List<Double> givenList) {
        if (givenList == null || givenList.isEmpty())

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");

        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))

            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");


        double variance = givenList.stream()
                .map(i -> i - this.getMean(givenList))
                .map(i -> i*i)
                .mapToDouble(i -> i).sum();
        variance = variance/(givenList.size()-1);
        return sqrt(variance);

    }

}
