package com.snj.joketellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.snj.jokedisplayandroidlib.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements JokeCallbackInterface {

    public static final String INTENT_JOKE = "intent_joke";
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void fetchJoke(View view) {
        //make progress bar visible
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        new GetJokeAsyncTask(this).execute();
    }

    @Override
    public void onFinished(String joke) {
        //make progress bar invisible
        progressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if (joke == null || joke.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Error in fetching Joke", Toast.LENGTH_SHORT).show();
            return;
        }
        //open JokeDisplay Activity
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(INTENT_JOKE, joke);
        startActivity(intent);
    }
}


