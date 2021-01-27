package com.pckt.cookbook;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

@RunWith(Parameterized.class)
public class AscendingMinimaTest {
    enum Type {ASC_MIN,EXCEPTION}
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {AscendingMinimaTest.Type.ASC_MIN,new double[] {5.0, 1.0, 3.0, 2.0, 6.0, 8.0, 4.0, 6.0}, 3, new Double[] {1.0, 1.0, 2.0, 2.0, 4.0, 4.0}},
                {AscendingMinimaTest.Type.ASC_MIN,new double[] {8,9,5,3,6,5,1,1,0}, 4, new Double[] {3.0, 3.0, 3.0, 1.0, 1.0, 0.0}},
                {AscendingMinimaTest.Type.ASC_MIN,new double[] {7,4,8,6,3,4,2,1,2}, 5, new Double[] {3.0, 3.0, 2.0, 1.0, 1.0}},
                {AscendingMinimaTest.Type.ASC_MIN,new double[] {1,2,3,4,5,6,7,8,9}, 1, new Double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0}},
                {AscendingMinimaTest.Type.EXCEPTION,new double[] {5.0, 1.0, 3.0}, -3, new Double[] {1.0}},
                {AscendingMinimaTest.Type.EXCEPTION,new double[] {5.0, 1.0, 3.0}, 0, new Double[] {1.0}},
                {AscendingMinimaTest.Type.EXCEPTION,new double[] {5.0, 1.0, 3.0}, 5, new Double[] {1.0}},
                {AscendingMinimaTest.Type.EXCEPTION,new double[] {}, -3, new Double[] {1.0}},
                {AscendingMinimaTest.Type.EXCEPTION,null, -3, new Double[] {1.0}}

        });
    }

    private final AscendingMinima calculator;
    private  final double[] array;
    private  final Double[] actual_array;
    private  final int window_size;
    private  final AscendingMinimaTest.Type type;

    public AscendingMinimaTest(AscendingMinimaTest.Type type,double[] array,int window_size,
                               Double[] actual_array){
        this.type = type;
        this.calculator = new AscendingMinima();
        this.array = array;
        this.actual_array = actual_array;
        this.window_size = window_size;
    }

    @Test
    public void testAscendingMinima() {
        assumeTrue(Type.ASC_MIN == type);
        Assert.assertArrayEquals(calculator.getRequested_exit(array,window_size), actual_array );
    }

    @Test
    public void testMaxException() {
        assumeTrue(type == Type.EXCEPTION);
        try {
            calculator.getRequested_exit(array,window_size);
            fail("didn't throw an exception in getRequested_exit method in AscendingMinimaTest class!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception  in getRequested_exit method in AscendingMinimaTest class");
        }
    }

}