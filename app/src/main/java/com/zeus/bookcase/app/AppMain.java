package com.zeus.bookcase.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.zeus.bookcase.BuildConfig;

import timber.log.Timber;

/**
 * Created by zeus_coder on 2015/9/30.
 */
public class AppMain extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
/*        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }*/

    }

    @Override
    public void onCreate() {
        super.onCreate();

        //ImageLoader 图片组件初始化
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()  // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

}
