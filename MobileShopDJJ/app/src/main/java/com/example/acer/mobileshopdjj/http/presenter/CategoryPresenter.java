package com.example.acer.mobileshopdjj.http.presenter;

import com.example.acer.mobileshopdjj.HttpMethods;
import com.example.acer.mobileshopdjj.http.entity.CategoryEntity;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {
    /**
     * 获取一级分类列表
     * @param subscriber
     */
    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber){
        Observable<List<CategoryEntity>> observable = categoryService.getTopList()
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 获取二级列表
     * @param parentId
     */
    public static void getSecondList(Subscriber subscriber,int parentId){
        Observable<List<CategoryEntity>> observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable,subscriber);
    }
}
