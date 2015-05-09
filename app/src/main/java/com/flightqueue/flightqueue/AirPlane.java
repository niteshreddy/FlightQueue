package com.flightqueue.flightqueue;

import java.util.Date;

/**
 * A simple java class that represents an AirPlane
 *
 * Created by niteshreddy on 5/9/15.
 */
public class AirPlane {

    //A plance can be either "large" or "small".
    private String size;
    private String name;
    //Date  at which the plane entereted the queue.
    private Date date;


    /**
     * Returns the size of plane.
     * @return String
     */
    public String getSize(){return this.size;}

    /**
     * Sets the size of the plane.
     * @param size
     */
    public void setSize(String size){
        this.size = size;
    }

    /**
     * Sets the name of this plane
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the name of this plane.
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets the date at which it entered the queue.
     * @param date
     */
    public void setDate(Date date) { this.date = date;}

    /**
     * Gets the date at which it entered the queue.
     * @return
     */
    public Date getDate(){return this.date;}
}
