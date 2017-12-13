package com.heiha.sinfonia.lab.parttern.visitor.car;

import com.heiha.sinfonia.lab.parttern.visitor.mechanic.Mechanic;
import lombok.Data;

/**
 * @author singoasher
 * @date 2017/12/13
 */
@Data
public class Car extends CarComponent {
    private Engine engine;
    private Wheel wheel;
    private Brake brake;

    public Car() {
        this.engine = new Engine();
        this.wheel = new Wheel();
        this.brake = new Brake();
    }

    @Override
    public void accept(Mechanic mechanic) {
        switch (mechanic.getMechanicId()) {
            case BAD_GUY:
                System.out.println("检修刹车");
                this.brake.accept(mechanic);
                break;
            case BEST_ONE:
                System.out.println("检修轮子和发动机");
                this.wheel.accept(mechanic);
                this.engine.accept(mechanic);
                break;
            default:
                break;
        }
    }
}
