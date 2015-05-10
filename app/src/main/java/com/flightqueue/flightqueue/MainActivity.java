package com.flightqueue.flightqueue;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    //The queue that holds all the flights.
    private FlightQueue fq;

    private Button enqueue;
    private Button dequeue;
    private Button reinitialize;

    private RadioButton passenger_radio;
    private RadioButton cargo_radio;

    private RadioButton large_plane_radio;
    private RadioButton small_plane_radio;

    private EditText plane_name;

    private String LOG_TAG = "MainActivityNitesh";

    private final String large = "large";
    private final String small = "small";


    public void setUpOnClickListeners() {
        //setup Listener for Enqueue button.
        enqueue = (Button) findViewById(R.id.enqueue);
        enqueue.setOnClickListener(new EnQueuePlane());

        //Setup listener for dequeue button.
        dequeue = (Button) findViewById(R.id.dequeue);
        dequeue.setOnClickListener(new DeQueuePlane());

        //Setup listener for re-initializing the plane
        reinitialize = (Button) findViewById(R.id.re_initialize_queue);
        reinitialize.setOnClickListener(new ClearQueue());


    }
    /*
     This class lisentes to the "Enqueue Plane" button
     and processes the form and enteres the plane into the queue.
     */
    private class EnQueuePlane implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            //Plane name edit text.
            plane_name = (EditText) findViewById(R.id.plannenameedittext);

            //Passenger or cargo radio buttons.
            passenger_radio = (RadioButton) findViewById(R.id.passengerplaneradio);
            cargo_radio = (RadioButton) findViewById(R.id.cargoplaneradio);

            //large or small radio buttons
            large_plane_radio = (RadioButton) findViewById(R.id.planelargeradio);
            small_plane_radio = (RadioButton) findViewById(R.id.planesmallradio);

            //The name field cannot be empty.
            if(plane_name.getText().toString().trim().equals("")){

                Toast.makeText(MainActivity.this,"A plane needs a Name!", Toast.LENGTH_LONG).show();

                return;

            }

            //Decide which plane the user is choosing.
            if(passenger_radio.isChecked() && large_plane_radio.isChecked()){

                fq.enQueue(new PassengerPlane(plane_name.getText().toString(),large));

            }else if(passenger_radio.isChecked() && small_plane_radio.isChecked()){

                fq.enQueue(new PassengerPlane(plane_name.getText().toString(),small));

            }else if(cargo_radio.isChecked() && large_plane_radio.isChecked()){

                fq.enQueue(new CargoPlane(plane_name.getText().toString(),large));

            }else if(cargo_radio.isChecked() && small_plane_radio.isChecked()){

                fq.enQueue(new CargoPlane(plane_name.getText().toString(),small));
            }

            //Notify that the plane is in Queue.
            Toast.makeText(MainActivity.this,plane_name.getText().toString() + " in Queue!",
                    Toast.LENGTH_LONG).show();

            //Reset the form
            plane_name.setText("");
            passenger_radio.setChecked(true);
            large_plane_radio.setChecked(true);


        }
    }

    /*
     *This class listenes to the "DeQueue" button and Dequeues an AirPlane.
     *
     */
    private class DeQueuePlane implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            //Dequeue the head.
            AirPlane ap = fq.deQueue();
            String message;

            if(ap != null){
                //Notify that the plane has been dequeued.


                message = ap.getName();

                if(ap instanceof PassengerPlane){
                    message = message + " Passenger Plane";
                }else{
                    message = message + " Cargo Plane";
                }

                message = message + " " +ap.getSize() + " is Dequeued!" ;

                Toast.makeText(MainActivity.this,message,
                        Toast.LENGTH_LONG).show();
            }else{
                //if no plane in queue.
                Toast.makeText(MainActivity.this,"No plane in Queue!",
                        Toast.LENGTH_LONG).show();
            }

        }
    }

    /*
      This class listens to the "re-initialize" button and
      clears the queue.
     */
    private class ClearQueue implements  View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Clear the queu and send a notification.
            fq.clearQueue();

            Toast.makeText(MainActivity.this,"Queue Re-initialized!",
                    Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize our flight quque.
        fq = FlightQueue.getInstance();
        Toast.makeText(MainActivity.this,"Queue Initialized", Toast.LENGTH_LONG).show();

        //Setup Listeners for buttons.
        setUpOnClickListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}