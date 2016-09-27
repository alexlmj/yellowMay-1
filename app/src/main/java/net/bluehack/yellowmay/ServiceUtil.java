package net.bluehack.yellowmay;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Kyewon on 2016. 9. 24..
 */
public class ServiceUtil {

    public static void startLoaderService(Context context) {
        Intent i = new Intent(context, LoaderService.class);
        context.startService(i);
    }

}