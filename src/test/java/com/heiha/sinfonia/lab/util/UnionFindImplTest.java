package com.heiha.sinfonia.lab.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/7 11:21<br>
 * <b>Author:</b> heiha<br>
 */
public class UnionFindImplTest {
    @Test
    public void test() throws Exception {
        String apple = "Apple";
        String orange = "Orange";
        String banana = "Banana";
        String keyboard = "Keyboard";
        String mouse = "Mouse";
        String desk = "Desk";
        Set<String> set = new HashSet<>();
        set.add(apple);
        set.add(orange);
        set.add(banana);
        set.add(keyboard);
        set.add(mouse);
        set.add(desk);
        UnionFindImpl<String> unionFind = new UnionFindImpl<>(set);
        unionFind.union(orange, apple);
        unionFind.union(banana, orange);
        unionFind.union(mouse, keyboard);
        System.out.println(unionFind.getSubsetNum());
        System.out.println(unionFind);
    }
}