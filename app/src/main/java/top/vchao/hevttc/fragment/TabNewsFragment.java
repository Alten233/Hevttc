package top.vchao.hevttc.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;
import top.vchao.hevttc.R;
import top.vchao.hevttc.cootab.MainFragment1;
import top.vchao.hevttc.cootab.MainFragment2;
import top.vchao.hevttc.cootab.MainFragment3;
import top.vchao.hevttc.cootab.MainFragment4;
import top.vchao.hevttc.cootab.MyPagerAdapter;

/**
 * @ 创建时间: 2017/9/21 on 19:39.
 * @ 描述：新闻页面fragment
 * @ 作者: vchao
 */
public class TabNewsFragment extends BaseFragment {

    @BindView(R.id.vp_news)
    ViewPager mViewPager;
    @BindView(R.id.cootablayout_news)
    CoordinatorTabLayout mCoordinatorTabLayout;

    private int[] mImageArray, mColorArray;

    private final String[] mTitles = {"通知公告", "新闻速递", "自媒体", "校园文化"};
    private ArrayList<Fragment> mFragments;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initData() {

        initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.mipmap.img_keshi1,
                R.mipmap.img_keshi4,
                R.mipmap.img_bg_news3,
                R.mipmap.img_bg_news4};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout.setTransulcentStatusBar(mActivity)
                .setTitle("")
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mFragments, mTitles));
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(MainFragment1.getInstance(mTitles[0]));
        mFragments.add(MainFragment2.getInstance(mTitles[1]));
        mFragments.add(MainFragment3.getInstance(mTitles[2]));
        mFragments.add(MainFragment4.getInstance(mTitles[3]));
    }

}
