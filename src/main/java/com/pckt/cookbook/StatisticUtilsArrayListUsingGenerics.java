package com.pckt.cookbook;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class StatisticUtilsArrayListUsingGenerics<T extends Number> {

    public double getMax(List<T> givenList){
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        List<Double> doubleArray = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        StatisticUtilsArrayList bob = new StatisticUtilsArrayList();
        return bob.getMax(doubleArray);
    }

    public  double getMin(List<T> givenList){
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        List<Double> doubleArray = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        StatisticUtilsArrayList bob = new StatisticUtilsArrayList();
        return bob.getMin(doubleArray);
    }

    public double getMedian(List<T> givenList){
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");


        List<Double> doubleArray = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        StatisticUtilsArrayList bob = new StatisticUtilsArrayList();
        return bob.getMedian(doubleArray);

    }

    public double getMean(List<T> givenList){
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");

        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))

            throw new IllegalArgumentException("Input arraylist mean calculation cannot contain infinity");


        List<Double> doubleArray = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        StatisticUtilsArrayList bob = new StatisticUtilsArrayList();
        return bob.getMean(doubleArray);
    }

    public double getStandardDeviation(List<T> givenList){
        if (givenList == null || givenList.size() == 0)

            throw new IllegalArgumentException("Input arraylist max calculation cannot be null or empty");

        if (givenList.contains(NEGATIVE_INFINITY) || givenList.contains(POSITIVE_INFINITY))

            throw new IllegalArgumentException("Input arraylist Standard Deviation calculation cannot contain infinity");


        List<Double> doubleArray = givenList.stream().map(Number::doubleValue).collect(Collectors.toList());
        StatisticUtilsArrayList bob = new StatisticUtilsArrayList();
        return bob.getStandardDeviation(doubleArray);
    }


}