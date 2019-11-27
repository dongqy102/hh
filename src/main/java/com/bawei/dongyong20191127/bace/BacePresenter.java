package com.bawei.dongyong20191127.bace;

import com.bawei.dongyong20191127.contates.ICtontes;

import java.lang.ref.WeakReference;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:24
 * @Description:
 */
public abstract class BacePresenter <V extends ICtontes.Iview> implements  ICtontes.Ipresenter{
    public BacePresenter() {
        initModel();
    }

    protected abstract void initModel();
    public WeakReference <V> weakReference;
    //绑定
    protected  void attch(V v){
        weakReference=new WeakReference<>(v);
    }
    //解绑
    protected  void deAttch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    protected  V getView(){
        return  weakReference.get();
    }

}
