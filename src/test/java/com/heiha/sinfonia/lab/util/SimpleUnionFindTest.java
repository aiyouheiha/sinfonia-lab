package com.heiha.sinfonia.lab.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/6 10:54<br>
 * <b>Author:</b> heiha<br>
 */
public class SimpleUnionFindTest {
    @Test
    public void test() throws Exception {
        SimpleUnionFind unionFind = new SimpleUnionFind(10);
        unionFind.union(4, 0);
        unionFind.union(3, 0);
        unionFind.union(2, 0);
        unionFind.union(1, 2);
        unionFind.union(6, 5);
        unionFind.union(7, 5);
        unionFind.union(8, 5);
        unionFind.union(9, 8);
        System.out.println(unionFind.getSubsetNum());
        for (int i = 0; i < 10; i++) {
            System.out.println(unionFind.find(i));
        }
    }
}