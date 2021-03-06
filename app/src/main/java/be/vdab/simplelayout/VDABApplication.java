package be.vdab.simplelayout;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

import timber.log.Timber;

/**
 * Created by RWIL on 04/09/2015.
 */
public class VDABApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Initialize Timber: Only plant Tree for logging when running in testing
        //This means that in production no prints will appear in logcat
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }



        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "qZ3WSRRIOpGKHZ22vNpygvrRcqWbcHMMOq6DjmGe", "6yTCyL1St1N4pUMduMpOsAJ5wkItkVG0oFjrclFp");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }

}
