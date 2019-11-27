package com.bawei.dongyong20191127.presenter;

import com.bawei.dongyong20191127.bace.BacePresenter;
import com.bawei.dongyong20191127.contates.ICtontes;
import com.bawei.dongyong20191127.model.ModelMvp;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:37
 * @Description:
 */
public class PresenterMvp extends BacePresenter {
    public ModelMvp modelMvp;

    @Override
    protected void initModel() {
        modelMvp = new ModelMvp();
    }

    @Override
    public void start(String url) {
        modelMvp.getInfo(url, new ICtontes.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onErrorSuccess(String error) {
                getView().onErrorSuccess(error);
            }
        });


    }
}
