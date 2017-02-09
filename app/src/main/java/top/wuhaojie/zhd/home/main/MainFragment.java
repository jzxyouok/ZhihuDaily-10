package top.wuhaojie.zhd.home.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.youth.banner.Banner;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;
import top.wuhaojie.zhd.utils.BannerImageLoader;

import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements MainFragmentView {

    MainFragmentPresenter mMainFragmentPresenter;
    @BindView(R.id.banner_hot)
    Banner mBannerHot;
    @BindView(R.id.rv_content_main)
    RecyclerView mRvContentMain;
    @BindView(R.id.srf_main)
    SwipeRefreshLayout mSrfMain;

    public MainFragment() {
        Log.d(TAG, "MainFragment: new Instance");
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainFragmentPresenter = new MainFragmentPresenter(getActivity());
        mMainFragmentPresenter.bindView(this);

        mBannerHot
                .setImageLoader(new BannerImageLoader())
                .isAutoPlay(true)
                .start();

    }

    @Override
    public void onStart() {
        super.onStart();
        mBannerHot.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBannerHot.stopAutoPlay();
    }

    @Override
    protected void loadData() {
        mMainFragmentPresenter.loadData();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }
}