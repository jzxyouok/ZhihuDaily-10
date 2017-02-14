package top.wuhaojie.zhd.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailView, DetailContentFragment.OnFragmentInteractionListener {

    DetailPresenter mDetailPresenter;
    @BindView(R.id.vp_detail_content)
    ViewPager mVpDetailContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailPresenter = new DetailPresenter(this);
        mDetailPresenter.bindView(this);

        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mVpDetailContent.setAdapter(new DetailContentAdapter(getSupportFragmentManager()));

    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDetailPresenter.onOptionsItemSelected(item);
    }

    @Override
    public void back() {
        finish();
        // TODO: 17-2-11 记录阅读进度
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}