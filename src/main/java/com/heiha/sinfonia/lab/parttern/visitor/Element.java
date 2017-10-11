package com.heiha.sinfonia.lab.parttern.visitor;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/19 14:53<br>
 * <b>Author:</b> heiha<br>
 */
public interface Element {
    String info();
    void accept(Visitor visitor);
}

class Element1 implements Element {

    @Override
    public String info() {
        return "Element1";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Element2 implements Element {

    @Override
    public String info() {
        return "Element2";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}