package com.heiha.sinfonia.lab.parttern.visitor.mechanic;

import com.heiha.sinfonia.lab.parttern.visitor.car.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author singoasher
 * @date 2017/12/13
 */
public class MechanicTest {
    @Test
    public void visit() throws Exception {
        Car car = new Car();

        Mechanic mechanic = new QualifiedMechanic();
        car.accept(mechanic);
        System.out.println(car.toString());

        Mechanic mechanicBad = new NonQualifiedMechanic();
        car.accept(mechanicBad);
        System.out.println(car.toString());
    }
}