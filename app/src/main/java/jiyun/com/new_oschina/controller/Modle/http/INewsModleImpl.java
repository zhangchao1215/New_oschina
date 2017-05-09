package jiyun.com.new_oschina.controller.Modle.http;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.new_oschina.controller.Modle.Urls.UrlUtils;
import jiyun.com.new_oschina.controller.Modle.http.callback.MyCallBack;

/**
 * Created by Administrator on 2017/5/9.
 */

public class INewsModleImpl implements NewsModle {
    @Override
    public void Post(String catalog, String pageIndex, String pageSize, MyCallBack callBask) {
        Map<String, String> params = new HashMap<>();
        params.put("catalog", catalog);
        params.put("pageIndex", pageIndex);
        params.put("pageSize", pageSize);
        OkHttpUtils.getInstance().Post(UrlUtils.News,params,callBask);
    }
}
