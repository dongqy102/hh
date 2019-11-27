package com.bawei.dongyong20191127.net;

import android.app.DownloadManager;
import android.content.Context;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.bawei.dongyong20191127.R;
import com.bawei.dongyong20191127.app.AppUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:13
 * @Description:
 */
public class NetGlide {

    public  static void logUrl(String url, ImageView imageView){
        Glide.with(AppUrl.context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                 .skipMemoryCache(true)
                .into(imageView);
    }

}
