package com.heiha.sinfonia.lab.parttern.visitor;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/19 16:56<br>
 * <b>Author:</b> heiha<br>
 */
class Parent {
    public String accept(FoobarVisitor visitor) {
        return visitor.visit(this);
    }
}

class Child extends Parent {
    @Override
    public String accept(FoobarVisitor visitor) {
        // 注意此方法必须重写，否则this将无法指代Child
        return visitor.visit(this);
    }
}

class FoobarVisitor {

    public String visit(Parent parent) {
        return "Parent";
    }

    public String visit(Child child) {
        return "Child";
    }
}

class FooVisitor extends FoobarVisitor {
    @Override
    public String visit(Parent parent) {
        return "P";
    }

    @Override
    public String visit(Child child) {
        return "C";
    }
}

class Foobar {
    private FoobarVisitor foobarVisitor = new FoobarVisitor();

    public void baz(Parent p1, Parent p2) {
        System.out.println(p1.accept(foobarVisitor) + p2.accept(foobarVisitor));
    }

    public void baz(Parent p, Child c) {
        System.out.println(p.accept(foobarVisitor) + c.accept(foobarVisitor));
    }

    public void baz(Child c1, Child c2) {
        System.out.println(c1.accept(foobarVisitor) + c2.accept(foobarVisitor));
    }
}

public class Foo extends Foobar {
    private FoobarVisitor foobarVisitor = new FooVisitor();

    @Override
    public void baz(Parent p1, Parent p2) {
        System.out.println(p1.accept(foobarVisitor) + p2.accept(foobarVisitor));
    }

    @Override
    public void baz(Parent p, Child c) {
        System.out.println(p.accept(foobarVisitor) + c.accept(foobarVisitor));
    }

    @Override
    public void baz(Child c1, Child c2) {
        System.out.println(c1.accept(foobarVisitor) + c2.accept(foobarVisitor));
    }

    public static void main(String[] args) {
        Foobar foobar = new Foobar(); // 实际类型：Foobar
        Foo foo = new Foo(); // 实际类型 Foo
        Foobar bar = new Foo(); // 实际类型 Foo

        Parent p = new Parent(); // 实际类型：Parent
        Parent pc = new Child(); // 实际类型：Child
        Child c = new Child(); // 实际类型：Child

        foobar.baz(p, p);
        foobar.baz(p, pc);
        foobar.baz(p, c);
    }
}
