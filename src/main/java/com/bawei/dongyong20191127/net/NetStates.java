package com.bawei.dongyong20191127.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:10
 * @Description:
 */
public class NetStates {
    static  NetStates netStates=new NetStates();

    public static NetStates getInstance() {
        return netStates;
    }

    private NetStates() {
    }
    public  boolean hasNet(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return  false;
        }

    }

}
