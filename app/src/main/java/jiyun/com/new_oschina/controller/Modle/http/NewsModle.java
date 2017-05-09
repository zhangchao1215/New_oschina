package jiyun.com.new_oschina.controller.Modle.http;

import jiyun.com.new_oschina.controller.Modle.http.callback.MyCallBack;

/**
 * Created by Administrator on 2017/5/9.
 */

public interface NewsModle {
    //新闻列表的调用
    void Post(String catalog, String pageIndex, String pageSize, MyCallBack callBask);

}
