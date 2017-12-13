package com.heiha.sinfonia.lab.parttern.visitor.mechanic;

import com.heiha.sinfonia.lab.parttern.visitor.car.CarComponent;

/**
 * @author singoasher
 * @date 2017/12/13
 */
public class NonQualifiedMechanic implements Mechanic {
    @Override
    public void visit(CarComponent carComponent) {
        carComponent.setBroken(true);
    }

    @Override
    public MechanicId getMechanicId() {
        return MechanicId.BAD_GUY;
    }
}
