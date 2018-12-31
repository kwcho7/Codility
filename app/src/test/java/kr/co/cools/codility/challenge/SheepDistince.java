package kr.co.cools.codility.challenge;

import org.junit.Assert;
import org.junit.Test;

public class SheepDistince {

    @Test
    public void test() {
        int[] X = {0, 0, 10, 10};
        int[] Y = {0, 10, 0, 10};

        int result = solution(X, Y);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test1() {
        //  Given X=[1, 1, 8] and Y=[1, 6, 0],
        int[] X = {1, 1, 8};
        int[] Y = {1, 6, 0};

        int result = solution(X, Y);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() {
        //  Given X=[1, 1, 8] and Y=[1, 6, 0],
        int[] X = {0, 2};
        int[] Y = {0, 0};

        int result = solution(X, Y);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        //  Given X=[1, 1, 8] and Y=[1, 6, 0],
        int[] X = {10, 20, 100};
        int[] Y = {10, 20, 100};

        int result = solution(X, Y);
        Assert.assertEquals(5, result);
    }

    public int solution(int[] X, int[] Y) {
        int dX = Integer.MAX_VALUE;
        int dY = Integer.MAX_VALUE;

        for(int i = 1; i < X.length; i++){
            int xRet = Math.abs(X[0] - X[i]);

            if(xRet != 0){
                dX = Math.min(dX, xRet);
            }

            int yRet = Math.abs(Y[0] - Y[i]);
            if(yRet != 0){
                dY = Math.min(dY, yRet);
            }
        }
        if(dX == 0) return dY /2;
        if(dY == 0) return dX /2;
        return Math.min(dX, dY)/2;
    }
}
