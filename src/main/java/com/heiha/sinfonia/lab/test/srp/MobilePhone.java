package com.heiha.sinfonia.lab.test.srp;

import lombok.Data;

/**
 * @author singoasher
 * @date 2017/12/12
 */
@Data
public abstract class MobilePhone {
    protected String ram;
    protected String rom;
    protected String cpu;
    protected Integer size;

    public abstract void charge(Charger charger);
    public abstract void call(String phoneNumber);
}
