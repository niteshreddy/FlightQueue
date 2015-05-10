package com.flightqueue.flightqueue;

import java.util.Date;

/** A Class that represents a PassengerPlane
 * which is a type of plane.
 * Created by niteshreddy on 5/9/15.
 */
public class PassengerPlane extends AirPlane {

    public PassengerPlane(String name, String size){
        this.setName(name);
        this.setSize(size);
        this.setDate(new Date());
    }

}
