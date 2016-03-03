package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/3/3
 * @time 下午3:30
 */
public class ExcelSheetColumnNumber {

    public int titileToNumber(String s) {
        String tmp = s.toUpperCase();
        int result = 0;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            int num = tmp.charAt(i) - 'A' + 1;
            result += (int) (Math.pow(26, tmp.length() - 1 - i)) * num;
        }

        return result;
    }
}
