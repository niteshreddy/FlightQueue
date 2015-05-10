package com.flightqueue.flightqueue;

import android.os.SystemClock;
import android.util.Log;

import junit.framework.TestCase;
import com.flightqueue.flightqueue.FlightQueue;
import com.flightqueue.flightqueue.CargoPlane;
import com.flightqueue.flightqueue.PassengerPlane;

/**
 * Created by niteshreddy on 5/9/15.
 */
public class FlightQueueTest extends TestCase {

    private FlightQueue fq;
    private final String large = "large";
    private final String small = "small";


    protected void setUp() throws Exception {
        super.setUp();
        fq = new FlightQueue();
        // do initialization here, run on every test method

    }
    protected void tearDown() throws Exception {
        // do termination here, run on every test method
        super.tearDown();
    }

    /**
     * A basic test that simply makes sure that
     * the single entered plane is returned.
     */

    public void testBasic(){


        fq.enQueue(new PassengerPlane("plane1", small));

        assertEquals("plane1", fq.deQueue().getName());
    }


    /**
     * Tests the case where two planes are of the same type
     * and enter the queue at different times.
     *
     * The one that entered earlier should be dequeued first.
     */
    public void testDate(){


        fq.enQueue(new PassengerPlane("plane1",small));

        /*
         The time difference between two object creations above and below
         is very small and does not create any dictinction.
         Need to create an artificial time gap to test real world scenario.
         Need to see if something is more precise than what I have here.
         */
        SystemClock.sleep(200);

        fq.enQueue(new PassengerPlane("plane2",small));

        assertEquals("plane1", fq.deQueue().getName());
        assertEquals("plane2",fq.deQueue().getName());
    }

    /**
     * Two planes of the same type, but different sizes are entered
     */
    public void testlargeSmall(){

        fq.enQueue(new PassengerPlane("plane1",small));
        fq.enQueue(new PassengerPlane("plane2", large));

        assertEquals("plane2", fq.deQueue().getName());
    }

    /**
     * Two planes of the different types are entered.
     *
     */
    public void testType(){

        fq.enQueue(new CargoPlane("plane1",large));
        fq.enQueue(new PassengerPlane("plane2",small));

        assertEquals("plane2", fq.deQueue().getName());
        assertEquals("plane1", fq.deQueue().getName());

    }

    /**
     * Random planes are entered.
     *
     */
    public void testMultiplePlanes() {

        fq.enQueue(new CargoPlane("plane1", large));
        fq.enQueue(new PassengerPlane("plane2", small));
        fq.enQueue(new PassengerPlane("plane3", small));
        fq.enQueue(new PassengerPlane("plane4", small));
        fq.enQueue(new PassengerPlane("plane5", small));
        fq.enQueue(new CargoPlane("plane6", large));
        fq.enQueue(new CargoPlane("plane7", large));
        fq.enQueue(new CargoPlane("plane8", large));
        fq.enQueue(new CargoPlane("plane9", large));
        fq.enQueue(new CargoPlane("plane10", large));
        fq.enQueue(new CargoPlane("plane11", large));
        fq.enQueue(new CargoPlane("plane12", large));
        fq.enQueue(new CargoPlane("plane13", large));


        fq.enQueue(new PassengerPlane("planex", large));

        assertEquals("planex", fq.deQueue().getName());

    }

}
