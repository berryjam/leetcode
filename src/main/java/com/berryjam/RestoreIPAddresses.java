package com.berryjam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjinkun.
 * @date 16/8/14
 * @time 上午10:02
 */
public class RestoreIPAddresses {


    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.equals("")) {
            List<String> result = new ArrayList<String>();
            return result;
        }
        List<String> result = restoreIpAddresses(s, 0, 1);
        if (result == null) {
            result = new ArrayList<String>();
        }
        return result;
    }

    private List<String> restoreIpAddresses(String s, int index, int nums) {
        if (nums == 4) {
            if (index > s.length() - 1) {
                return null;
            }
            String numStr = s.substring(index);
            if (numStr.length() > 9 || (index + 1 < s.length() && s.substring(index, index + 1).equals("0") &&
                    numStr.length() > 1)) {
                return null;
            }
            int num = Integer.parseInt(numStr);
            if (num >= 0 && num <= 255) {
                List<String> result = new ArrayList<String>();
                result.add(numStr);
                return result;
            } else {
                return null;
            }
        } else {
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < 3; i++) {
                if (index < s.length() && index + i + 1 <= s.length()) {
                    String prefix = s.substring(index, index + i + 1);
                    if (prefix.substring(0, 1).equals("0") && prefix.length() > 1) {
                        continue;
                    }
                    if (Integer.parseInt(prefix) >= 0 && Integer.parseInt(prefix) <= 255) {
                        List<String> postfixIps = restoreIpAddresses(s, index + i + 1, nums + 1);
                        if (postfixIps != null) {
                            for (String postfixIp : postfixIps) {
                                result.add(prefix + "." + postfixIp);
                            }
                        }
                    }
                }
            }
            if (result.size() == 0) {
                return null;
            }
            return result;
        }
    }

    @Test
    public void testRestoreIpAddresses() {
        List<String> ips = restoreIpAddresses("010010");
        if (ips != null) {
            for (String s : ips) {
                System.out.println(s);
            }
        }
    }
}
