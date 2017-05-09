package jiyun.com.new_oschina.controller.Modle.http;

import java.util.Map;

import jiyun.com.new_oschina.controller.Modle.http.callback.MyCallBack;

/**
 * Created by Administrator on 2017/5/9.
 */

public interface IHttp {
  void Post(String url, Map<String,String> params, MyCallBack callBack);
  void Get(String url, Map<String,String> params, MyCallBack callBack);

}
