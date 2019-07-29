package com.sun.problem;

import com.sun.utils.Logger;
import com.sun.utils.LoggerFactory;

/**
 * 剑指 11题
 * 考察细心，全面高效的代码实现
 * 求一个数的平方
 *
 * 考虑输入的情况，判断 指数是否 >0 ? <= 0
 * 同时，如果指数为偶数的话，例如 x^8 = (x^4)^2 = (x^2)^2 * (x^2)^2，可以减少乘的次数
 * 如果为奇数的话，例如 x^7 = (x^3) * (x^3) * x
 * 这里可以用到递归
 * x^n = a ^ (n/2) * a ^ (n/2); n 为偶数的时候
 * x^n = a ^ ((n-1)/2) * a ^ ((n-1)/2) * a; n为奇数的时候
 */
public class Problem_11_Power {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(Problem_11_Power.class);
        logger.d("power(4, 5) = " + power(4, 5));
        logger.d("power(4, -5) = " + power(4, -5));
        logger.d("power(4, 0) = " + power(4, 0));
        logger.d("power(4, 4) = " + power(4, 4));
        logger.d("power(4, -4) = " + power(4, -4));
        logger.d("power(0, 4) = " + power(0, 4));
        logger.d("power(-2, 4) = " + power(-2, 4));
    }

    public static double power(double base, int exp){
        if (base == 0.0){
            return 0;
        }
        if (exp < 0){
            double result = power0(base, -exp);
            return 1.0 / result;
        }
        return power0(base, exp);
    }

    private static double power0(double base, int exp){
        if (exp == 0){
            return 1;
        }
        double result = power0(base, exp >> 1);
        // 进行平方
        result *= result;
        // 判断奇数还是偶数
        if ((exp & 1) == 1){
            // 奇数
            result *= base;
        }
        return result;
    }

}
