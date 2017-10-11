package com.heiha.sinfonia.lab.parttern.decorator;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/11 10:58<br>
 * <b>Author:</b> Topashman<br>
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("I am ConcreteComponent");
    }
}
