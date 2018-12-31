package kr.co.cools.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class PermMissingElem {

    @Test
    public void test() {
        int[] data = {2, 3, 1, 5};
        int result = solution(data);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test1() {
        int[] data = {};
        int result = solution(data);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] data = null;
        int result = solution(data);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[] data = {1,2,4,5,6,7,8,9,11};
        int result = solution(data);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test4() {
        int[] data = {1};
        int result = solution(data);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test5() {
        int[] data = {2,3,4};
        int result = solution(data);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test6() {
        int[] data = new int[100000];
        for(int i = 0; i < data.length; i++){
            data[i] = i + 1;
        }
        int result = solution(data);
        Assert.assertEquals(100001, result);
    }

    @Test
    public void test7() {
        int[] data = {2};
        int result = solution(data);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test8() {
        int[] data = {1};
        int result = solution(data);
        Assert.assertEquals(2, result);
    }




    public int solution(int[] inputDatas) {
        if(inputDatas == null || inputDatas.length == 0) return 1;

        Arrays.sort(inputDatas);

        if(inputDatas[0] != 1) return 1;
        if(inputDatas.length == 1) return inputDatas[0] + 1;

        int savedValue = inputDatas[0];
        for(int i = 1; i < inputDatas.length; i++){
            if(savedValue + 1 != inputDatas[i]){
                return savedValue + 1;
            }
            savedValue = inputDatas[i];
        }
        return inputDatas[inputDatas.length - 1] + 1;
    }
}
