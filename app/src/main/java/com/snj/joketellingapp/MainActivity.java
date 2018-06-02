package com.snj.joketellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.snj.jokedisplayandroidlib.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements JokeCallbackInterface {

    public static final String INTENT_JOKE = "intent_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void fetchJoke(View view) {
        new GetJokeAsyncTask(this).execute();
    }

    @Override
    public void onFinished(String joke) {
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(INTENT_JOKE, joke);
        startActivity(intent);
    }
}


