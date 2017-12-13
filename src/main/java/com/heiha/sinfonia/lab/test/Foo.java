package com.heiha.sinfonia.lab.test;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/13 10:20<br>
 * <b>Author:</b> Topashman<br>
 */
public class Foo {
    public void foo(int i) {
        System.out.println(i);
    }

    public void foo(int i, int j) {
        System.out.println(i + j);
    }

    public void foo(String s) {
        System.out.println(s);
    }

    public void foo(Parent p) {
        System.out.println("Parent");
    }

    public void foo(Child c) {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Parent child = new Child();
        Child c = new Child();

        foo.foo(1); // 1
        foo.foo(1, 2); // 3
        foo.foo("Hello"); // Hello
        foo.foo(child); // Parent
        foo.foo(c); // Child
    }
}

class Parent {

}

class Child extends Parent {

}