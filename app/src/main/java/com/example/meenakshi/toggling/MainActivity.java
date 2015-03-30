package com.example.meenakshi.toggling;

import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Switch mySwitch,wifiSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch = (Switch) findViewById(R.id.mySwitch);
        wifiSwitch = (Switch) findViewById(R.id.wifiSwitch);
        final AudioManager myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //WifiManager wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
       final WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

// set the switch to ON
        mySwitch.setChecked(true);
        wifiSwitch.setChecked(true);
// attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {

                    //   Toast.makeText(getApplicationContext(),“The switch is ON”,Toast.LENGTH_SHORT).show();

                    Toast.makeText(getApplicationContext(), "Vibrate Mode", Toast.LENGTH_SHORT).show();
                    myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                } else {

                    Toast.makeText(getApplicationContext(), "Normal Mode", Toast.LENGTH_SHORT).show();
                    myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }

            }
        });


        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {

                    //   Toast.makeText(getApplicationContext(),“The switch is ON”,Toast.LENGTH_SHORT).show();
                  //  toggleWiFi(true);
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(getApplicationContext(), "Wifi ON", Toast.LENGTH_SHORT).show();

                } else {
                    //toggleWiFi(false);
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(getApplicationContext(), "Wifi OFF", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


  /*  public void toggleWiFi(boolean status) {
        WifiManager wifiManager = (WifiManager) this
                .getSystemService(Context.WIFI_SERVICE);
        if (status == true && !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        } else if (status == false && wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }*/




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
