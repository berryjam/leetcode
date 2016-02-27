package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午9:30
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        return null;
    }

    public static void main(String[] args){
        FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(1,2));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(2,1));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(2,3));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(1,99));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(1,6));
    }
}
