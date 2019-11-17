package com.example.acer.mobileshopdjj.common;


import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

import com.example.acer.mobileshopdjj.HttpMethods;
import com.example.acer.mobileshopdjj.R;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;


public class MobileShopApp extends Application {

    public static Handler handler = new Handler();
    private static Context sContext;

    @Override
    public void onCreate(){
        super.onCreate();

        sContext=getApplicationContext();

        //初始化ImageLoader
        initImageLoader();

        //初始化网络框架
        HttpMethods.getsInstance();
    }

    private void initImageLoader(){

        //创建默认的DisplayImageOptions
        DisplayImageOptions default_options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.image_loading)//设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.image_empty)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.image_error)//设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(false)//default设置图片在加载前是否重置、复位
                .delayBeforeLoading(1000)//下载前的延迟时间
                .cacheInMemory(true)//default设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)//default设置下载的图片是否缓存在SD卡中
                .considerExifParams(false)//default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//default设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.ARGB_8888)//default设置图片的解码类型
                .displayer(new SimpleBitmapDisplayer())//default还可以设置圆角图片new RoundedBitmapDisplayer(20)
                .handler(new android.os.Handler())//default
                .build();

        //构建Imageonfiguration
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480,800)//default = device screen dimensious 内存缓存文件的最大长宽
                //.memoryCache(new LruMemoryCache(2 * 1024 * 1024))//可以通过自己的内存缓存实现
                //.memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2 * 1024 * 1024)//内存缓存的最大值
                .memoryCacheSizePercentage(13)//default

                .diskCacheSize(50 * 1024 * 1024)//50 Mb SD卡(本地)缓存的最大值
                .diskCacheFileCount(100)//可以缓存的文件数量
                //default为使用HASHCODE对UIL进行加密命名，还可以用MD5(new Md5FileNameGenerator())加密
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                //.diskCacheExtraOptions(480,800,null)  //本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个

                .threadPoolSize(3)  //default 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY-2) //default设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(getApplicationContext()))  //default
                .defaultDisplayImageOptions(default_options)//default
                .writeDebugLogs()   //打印debug log
                .build();   //开始构建

        //初始化ImageLoader
        ImageLoader.getInstance().init(config);
    }

    public static Context getContext(){return sContext;}
}
