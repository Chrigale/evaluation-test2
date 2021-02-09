package com.pckt.cookbook;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for providing a set of statistical values for an array list of T objects utilizing Java generics,
 * where T is a Numerical data type.
 */
public class StatisticUtilsArrayListUsingGenerics<T extends Number> {

    /**
     * Gets an array list of T objects as input and returns the maximum of these objects.
     *
     * @param givenList  The input array list of T objects.
     *
     * @return Max object of input array list, as a double value.
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMax(List<T> givenList){

        if (givenList == null)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null.");

        List<Double> doubleArray    = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        return StatisticUtilsArrayList.getMax(doubleArray);
    }

    /**
     * Gets an array list of T objects as input and returns the minimum of these objects.
     *
     * @param givenList  The input array list of T objects.
     *
     * @return Min object of input array list, as a double value.
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public  double getMin(List<T> givenList){

        if (givenList == null)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null.");

        List<Double> doubleArray    = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        return StatisticUtilsArrayList.getMin(doubleArray);
    }

    /**
     * Gets an array list of T objects as input and returns the median of these objects.
     *
     * @param givenList  The input array list of T objects.
     *
     * @return Median object of input array list, as a double value.
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMedian(List<T> givenList){

        if (givenList == null)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null.");

        List<Double> doubleArray    = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        return StatisticUtilsArrayList.getMedian(doubleArray);
    }

    /**
     * Gets an array list of T objects as input and returns the mean of these objects.
     *
     * @param givenList  The input array list of T objects.
     *
     * @return Mean object of input array list, as a double value.
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMean(List<T> givenList){

        if (givenList == null)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null.");

        List<Double> doubleArray    = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        return StatisticUtilsArrayList.getMean(doubleArray);
    }

    /**
     * Gets an array list of T objects as input and returns the standard deviation of these objects.
     *
     * @param givenList  The input array list of T objects.
     *
     * @return Standard deviation object of input array list, as a double value.
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getStandardDeviation(List<T> givenList){
        if (givenList == null)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");

        List<Double> doubleArray    = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        return StatisticUtilsArrayList.getStandardDeviation(doubleArray);
    }
}