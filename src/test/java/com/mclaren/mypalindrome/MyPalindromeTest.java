package com.mclaren.mypalindrome;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Main test class.
 */
public class MyPalindromeTest {

    private MyPalindrome myPalindrome = new MyPalindrome();

    @Before
    public void setup() {
        myPalindrome = new MyPalindrome();
    }

    @Test
    public void it_should_be_an_instance_of_palindrome_class() {
        MyPalindrome myPalindrome = new MyPalindrome();

        assertThat(myPalindrome, instanceOf(MyPalindrome.class));
    }

    @Test
    public void it_should_return_false_when_it_is_not_a_palindrome_string() {
        assertFalse(this.myPalindrome.isPalindrome("hello"));
    }

    @Test
    public void it_should_true_when_it_is_a_palindrome_string() {
        assertTrue(this.myPalindrome.isPalindrome("madam"));
    }

    @Test
    public void it_should_return_true_if_palindrome_contains_one_middle_letter() {
        assertTrue(this.myPalindrome.isPalindrome("bwb"));
    }

    @Test
    public void it_should_return_true_if_palindrome_contains_double_middle_letters() {
        assertTrue(this.myPalindrome.isPalindrome("oyyo"));
    }

    @Test
    public void it_should_display_three_palindrome_with_success() throws Exception {

        String inputString = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";

        MyPalindrome myPalindrome = new MyPalindrome();
        String threeLongestPalindromes = myPalindrome.displayAllPalindrome(inputString);

        assertEquals(threeLongestPalindromes, "Text: hijkllkjih, Index: 23, Length: 10\n" +
                "Text: defggfed, Index: 13, Length: 8\n" +
                "Text: abccba, Index: 5, Length: 6\n");
    }

}
