package jiyun.com.new_oschina.controller.Modle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Administrator on 2017/5/9.
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mListName;
    private List<Fragment> mList;

    public NewsPagerAdapter(FragmentManager fm, List<Fragment> mList, List<String> mListName) {
        super(fm);
        this.mList = mList;
        this.mListName = mListName;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListName.get(position);
    }
}
