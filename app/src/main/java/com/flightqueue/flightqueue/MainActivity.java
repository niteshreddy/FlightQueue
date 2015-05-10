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

    private FlightQueue fq;

    private Button enqueue;
    private Button dequeue;

    private RadioButton passenger_radio;
    private RadioButton cargo_radio;

    private RadioButton large_plane_radio;
    private RadioButton small_plane_radio;

    private EditText plane_name;

    private String LOG_TAG = "MainActivityNitesh";

    private final String large = "large";
    private final String small = "small";


    public void setUpOnClickListeners() {
        enqueue = (Button) findViewById(R.id.enqueue);
        enqueue.setOnClickListener(new EnQueuePlane());

    }

    private class EnQueuePlane implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            //Is it a passenger plane?
            boolean passenger_plane;
            //Large or small?
            boolean large_plane;

            plane_name = (EditText) findViewById(R.id.plannenameedittext);

            passenger_radio = (RadioButton) findViewById(R.id.passengerplaneradio);
            cargo_radio = (RadioButton) findViewById(R.id.cargoplaneradio);

            large_plane_radio = (RadioButton) findViewById(R.id.planelargeradio);
            small_plane_radio = (RadioButton) findViewById(R.id.planesmallradio);

            if(plane_name.getText().toString().trim().equals("")){

                Toast.makeText(MainActivity.this,"A plane needs a Name!", Toast.LENGTH_LONG).show();

                return;

            }

            if(passenger_radio.isChecked()){
                passenger_plane = true;
            }else{
                passenger_plane = false;
            }

            if(large_plane_radio.isChecked()){
                large_plane =  true;
            }else{
                large_plane = false;
            }

            if(passenger_plane == true && large_plane == true){
                fq.enQueue(new PassengerPlane(plane_name.getText().toString(),large));
            }else if(passenger_plane = true && large_plane == false){
                fq.enQueue(new PassengerPlane(plane_name.getText().toString(),small));
            }else if(passenger_plane = false && large_plane == true){
                fq.enQueue(new CargoPlane(plane_name.getText().toString(),large));
            }else if(passenger_plane == false && large_plane == false){
                fq.enQueue(new CargoPlane(plane_name.getText().toString(),small));
            }

            Toast.makeText(MainActivity.this,plane_name.getText().toString() + " in Queue!",
                    Toast.LENGTH_LONG).show();

            //Reset the form
            plane_name.setText("");
            passenger_radio.setChecked(true);
            large_plane_radio.setChecked(true);


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fq = new FlightQueue();
        Toast.makeText(MainActivity.this,"Queue Initialized", Toast.LENGTH_LONG).show();
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


    public int returnTwo(){
        return 2;
    }
}
