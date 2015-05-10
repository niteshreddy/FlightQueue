package com.flightqueue.flightqueue;

import java.util.Date;

/**
 * A class that repesents Cargo Plane
 * which is a type of AirPlane.
 * Created by niteshreddy on 5/9/15.
 */
public class CargoPlane extends AirPlane {

    public CargoPlane(String name, String size){
        this.setName(name);
        this.setSize(size);
        this.setDate(new Date());
    }
}
