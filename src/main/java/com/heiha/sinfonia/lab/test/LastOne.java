package com.heiha.sinfonia.lab.test;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/13 18:28<br>
 * <b>Author:</b> Topashman<br>
 */
public class LastOne {
    public String lastOne() {
        int result = lastOne(13, 10);
        switch (result) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(result);
        }
    }

    private int lastOne(int size, int step) {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            cards.add(i);
        }
        int start = 0;
        while (size > 1) {
            start = ((start + step) % size - 1 + size)%size;
            cards.remove(start);
            size --;
        }
        return cards.get(0);
    }


    public static void main(String[] args) {
        LastOne lastOne = new LastOne();
        System.out.println(lastOne.lastOne());
    }
}
