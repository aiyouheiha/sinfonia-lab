package com.heiha.sinfonia.lab.parttern.visitor.car;

import com.heiha.sinfonia.lab.parttern.visitor.mechanic.Mechanic;
import lombok.Data;

/**
 * 汽车组件，被访问元素
 *
 * @author singoasher
 * @date 2017/12/13
 */
@Data
public abstract class CarComponent {
    protected boolean broken = false;

    /**
     * 接收访问
     *
     * @param mechanic 质检员，访问者
     */
    public abstract void accept(Mechanic mechanic);
}
