package com.flightqueue.flightqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class intializes a quque
 * and gives functions to queue, dequeue a plane
 * Created by niteshreddy on 5/9/15.
 */
public class FlightQueue {

    private static FlightQueue sInstance = null;

    /**
     *Custom comparator to queue the planes.
     */
    private Comparator<AirPlane> flightComparator;

    /**
     *Priority quque implementing the custom comparator.
     */
    private PriorityQueue<AirPlane> airPlaneQueue;

    /**
     * Initialize the comparator and quque.
     */
    private FlightQueue(){
        flightComparator = new AirPlaneComparator();
        airPlaneQueue = new PriorityQueue<AirPlane>(10,flightComparator);
    }

    /**
     *
     * @return singleton object of FlightQueue
     */
    public static FlightQueue getInstance(){
        if(sInstance == null){
            sInstance = new FlightQueue();
        }

        return sInstance;
    }

    /**
     * Enqueue an AirPlane
     * @param ap
     */
    public void enQueue(AirPlane ap){

        airPlaneQueue.add(ap);
    }

    /**
     * Dequeue an airplane, if nothing is present in the queue
     * then the functione returns a null.
     * @return
     */
    public AirPlane deQueue(){

        return airPlaneQueue.poll();

    }

    /**
     * Clears the queue of all planes.
     */
    public void clearQueue(){
        airPlaneQueue.clear();
    }


}