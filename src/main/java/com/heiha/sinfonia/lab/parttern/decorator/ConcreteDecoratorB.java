package com.heiha.sinfonia.lab.parttern.decorator;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/11 11:38<br>
 * <b>Author:</b> Topashman<br>
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehaviorB();
    }

    private void addBehaviorB() {
        System.out.println("This behavior was added by ConcreteDecoratorB.");
    }
}
