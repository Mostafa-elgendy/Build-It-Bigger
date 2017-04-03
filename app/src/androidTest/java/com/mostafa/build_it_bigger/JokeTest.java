package com.mostafa.build_it_bigger;

import android.util.Log;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by mostafa on 30/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeTest implements AsyncResponse {



    @Override
    public void processFinish(String output) {
        Assert.assertNotNull(output);
        Log.d("Feteched Data", "Data : " + output);

    }
    @Test
    public void testJoke() {

            EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
            asyncTask.delegate = this;
            asyncTask.execute();
    }



}