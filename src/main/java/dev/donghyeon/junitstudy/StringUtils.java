package dev.donghyeon.junitstudy;

public class StringUtils {

    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
