package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/26
 * @time 下午4:47
 */
public class AddDigits {

    public int addDigits(int num) {
        if(num<10){
            return num;
        }else{
            return addDigits(num % 10 + addDigits(num/10));
        }
    }

    public static void main(String[] args){
        AddDigits a = new AddDigits();
        System.out.println(a.addDigits(38));
    }
}
