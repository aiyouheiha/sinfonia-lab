package com.heiha.sinfonia.lab.parttern.decorator;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/11 11:08<br>
 * <b>Author:</b> Topashman<br>
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehaviorA();
    }

    private void addBehaviorA() {
        System.out.println("This behavior was added by ConcreteDecoratorA.");
    }
}
