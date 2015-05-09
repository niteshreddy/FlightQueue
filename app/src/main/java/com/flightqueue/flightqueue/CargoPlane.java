package com.flightqueue.flightqueue;

import java.util.Date;

/**
 * Created by niteshreddy on 5/9/15.
 */
public class CargoPlane extends AirPlane {

    public CargoPlane(String name, String size){
        this.setName(name);
        this.setSize(size);
        this.setDate(new Date());
    }
}
