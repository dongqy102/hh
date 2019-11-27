package com.bawei.dongyong20191127.app;

import android.app.Application;
import android.content.Context;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 8:51
 * @Description:
 */
public class AppUrl extends Application {
    public  static Context  context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

    }
}
