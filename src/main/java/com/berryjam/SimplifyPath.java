package com.berryjam;

/**
 * @author huangjinkun.
 * @date 16/2/28
 * @time 上午10:55
 */
public class SimplifyPath {

    public enum State {
        INIT, SLASH, DOT, DOUBLE_DOT, CHAR;
    }

    public String simplifyPath(String path) {
        if (path.equals("/../")) {
            return "/";
        }

        String result = "";
        State state = State.INIT;

        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (state) {
                case INIT:
                    if (ch == '/') {
                        state = State.SLASH;
                        result += ch;
                    } else if (ch == '.') {
                        state = State.DOT;
                    } else {
                        state = State.CHAR;
                        result += ch;
                    }
                    break;
                case SLASH:
                    if (ch == '/') {
                        // do nothing
                    } else if (ch == '.') {
                        state = State.DOT;
                    } else {
                        state = State.CHAR;
                        result += ch;
                    }
                    break;
                case DOT:
                    if (ch == '/') {
                        state = State.SLASH;
                    } else if (ch == '.') {
                        state = State.DOUBLE_DOT;
                        if (i == path.length() - 1) {
                            result = backDir(result);
                        }
                    } else {
                        state = State.CHAR;
                        result += "." + ch;
                    }
                    break;
                case DOUBLE_DOT:
                    if (ch == '/') {
                        state = State.SLASH;
                        result = backDir(result);
                    } else if (ch == '.') {
                        state = State.CHAR;
                        result += "...";
                    } else {
                        state = State.CHAR;
                        result += ".." + ch;
                    }
                    break;
                case CHAR:
                    if (ch == '/') {
                        state = State.SLASH;
                        result += ch;
                    } else {
                        result += ch;
                    }
                    break;
                default:
                    break;
            }
        }

        if (!result.equals("/") && result.charAt(result.length() - 1) == '/') {
            result = result.substring(0, result.length() - 1);
        }

        String finalResult = "";
        state = State.INIT;
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            switch (state) {
                case INIT:
                    if (ch == '/') {
                        state = State.SLASH;
                        finalResult += ch;
                    }
                    break;
                case SLASH:
                    if (ch == '/') {

                    } else {
                        state = State.CHAR;
                        finalResult += ch;
                    }
                    break;
                case CHAR:
                    if (ch == '/') {
                        state = State.SLASH;
                        finalResult += ch;
                    } else {
                        finalResult += ch;
                    }
            }
        }

        return finalResult;
    }

    private String backDir(String s) {
        int lastSlashIndex = s.lastIndexOf('/');
        if (lastSlashIndex >= 0) {
            s = s.substring(0, lastSlashIndex);
        }
        int lastSecondSlashIndex = s.lastIndexOf('/');
        if (lastSecondSlashIndex >= 0) {
            s = s.substring(0, lastSecondSlashIndex);
        }
        if (s.equals("")) {
            s = "/";
        }
        s += "/";
        return s;
    }

    public static void main(String[] args) {
        SimplifyPath path = new SimplifyPath();
        System.out.println(path.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
//        System.out.println(path.simplifyPath("/home/beidou/"));
        System.out.println(path.simplifyPath("/a/./b/../../c/"));
    }
}
