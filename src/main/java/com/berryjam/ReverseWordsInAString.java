package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/29
 * @time 下午1:57
 */
public class ReverseWordsInAString {
    public static final int SPACE_MODE = 1;
    public static final int WORD_MODE = 2;
    public static final int INIT_MODE = 0;

    public String reverseWords(String s) {
        int mode = INIT_MODE;
        String tmp = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (mode) {
                case INIT_MODE:
                    if (ch == ' ') {
                        mode = SPACE_MODE;
                    } else {
                        mode = WORD_MODE;
                        tmp += ch;
                        if (i == s.length() - 1) {
                            if (!result.equals("")) {
                                result = tmp + ' ' + result;
                            } else {
                                result = tmp;
                            }
                        }
                    }
                    break;
                case SPACE_MODE:
                    if (ch != ' ') {
                        mode = WORD_MODE;
                        tmp += ch;
                        if (i == s.length() - 1) {
                            if (!result.equals("")) {
                                result = tmp + ' ' + result;
                            } else {
                                result = tmp;
                            }
                        }
                    }
                    break;
                case WORD_MODE:
                    if (ch == ' ') {
                        mode = SPACE_MODE;
                        if (!result.equals("")) {
                            result = tmp + ' ' + result;
                        } else {
                            result = tmp;
                        }
                        tmp = "";
                    } else {
                        tmp += ch;
                        if (i == s.length() - 1) {
                            if (!result.equals("")) {
                                result = tmp + ' ' + result;
                            } else {
                                result = tmp;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseWordsInAString s = new ReverseWordsInAString();
        System.out.println(s.reverseWords("1 "));
    }
}
