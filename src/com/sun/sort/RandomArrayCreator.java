package com.sun.sort;

public class RandomArrayCreator {

    public static int[] createArray(int min, int max, int num){
        if (min >= max || num <= 0){
            return null;
        }
        int[] result = new int[num];
        for (int i = 0; i < num; ++ i){
            result[i] = (int)(1+Math.random()*(max - min +1));
        }
        return result;
    }
}
