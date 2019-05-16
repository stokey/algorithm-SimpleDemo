package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C11Power {
    /**
     * 求base的exponent次方【不考虑大数问题】
     * 【有大量重复计算，效率问题】
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        if (isEqual(base, 0.0)) {
            if (exponent < 0) {
                throw new RuntimeException("input error");
            } else if (exponent == 0) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            return base;
        }
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 求base的exponent次方【不考虑大数问题】
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double powerAdvance(double base, int exponent) {
        if (isEqual(base, 0.0)) {
            if (exponent < 0) {
                throw new RuntimeException("input error");
            } else if(exponent == 0){
                return 1;
            } else {
                return 0;
            }
        }
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = powerUnsigned(base, absExponent);

        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * base^2 base^4 base^(2^n)
     *
     * @param base
     * @param exponent
     * @return
     */
    private static double powerUnsigned(double base, int exponent) {
        if (isEqual(0.0, base)) {
            if (exponent < 0) {
                throw new RuntimeException("input error");
            } else if (exponent == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        double result = powerUnsigned(base, exponent >> 1);
        // n为偶数 a^n = a^(n/2) * a^(n/2)
        result *= result;
        if ((exponent & 0x1) == 1) {
            // n为基数 a^n = a^(n-1)/2 * a^(n-1)/2 * a
            result *= base;
        }
        return result;
    }

    // TODO 考虑大数 怎么处理？

    private static boolean isEqual(double i, double j) {
        if (Math.abs(i - j) < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }
}

class C11Test {
    public static void main(String[] args) {
        System.out.println("2 pow 4 is " + C11Power.power(2, 4));
        System.out.println("0 pow 0 is " + C11Power.power(0, 0));
        System.out.println("0 pow 2 is " + C11Power.power(0, 2));

        System.out.println("2 pow 16 is " + C11Power.powerAdvance(2, 16));
    }
}
