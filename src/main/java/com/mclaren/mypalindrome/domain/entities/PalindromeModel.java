package com.mclaren.mypalindrome.domain.entities;

import java.util.Objects;

/**
 * MyPalindrome Model class.
 */
public class PalindromeModel {

    private String text;

    private int index;

    public PalindromeModel() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalindromeModel that = (PalindromeModel) o;
        return index == that.index &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, index);
    }

    @Override
    public String toString() {
        return "PalindromeModel{" +
                "text='" + text + '\'' +
                ", index=" + index +
                '}';
    }
}
