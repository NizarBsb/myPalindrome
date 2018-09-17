package com.mclaren.mypalindrome;

/**
 * Main class.
 */
public class App {

    /**
     * Entry point of MyPalindrome program.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Manually change the MyPalindrome String to test here.
        String testPalindrome = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";

        MyPalindrome myPalindrome = new MyPalindrome();
        System.out.println(myPalindrome.displayAllPalindrome(testPalindrome));
    }
}
