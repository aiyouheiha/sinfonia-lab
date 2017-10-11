package com.heiha.sinfonia.lab.parttern.visitor;

import com.heiha.sinfonia.lab.parttern.visitor.Element;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/18 11:25<br>
 * <b>Author:</b> heiha<br>
 */
public interface Visitor {
    void visit(Element1 element1);
    void visit(Element2 element2);
}

class Visitor1 implements Visitor {

    @Override
    public void visit(Element1 element1) {
        System.out.println("Visitor1 " + element1.info());
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println("Visitor1 " + element2.info());
    }
}

class Visitor2 implements Visitor {

    @Override
    public void visit(Element1 element1) {
        System.out.println("Visitor2 " + element1.info());
    }

    @Override
    public void visit(Element2 element2) {
        System.out.println("Visitor2 " + element2.info());
    }
}