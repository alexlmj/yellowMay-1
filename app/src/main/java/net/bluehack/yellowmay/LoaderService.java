package net.bluehack.yellowmay;

import android.Manifest;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by Kyewon on 2016. 9. 24..
 */
public class LoaderService extends IntentService {

    private final String TAG = "LoaderService";
    private Context context;
    public final static String TYPE = "loader_type";

    public LoaderService() {
        super(LoaderService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //int type = intent.getIntExtra(TYPE, -1);
        context = getApplicationContext();

        indexContactData();
    }

    private void indexContactData() {
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG,"checkSelfPermission");
        }
    }

}
