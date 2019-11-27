package com.bawei.dongyong20191127.model;

import com.bawei.dongyong20191127.contates.ICtontes;
import com.bawei.dongyong20191127.net.NetVolley;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:33
 * @Description:
 */
public class ModelMvp implements ICtontes.Imodel {
    @Override
    public void getInfo(String url, final ICtontes.MyCallBack myCallBack) {
        NetVolley.getInstance().doGet(url, new NetVolley.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                 myCallBack.onSuccess(json);
            }

            @Override
            public void onErrorSuccess(String error) {
               myCallBack.onErrorSuccess(error);
            }
        });
    }

    @Override
    public void postInfo(String url, ICtontes.MyCallBack myCallBack) {

    }
}
