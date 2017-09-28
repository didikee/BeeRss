package didikee.android.beenews.rss.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by didikee on 2017/9/28.
 */

public class HttpManager {
    private OkHttpClient okHttpClient;
    //    OkHttpClient client = new OkHttpClient();
//    //构造Request对象
//    //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
//    Request request = new Request.Builder().get().url("http://www.jianshu.com/u/9df45b87cfdf").build();
//    Call call = client.newCall(request);
//    //异步调用并设置回调函数
//        call.enqueue(new Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//            ToastUtil.showToast(GetActivity.this, "Get 失败");
//        }
//
//        @Override
//        public void onResponse(Call call, final Response response) throws IOException {
//            final String responseStr = response.body().string();
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    tv_result.setText(responseStr);
//                }
//            });
//        }
//    });

    private HttpManager(){}
    private static class Singleton{
       private static HttpManager INSTANCE =new HttpManager();
    }
    public static HttpManager getInstance(){
        return Singleton.INSTANCE;
    }

    public void init(){
        okHttpClient = new OkHttpClient();

    }
    public void get(String url, final BaseHttpCallback httpCallback){
        Request getRequest =new Request.Builder().get().url(url).build();
        Call getCall = okHttpClient.newCall(getRequest);
        getCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpCallback.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body!=null){
                    httpCallback.onSuccess(body.string());
                }else {
                    httpCallback.onSuccess("ResponseBody is null");
                }

            }
        });
    }
}
