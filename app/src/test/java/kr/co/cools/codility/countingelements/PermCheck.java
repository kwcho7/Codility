package kr.co.cools.codility.countingelements;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 *
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 *
 * Given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class PermCheck {

    @Test
    public void test() {
        int[] A = {4,1,3,2};
        int result = solution(A);
        Assert.assertEquals(1, result);
    }


    @Test
    public void test1() {
        int[] A = {4,1,3};
        int result = solution(A);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test2() {
        int[] A = {1};
        int result = solution(A);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[] A = {};
        int result = solution(A);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test4() {
        int[] A = null;
        int result = solution(A);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test5() {
        int[] A = {3, 2};
        int result = solution(A);
        Assert.assertEquals(0, result);
    }


    public int solution(int[] A) {
        if(A == null || A.length == 0) return 0;

        Arrays.sort(A);
        if(A[0] != 1) return 0;

        for(int i = 0; i < A.length - 1; i++){
            if(A[i] + 1 != A[i+1]){
                return 0;
            }
        }
        return 1;
    }
}
