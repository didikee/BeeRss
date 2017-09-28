package didikee.android.beenews.rss;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import didikee.android.beenews.rss.network.HttpManager;

/**
 * Created by didikee on 2017/9/28.
 */

public class BRApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpManager.getInstance().init();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
