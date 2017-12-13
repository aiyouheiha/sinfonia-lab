package com.heiha.sinfonia.lab.parttern.visitor.mechanic;

import com.heiha.sinfonia.lab.parttern.visitor.car.CarComponent;

/**
 * @author singoasher
 * @date 2017/12/13
 */
public class QualifiedMechanic implements Mechanic {
    @Override
    public void visit(CarComponent carComponent) {
        carComponent.setBroken(false);
    }

    @Override
    public MechanicId getMechanicId() {
        return MechanicId.BEST_ONE;
    }
}
