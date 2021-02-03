package com.pckt.cookbook;
import org.apache.commons.math3.stat.StatUtils;
import  org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.Arrays;


/**
 * This class is responsible for providing a set of statistical values for an array of double values.
 *
 */
class StatisticUtilsArray {

    /**
     * Gets an array of double values as input and returns the maximum of these values
     *
     * @param givenArray  The input array of double values
     *
     * @return Max value of input array
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMax(double[] givenArray) {
        if (givenArray == null || givenArray.length == 0)

            throw new IllegalArgumentException("Input array cannot be null or empty");


        return StatUtils.max(givenArray);

    }

    /**
     * Gets an array of double values as input and returns the minimum of these values
     *
     * @param givenArray  The input array of double values
     *
     * @return Min value of input array
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMin(double[] givenArray) {
        if (givenArray == null || givenArray.length == 0)

            throw new IllegalArgumentException("Input array cannot be null or empty");


        return  StatUtils.min(givenArray);

    }

    /**
     * Gets an array of double values as input and returns the mean of these values
     *
     * @param givenArray  The input array of double values
     *
     * @return Mean value of input array
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMean(double[] givenArray) {
        if (givenArray == null || givenArray.length == 0)

            throw new IllegalArgumentException("Input array mean calculation cannot be null or empty");

        if(Arrays.toString(givenArray).contains("Infinity"))

            throw new IllegalArgumentException("Input array mean calculation cannot contain infinity");


        return StatUtils.mean(givenArray);

    }

    /**
     * Gets an array of double values as input and returns the median of these values
     *
     * @param givenArray  The input array of double values
     *
     * @return Median value of input array
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getMedian(double[] givenArray) {
        if (givenArray == null || givenArray.length == 0)

            throw new IllegalArgumentException("Input array median calculation cannot be null or empty");


        Median median = new Median();
        return median.evaluate(givenArray);

    }

    /**
     * Gets an array of double values as input and returns the Standard deviation of these values
     *
     * @param givenArray  The input array of double values
     *
     * @return Standard deviation value of input array
     *
     * @throws IllegalArgumentException If an invalid input array is provided.
     */
    public double getStandardDeviation(double[] givenArray) {
        if (givenArray == null || givenArray.length == 0)

            throw new IllegalArgumentException("Input array standard_deviation calculation cannot be null or empty");

        if(Arrays.toString(givenArray).contains("Infinity"))

            throw new IllegalArgumentException("Input array standard_deviation calculation cannot be null or empty");


        StandardDeviation sdv = new StandardDeviation();
        return sdv.evaluate(givenArray);

    }
}
