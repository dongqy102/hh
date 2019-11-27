package com.bawei.dongyong20191127.HuCun;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:17
 * @Description:
 */
public class MyHuCun implements GlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
         builder.setMemoryCache(new LruResourceCache(10*1024*1024));
         builder.setBitmapPool(new LruBitmapPool(20*1024*1024));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }
}
