package com.example.frame.tools.utils;

import com.example.frame.base.BaseObserable;
import com.example.frame.interfaces.ICommonView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Song Shuyu
 * Created by Administrator on 2019/1/20 0020 20:38
 * Created Sheepss
 * package is com.example.frame.tools.utils
 * TODO
 */
public class ObservableUtils {
    public static <T> void getServer(Observable observable, final ICommonView view, final int apiConfig, final T...t){
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserable() {
            @Override
            protected void onBaseNext(Object o) {
                view.showResponse(apiConfig,o,t);
            }

            @Override
            protected void onBaseError(Throwable e) {
                view.showError(apiConfig,e);
            }
        });
    }
}
