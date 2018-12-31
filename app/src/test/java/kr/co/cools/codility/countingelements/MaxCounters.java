package kr.co.cools.codility.countingelements;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] A); }
 *
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 */
public class MaxCounters {

    @Test
    public void test() {
        int[] A = {3,4,4,6,1,4,4};
        int[] result = solution(5, A);
        Assert.assertEquals(3, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(2, result[2]);
        Assert.assertEquals(4, result[3]);
        Assert.assertEquals(2, result[4]);
    }

    @Test
    public void test1() {
        int[] A = {3,4,4,6,1,4,4};
        int[] result = solution(6, A);
        Assert.assertEquals(3, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(2, result[2]);
        Assert.assertEquals(4, result[3]);
        Assert.assertEquals(2, result[4]);
    }

    @Test
    public void test2() {
        int[] A = {3,4,4,6,1,4,4};
        int[] result = solution(6, A);
        Assert.assertEquals(3, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(2, result[2]);
        Assert.assertEquals(4, result[3]);
        Assert.assertEquals(2, result[4]);
    }

    @Test
    public void test3() {
        int[] A = {3,4,4,6,1,4,4};
        int[] result = solution(1, A);
        Assert.assertEquals(3, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(2, result[2]);
        Assert.assertEquals(4, result[3]);
        Assert.assertEquals(2, result[4]);
    }

    public int[] solution(int N, int[] A) {
        if(N <= 0) return new int[N];
        if(A == null || A.length == 0) return new int[N];


        int[] result = new int[N];

        int maxValue = 0;
        for(int i = 0; i < A.length; i++){
            int index = A[i];
            if(index <= N){
                result[index - 1]++;
                maxValue = Math.max(maxValue, result[index - 1]);
            }else{
                for(int j = 0; j < result.length; j++){
                    result[j] = maxValue;
                }
            }
        }

        return result;
    }
}
