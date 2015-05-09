package com.flightqueue.flightqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A wrapper class that exposes certain
 * functions only.
 * Created by niteshreddy on 5/9/15.
 */
public class FlightQueue {

    private Comparator<AirPlane> flightComparator;
    private PriorityQueue<AirPlane> airPlaneQueue;

    public void FlightQueue(){
        flightComparator = new AirPlaneComparator();
        airPlaneQueue = new PriorityQueue<AirPlane>(100,flightComparator);
    }

    public void enQueue(AirPlane ap){
        airPlaneQueue.add(ap);
    }

    public AirPlane deQueue(){

        return airPlaneQueue.poll();

    }



    public int returnTwo(){
        return 2;
    }
}
