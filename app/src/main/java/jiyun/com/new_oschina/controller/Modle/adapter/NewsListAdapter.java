package jiyun.com.new_oschina.controller.Modle.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import jiyun.com.new_oschina.R;
import jiyun.com.new_oschina.controller.Modle.Bean.NewsListBean;

/**
 * Created by Administrator on 2017/5/9.
 */

public class NewsListAdapter extends BaseAdapter<NewsListBean.NewsBean> {
    public NewsListAdapter(Context context,  List<NewsListBean.NewsBean> datas) {
        super(context, R.layout.activity_item_news, datas);
    }

    @Override
    public void convert(ViewHolder holder, NewsListBean.NewsBean newsBean) {
        holder.setText(R.id.News_Text1,newsBean.getAuthor());
        holder.setText(R.id.News_Text2,newsBean.getBody());
    }
}
