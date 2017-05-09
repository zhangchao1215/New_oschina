package jiyun.com.new_oschina.controller.Modle.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import jiyun.com.new_oschina.R;
import jiyun.com.new_oschina.controller.Modle.Fragment.news.BoKeFragment;
import jiyun.com.new_oschina.controller.Modle.Fragment.news.NewsFragment;
import jiyun.com.new_oschina.controller.Modle.Fragment.news.WenDaFragment;
import jiyun.com.new_oschina.controller.Modle.Fragment.news.YiBoFragment;
import jiyun.com.new_oschina.controller.Modle.adapter.NewsPagerAdapter;
import jiyun.com.new_oschina.controller.Modle.base.BaseFragment;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.MainFragment_Tab)
    TabLayout MainFragmentTab;
    @BindView(R.id.MainFragment_Pager)
    ViewPager MainFragmentPager;
    Unbinder unbinder;
    private List<String> mListName;
    private List<Fragment> mList;
    private NewsPagerAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.activity_mainfragment;
    }

    @Override
    protected void initView(View view) {
        mListName = new ArrayList<>();
        mList = new ArrayList<>();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {
        mList.add(new NewsFragment());
        mList.add(new BoKeFragment());
        mList.add(new WenDaFragment());
        mList.add(new YiBoFragment());
        mListName.add("开源资讯");
        mListName.add("推荐博客");
        mListName.add("技术问答");
        mListName.add("每日一搏");
        adapter = new NewsPagerAdapter(getFragmentManager(), mList, mListName);
        MainFragmentPager.setAdapter(adapter);
        MainFragmentTab.setupWithViewPager(MainFragmentPager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onHiddn() {

    }

    @Override
    protected void show() {

    }

    @Override
    protected void unTitleBar() {

    }

    @Override
    public void setParams(Bundle bundle) {

    }


}
