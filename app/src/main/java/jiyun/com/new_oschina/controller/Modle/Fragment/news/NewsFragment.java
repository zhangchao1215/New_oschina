package jiyun.com.new_oschina.controller.Modle.Fragment.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.new_oschina.R;
import jiyun.com.new_oschina.controller.Modle.Bean.NewsListBean;
import jiyun.com.new_oschina.controller.Modle.adapter.LunBoTuAdapter;
import jiyun.com.new_oschina.controller.Modle.adapter.NewsListAdapter;
import jiyun.com.new_oschina.controller.Modle.base.BaseFragment;
import jiyun.com.new_oschina.controller.Modle.http.INewsModleImpl;
import jiyun.com.new_oschina.controller.Modle.http.NewsModle;
import jiyun.com.new_oschina.controller.Modle.http.callback.MyCallBack;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.N;

/**
 * Created by Administrator on 2017/5/9.
 */

public class NewsFragment extends BaseFragment {
    @BindView(R.id.NewsRecycler)
    PullToRefreshRecyclerView NewsRecycler;
    Unbinder unbinder;
    private List<View> viewList;
    private List<NewsListBean.NewsBean> mList;
    private ViewPager mviewPager;
    private LunBoTuAdapter adapter;
    private NewsListAdapter listAdapter;
    private NewsModle modle;
    private int Index = 100000;
    private final int START = 0;
    private final int END = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case START:
                    mviewPager.setCurrentItem(Index++);
                    handler.sendEmptyMessageDelayed(START, 2000);
                    break;
                case END:
                    handler.removeMessages(START);
                    break;
            }
        }
    };

    @Override
    protected int layoutId() {
        return R.layout.activity_newsfragment;
    }

    @Override
    protected void initView(View view) {
        modle = new INewsModleImpl();
        viewList = new ArrayList<>();
        mList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        NewsRecycler.setLayoutManager(manager);

        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.activity_luobo_viewpager, null);
        mviewPager = (ViewPager) view1.findViewById(R.id.LunBoTuPager);
        NewsRecycler.addHeaderView(view1);
        listAdapter = new NewsListAdapter(getActivity(), mList);
        NewsRecycler.setAdapter(listAdapter);


    }

    @Override
    protected void initData() {
        lunbo();

    }

    /**
     * 加载轮播图
     */
    private void lunbo() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.image_item1, null);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.image_item2,null);
        View view2= LayoutInflater.from(getActivity()).inflate(R.layout.image_item3,null);
        viewList.add(view);
        viewList.add(view1);
        viewList.add(view2);

        adapter = new LunBoTuAdapter(viewList);
        mviewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mviewPager.setCurrentItem(Index++);
        handler.sendEmptyMessageDelayed(START,2000);
    }

    @Override
    protected void loadData() {
        getLodaData();

        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getLodaData() {
        modle.Post("1", "0", "10", new MyCallBack() {
            @Override
            public void Success(String Response) {
                XStream stream = new XStream();
                stream.alias("oschina", NewsListBean.class);
                stream.alias("news", NewsListBean.NewsBean.class);
                NewsListBean bean = (NewsListBean) stream.fromXML(Response);
                mList.addAll(bean.getNewslist());
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void Error(String error) {

            }
        });
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
