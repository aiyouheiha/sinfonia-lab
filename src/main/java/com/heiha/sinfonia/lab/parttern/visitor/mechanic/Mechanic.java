package com.heiha.sinfonia.lab.parttern.visitor.mechanic;

import com.heiha.sinfonia.lab.parttern.visitor.car.CarComponent;

/**
 * 质检员，汽车组件的访问者
 *
 * @author singoasher
 * @date 2017/12/13
 */
public interface Mechanic {
    /**
     * 访问方法
     *
     * @param carComponent 被访问元素
     */
    void visit(CarComponent carComponent);

    /**
     * 质检员编号
     *
     * @return 质检员编号
     */
    MechanicId getMechanicId();
}
