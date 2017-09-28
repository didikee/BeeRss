package didikee.android.beenews.rss.network;

/**
 * Created by didikee on 2017/9/28.
 */

public interface BaseHttpCallback {
    void onFailed();
    void onSuccess(String response);
}
