package com.pckt.cookbook;


import java.util.Arrays;
import static java.lang.Math.sqrt;

/**
 * This class is responsible for providing a set of statistical values for an array of double values utilizing Java Streams.
 */
public class StatisticsUtilsArrayStreams {

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

            throw new IllegalArgumentException("Input array for max calculation cannot be null or empty");


        return Arrays.stream(givenArray).max().orElse(-1);

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

            throw new IllegalArgumentException("Input array min calculation cannot be null or empty");


        return Arrays.stream(givenArray).min().orElse(-1);

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

            throw new IllegalArgumentException("Input array median calculation cannot contain infinity");


        return Arrays.stream(givenArray).average().orElse(-1);


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


        return Arrays.stream(givenArray).sorted().skip(Math.max(0, ((givenArray.length + 1) / 2) - 1))
                    .limit(1 + (1 + givenArray.length) % 2).average().orElse(-1);

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


        double variance = Arrays.stream(givenArray)
                .map(i -> i - this.getMean(givenArray))
                .map(i -> i*i)
                .sum();
        variance = variance/(givenArray.length-1);
        return sqrt(variance);

    }
}
