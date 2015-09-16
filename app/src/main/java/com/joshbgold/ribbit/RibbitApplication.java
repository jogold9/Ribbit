package com.joshbgold.ribbit;

import android.app.Application;

import com.joshbgold.ribbit.utils.ParseConstants;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class RibbitApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "W2tNAzL0KmSX6D2KzPrgXj6xVWmDHhyU0oeCuqAd", "31zsSt6SutjBLLnJVgrPith4XyGwHbPSsQTjF4wZ");
        ParseInstallation.getCurrentInstallation().saveInBackground();  //saves device OS information to background on Parse.com

     /* //For testing
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
    }

    public static void updateParseInstallation(ParseUser user){
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();
    }
}
