package com.heiha.sinfonia.lab.parttern.decorator;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/11 10:59<br>
 * <b>Author:</b> Topashman<br>
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("split+++++++++++++++++++++++++++");
        Component decoratorComponent = new ConcreteDecoratorA(component);
        decoratorComponent.operation();
        System.out.println("split+++++++++++++++++++++++++++");
        Component decoratorComponent2 = new ConcreteDecoratorB(decoratorComponent);
        decoratorComponent2.operation();
    }
}
