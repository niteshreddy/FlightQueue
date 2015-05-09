package com.flightqueue.flightqueue;

import junit.framework.TestCase;
import com.flightqueue.flightqueue.FlightQueue;
/**
 * Created by niteshreddy on 5/9/15.
 */
public class FlightQueueTest extends TestCase {

    private FlightQueue fq;

    protected void setUp() throws Exception {
        super.setUp();
        // do initialization here, run on every test method
        fq = new FlightQueue();
    }
    protected void tearDown() throws Exception {
    // do termination here, run on every test method
        super.tearDown();
    }


    public void testSomething(){
        assertEquals(2,fq.returnTwo());
    }
}
