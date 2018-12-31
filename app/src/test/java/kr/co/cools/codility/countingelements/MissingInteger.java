package kr.co.cools.codility.countingelements;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MissingInteger {

    @Test
    public void test() {
        int[] A = {1, 3, 6, 4, 1, 2};
        int result = solution(A);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test1() {
        int[] A = {};
        int result = solution(A);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] A = null;
        int result = solution(A);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[] A = {1};
        int result = solution(A);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test4() {
        int[] A = {1, 3};
        int result = solution(A);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test5() {
        int[] A = {1, 2, 3};
        int result = solution(A);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test6() {
        int[] A = {-1, -2};
        int result = solution(A);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test7() {
        int[] A = {2};
        int result = solution(A);
        Assert.assertEquals(1, result);
    }

    public int solution(int[] A){
        if(A == null || A.length == 0) return 1;
        if(A.length == 1) return A[0] != 1 ? 1 : 2;
        Arrays.sort(A);

        int positiveValue = 0;

        for(int i = 0; i < A.length - 1; i++){
            if(A[i] < 1 || A[i] == A[i + 1]) continue;

            if(positiveValue == 0){
               if(A[i] != 1){
                   return 1;
               }
                positiveValue = 1;
            }

            int value = A[i + 1] - A[i];
            if(value != 1){
                return A[i] + 1;
            }
        }
        return positiveValue == 0 ? 1: A[A.length - 1] + 1;
    }
}

