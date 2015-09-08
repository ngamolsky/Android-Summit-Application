package com.example.nikitagamolsky.summitapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements gotIntoADCS.NoticeDialogListener{
    ArrayList<Results> thingsGained = new ArrayList<>(); //Empty list of things to be gained
    ResultsAdapter mAdapter; //Adapter for results

    //onCreate Method defining what happens when view is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new ResultsAdapter(this, thingsGained);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(mAdapter);


        if (savedInstanceState == null) {
            showNoticeDialog();
        }
        Switch jobswitch = (Switch) findViewById(R.id.jobswitch);

        //Legendary switch listener... if turned on, engage partyIntent
        jobswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try{
                        Intent partyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:dA6-GzDZfis"));
                        startActivity(partyIntent);
                    }catch (ActivityNotFoundException ex){
                        Intent intent=new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.youtube.com/watch?v=dA6-GzDZfis"));
                        startActivity(intent);
                    }

                }
            }
        });
    }

    //Method for showing the dialog box
    public void showNoticeDialog() {
        DialogFragment dialog = new gotIntoADCS();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }


    //Method that determines behavior on clicking "lets find out" on dialog box
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        //List of benefits from ADCS
        final Results network = new Results(getDrawable(R.mipmap.ic_network), "Nikita's Network was increased by the number of people at the event!");
        final Results confidence = new Results(getDrawable(R.mipmap.ic_confidence),"Nikita increased his confidence!");
        final Results skills= new Results(getDrawable(R.mipmap.ic_skills),"Nikita gained relevant skills!");
        final Results experience = new Results(getDrawable(R.mipmap.ic_experience),"Nikita gained some experience!");
        final Results resume = new Results(getDrawable(R.mipmap.ic_resume),"Nikita gained some help with his resume!");

        //Reference for fabled "job switch"
        final Switch jobswitch = (Switch) findViewById(R.id.jobswitch);

        //Handler for slowly adding result list items and legendary switch
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(network);
                mAdapter.notifyDataSetChanged();
            }
        }, 3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(confidence);
                mAdapter.notifyDataSetChanged();
            }
        }, 6000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(skills);
                mAdapter.notifyDataSetChanged();
            }
        }, 9000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(experience);
                mAdapter.notifyDataSetChanged();
            }
        }, 12000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(resume);
                mAdapter.notifyDataSetChanged();
            }
        }, 15000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jobswitch.setVisibility(View.VISIBLE);
            }
        }, 15000);


    }

    //Method that determines behavior on clicking "I don't care"
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast nogood = Toast.makeText(this,"Well then... this is awkward", Toast.LENGTH_LONG);
        nogood.show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNoticeDialog();
            }
        }, 3000);
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
