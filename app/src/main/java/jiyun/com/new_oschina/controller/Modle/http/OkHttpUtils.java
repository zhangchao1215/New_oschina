package jiyun.com.new_oschina.controller.Modle.http;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import jiyun.com.new_oschina.controller.App;
import jiyun.com.new_oschina.controller.Modle.http.callback.MyCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/9.
 */

public class OkHttpUtils implements IHttp {
    private OkHttpUtils() {

    }

    public static OkHttpUtils okHttpUtils = new OkHttpUtils();

    public static OkHttpUtils getInstance() {

        return okHttpUtils;
    }

    private StringBuffer sb;

    /**
     * post请求
     *
     * @param url      地址
     * @param params   拼接的参数
     * @param callBack 请求成功的回调
     */
    @Override
    public void Post(String url, Map<String, String> params, final MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                String value = params.get(key);
                builder.add(key, value);
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(builder.build())
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String string = response.body().string();
                    App.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //在这进行成功的回调，解析数据了，
                            callBack.Success(string);
                        }
                    });
                }
            });

        }
    }

    /**
     * get请求拼接参数
     *
     * @param url
     * @param params
     * @param callBack
     */
    @Override
    public void Get(String url, Map<String, String> params, final MyCallBack callBack) {
        sb = new StringBuffer();
        OkHttpClient client = new OkHttpClient();
        if (params != null) {
            Set<String> keySet = params.keySet();
            sb.append("?");
            int count = 0;
            int size = params.keySet().size();
            for (String key : keySet) {
                String value = params.get(key);
                sb.append(key);
                sb.append("=");
                sb.append(value);
                count++;
                if (count > size) {
                    sb.append("&");
                }
            }
            url = url + sb.toString();
        }
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.Success(str);
                    }
                });

            }
        });

    }
}
