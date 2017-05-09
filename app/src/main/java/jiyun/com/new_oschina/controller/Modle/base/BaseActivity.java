package jiyun.com.new_oschina.controller.Modle.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import jiyun.com.new_oschina.controller.App;

/**
 * Created by Administrator on 2017/5/9.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( getLauoutId());
        App.activity= this;
        ButterKnife.bind(this);
        init();
        loadData();
        Listener();
    }

    /**
     * 加载布局文件
     * @return
     */
    protected abstract int getLauoutId();

    /**
     * 初始化数据
     */
    protected abstract void init();

    /**
     * 加载数据
     */

    protected abstract void loadData();

    /**
     * 监听点击事件
     */

    protected abstract void Listener();
}

