package com.joshbgold.ribbit;

import android.app.Application;

import com.parse.Parse;

public class RibbitApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "W2tNAzL0KmSX6D2KzPrgXj6xVWmDHhyU0oeCuqAd", "31zsSt6SutjBLLnJVgrPith4XyGwHbPSsQTjF4wZ");

     /* //For testing
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
    }
}