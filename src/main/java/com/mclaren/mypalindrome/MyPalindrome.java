package com.mclaren.mypalindrome;

import com.mclaren.mypalindrome.domain.entities.PalindromeModel;

import java.util.*;

/**
 * MyPalindrome class contains all the logic.
 */
public class MyPalindrome {

    /**
     * Constructor.
     */
    public MyPalindrome() {
    }

    /**
     * Check if a given str is a MyPalindrome or not.
     *
     * @param str String to test.
     * @return
     */
    public boolean isPalindrome(String str) {

        Integer nb = str.length();
        for (Integer i = 0; i < (nb / 2); ++i) {
            if (str.charAt(i) != str.charAt(nb - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main MyPalindrome algorithm.
     *
     * @param str String to test.
     * @return
     */
    public TreeMap<Integer, List<PalindromeModel>> getAllPalindromes(String str) {

        TreeMap<Integer, List<PalindromeModel>> model = new TreeMap<Integer, List<PalindromeModel>>();
        str = cleanToken(str);

        Integer strLength = str.length();
        for (Integer start = 0; start < strLength; start++) {
            for (Integer end = strLength - 1; end > start; end--) {

                char strStart = str.charAt(start);
                char strEnd = str.charAt(end);

                if (strStart == strEnd) {
                    if (isPalindrome(str.substring(start, end + 1))) {
                        store(str, model, start, end);
                        start = end + 1;
                        end = strLength;
                    }
                }
            }
        }
        TreeMap<Integer, List<PalindromeModel>> rev = new TreeMap(Collections.reverseOrder());
        rev.putAll(model);

        return rev;
    }

    /**
     * Store the found Palindrome into a TreeMap.
     *
     * @param str
     * @param model
     * @param start
     * @param end
     */
    private void store(String str, TreeMap<Integer, List<PalindromeModel>> model, Integer start, Integer end) {
        Integer palindromeLength = end - start + 1;

        PalindromeModel palindromeModel = new PalindromeModel();
        palindromeModel.setIndex(start);
        palindromeModel.setText(str.substring(start, end + 1));

        if (!model.containsKey(palindromeLength)) {
            List<PalindromeModel> palindromeTreeMapInfoList = new ArrayList<PalindromeModel>();
            palindromeTreeMapInfoList.add(palindromeModel);
            model.put(palindromeLength, palindromeTreeMapInfoList);
        } else {
            List<PalindromeModel> palindromeTreeMapInfoList = model.get(palindromeLength);
            palindromeTreeMapInfoList.add(palindromeModel);
            model.put(palindromeLength, palindromeTreeMapInfoList);
        }
    }

    /**
     * Output the final result
     *
     * @param str
     * @param index
     * @param length
     * @return
     */
    public String outputPalindromeResult(String str, Integer index, Integer length) {
        return "Text: " +
                str + ", " +
                "Index: " +
                index + ", " +
                "Length: " + length + "\n";
    }

    /**
     * @param str String to test.
     * @return
     */
    public String displayAllPalindrome(String str) {

        if (str.equals("")) {
            return "Invalid str to test.";
        }

        str = cleanToken(str);

        MyPalindrome myPalindrome = new MyPalindrome();
        String outputPalindromes = "";

        Integer maxNbPalindrome = 0;
        TreeMap<Integer, List<PalindromeModel>> allPalindromes = myPalindrome.getAllPalindromes(str);

        for (Map.Entry<Integer, List<PalindromeModel>> entry : allPalindromes.entrySet()) {

            if (maxNbPalindrome == 3) continue;

            for (PalindromeModel palindromeModel : entry.getValue()) {
                outputPalindromes = outputPalindromes + outputPalindromeResult(
                        palindromeModel.getText(), palindromeModel.getIndex(), entry.getKey());
            }
            maxNbPalindrome++;
        }
        return outputPalindromes;
    }

    /**
     * @param word
     * @return
     */
    private static String cleanToken(String word) {
        String str = word.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        char[] currentChar = str.toCharArray();
        return String.valueOf(currentChar);
    }

}
