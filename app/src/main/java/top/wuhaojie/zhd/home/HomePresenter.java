package top.wuhaojie.zhd.home;

import android.content.Context;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HomePresenter implements BasePresenter {

    private Context mContext;

    public HomePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {

    }
}