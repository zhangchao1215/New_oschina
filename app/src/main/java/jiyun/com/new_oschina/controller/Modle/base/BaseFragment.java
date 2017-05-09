package jiyun.com.new_oschina.controller.Modle.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/5/9.
 */

public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId(),container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this,view);
        initView(view);
        initData();
        loadData();
        initListener();
        unTitleBar();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            onHiddn();
        }else{
            show();
        }
    }

    /**
     * 找布局文件
     * @return
     */
    protected abstract int layoutId();

    /**
     * 初始化组件
     */

    protected  abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /*

    点击事件
     */
    protected abstract void initListener();


    /**
     * 隐藏
     */
    protected abstract void onHiddn();
    /*
    显示
     */
    protected abstract void show();

    /**
     * 显示标题
     */
    protected abstract void unTitleBar();

    /***
     * 页面间传递数据
     */
    public abstract void setParams(Bundle bundle);



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }






}
