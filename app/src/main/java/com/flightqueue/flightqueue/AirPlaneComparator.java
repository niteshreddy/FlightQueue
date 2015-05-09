package com.flightqueue.flightqueue;

import java.util.Comparator;


/**
 * Created by niteshreddy on 5/9/15.
 */
public class AirPlaneComparator implements Comparator<AirPlane> {



    @Override
    public int compare(AirPlane ap1, AirPlane ap2){

        if(ap1 instanceof PassengerPlane && ap2 instanceof CargoPlane){
            return 1;
        }
        else if (ap1 instanceof CargoPlane && ap2 instanceof PassengerPlane) {
            return -1;
        }

        if((ap1 instanceof  PassengerPlane && ap2 instanceof  PassengerPlane) ||
                (ap1 instanceof  CargoPlane && ap2 instanceof  CargoPlane) ){

            if(ap1.getSize().equals("large") && ap2.getSize().equals("small")){
                return 1;
            }
            else if(ap1.getSize().equals("small") && ap2.getSize().equals("large")){
                return -1;
            }
        }

        if(ap1 instanceof  PassengerPlane && ap2 instanceof PassengerPlane && ap1.getSize().equals(ap2.getSize())){

            if(ap1.getDate().before(ap2.getDate())){
                return 1;
            }else{
                return -1;
            }

        }

        if(ap1 instanceof  CargoPlane && ap2 instanceof CargoPlane && ap1.getSize().equals(ap2.getSize())){

            if(ap1.getDate().before(ap2.getDate())){
                return 1;
            }else{
                return -1;
            }

        }



        return 0;

    }

}
