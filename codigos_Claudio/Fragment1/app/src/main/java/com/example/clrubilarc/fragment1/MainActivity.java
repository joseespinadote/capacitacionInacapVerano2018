package com.example.clrubilarc.fragment1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//public class MainActivity extends AppCompatActivity {

public class MainActivity extends AppCompatActivity implements frag1.OnFragmentInteractionListener,frag2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
