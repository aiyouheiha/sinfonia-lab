package com.heiha.sinfonia.lab.parttern.visitor.basic;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/19 15:17<br>
 * <b>Author:</b> heiha<br>
 */
public class Client {
    public static void main(String[] args) {
        Element e1 = new Element1();
        Element e2 = new Element2();

        Visitor v1 = new Visitor1();
        Visitor v2 = new Visitor2();

        e1.accept(v1);
        e1.accept(v2);

        e2.accept(v1);
        e2.accept(v2);
    }
}
