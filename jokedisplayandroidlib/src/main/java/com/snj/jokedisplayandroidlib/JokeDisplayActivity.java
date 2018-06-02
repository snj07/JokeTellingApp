package com.snj.jokedisplayandroidlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "intent_joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        TextView text = (TextView) findViewById(R.id.jokeTV);
        text.setText(getIntent().getStringExtra(INTENT_JOKE));
    }
}
