package jiyun.com.new_oschina.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.new_oschina.R;
import jiyun.com.new_oschina.controller.Modle.Fragment.MainFragment;
import jiyun.com.new_oschina.controller.Modle.Fragment.news.NewsFragment;
import jiyun.com.new_oschina.controller.Modle.base.BaseActivity;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.Main_Search)
    ImageView MainSearch;
    @BindView(R.id.Main_FrameLayout)
    FrameLayout MainFrameLayout;
    @BindView(R.id.But_Zhonghe)
    RadioButton ButZhonghe;
    @BindView(R.id.But_DongTan)
    RadioButton ButDongTan;
    @BindView(R.id.But_Add)
    ImageView ButAdd;
    @BindView(R.id.But_FaXian)
    RadioButton ButFaXian;
    @BindView(R.id.But_Mine)
    RadioButton ButMine;
    @BindView(R.id.Main_RadioGroup)
    RadioGroup MainRadioGroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private FragmentManager fragmentManager;

    @Override
    protected int getLauoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.Main_FrameLayout, new MainFragment());
        transaction.commit();
    }

    @Override
    protected void loadData() {
        new MainFragment();
    }

    @Override
    protected void Listener() {

    }

}
