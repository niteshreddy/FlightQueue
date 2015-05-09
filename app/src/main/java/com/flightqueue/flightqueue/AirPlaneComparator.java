package com.flightqueue.flightqueue;

import java.util.Comparator;


/**
 * Custom comparator to decide which plane should be removed out
 * of the queue first.
 *
 * - Dequeue aircraft requests result in selection of one AC for removal such that:
 * - Passenger AC’s have removal precedence over Cargo AC’s
 * - Large AC’s of a given type have removal precedence over Small AC’s of the same type.
 * - Earlier enqueued AC’s of a given type and size have precedence over later enqueued AC’s of the same type and size.
 *
 *
 * Created by niteshreddy on 5/9/15.
 */
public class AirPlaneComparator implements Comparator<AirPlane> {



    @Override
    public int compare(AirPlane ap1, AirPlane ap2){

        if(ap1 instanceof PassengerPlane && ap2 instanceof CargoPlane){
            return -1;
        }
        else if (ap1 instanceof CargoPlane && ap2 instanceof PassengerPlane) {
            return 1;
        }

        if((ap1 instanceof  PassengerPlane && ap2 instanceof  PassengerPlane) ||
                (ap1 instanceof  CargoPlane && ap2 instanceof  CargoPlane) ){


            if(ap1.getSize().equals("large") && ap2.getSize().equals("small")){
                return -1;

            }
            else if(ap1.getSize().equals("small") && ap2.getSize().equals("large")){
                return 1;
            }
        }

        if(ap1 instanceof  PassengerPlane && ap2 instanceof PassengerPlane && ap1.getSize().equals(ap2.getSize())){

            if(ap1.getDate().before(ap2.getDate())){
                return -1;
            }else{
                return 1;
            }

        }

        if(ap1 instanceof  CargoPlane && ap2 instanceof CargoPlane && ap1.getSize().equals(ap2.getSize())){

            if(ap1.getDate().before(ap2.getDate())){
                return -1;
            }else{
                return 1;
            }

        }

        return 0;

    }

}
