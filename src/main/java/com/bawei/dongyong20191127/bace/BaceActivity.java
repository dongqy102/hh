package com.bawei.dongyong20191127.bace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.dongyong20191127.contates.ICtontes;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:30
 * @Description:
 */
public  abstract class BaceActivity <P extends BacePresenter> extends AppCompatActivity implements ICtontes.Iview {
      public  P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(provideLayoutId()!=0){
            setContentView(provideLayoutId());
            mPresenter=initPresent();
            if (mPresenter != null) {
                mPresenter.attch(this);
            }
            initView();
            initData();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.deAttch();
            mPresenter=null;
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresent();


    protected abstract int provideLayoutId();
}
