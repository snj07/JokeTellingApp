package com.snj.joketellingapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class FetchJokeTaskTest {

    @Test
    // Test joke fetched from backend
    public void jokeFetchTest() throws InterruptedException {

        final CountDownLatch startSignal = new CountDownLatch(1);
        GetJokeAsyncTask asyncTaskTest = new GetJokeAsyncTask(joke -> startSignal.countDown());
        asyncTaskTest.execute();
        startSignal.await();
        String joke = null;
        try {
            joke = asyncTaskTest.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
        assertTrue(joke.length() > 0);
    }

}