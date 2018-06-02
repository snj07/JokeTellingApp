package com.snj.joketellingapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.snj.backend.libjoke.Libjoke;

import java.io.IOException;

class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static Libjoke myApiService = null;

    private JokeCallbackInterface callback;


    public GetJokeAsyncTask(JokeCallbackInterface callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            Libjoke.Builder builder = new Libjoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        String jokeData = null;
        try {
            jokeData = myApiService.getJoke().execute().getJoke();

            Log.d("async--", jokeData);
        } catch (IOException e) {
            Log.d("async--", e.getMessage());
        }
        return jokeData;
    }

    @Override
    protected void onPostExecute(String jokeData) {
        callback.onFinished(jokeData);
    }
}