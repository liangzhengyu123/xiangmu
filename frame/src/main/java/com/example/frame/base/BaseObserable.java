package com.example.frame.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserable implements Observer {
    Disposable d;//todo 接触订阅关系，避免内存泄漏
    @Override
    public void onSubscribe(Disposable d) {
        this.d=d;
    }

    @Override
    public void onNext(Object value) {
        onBaseNext(value);
        dispose();
    }

    @Override
    public void onError(Throwable e) {
        onBaseError(e);
        dispose();
    }

    @Override
    public void onComplete() {

    }

    //todo 子类实现的常用方法
    protected abstract void onBaseNext(Object o);
    protected abstract void onBaseError(Throwable e);

    public void dispose(){
        if(!d.isDisposed()){
           d.dispose();
        }
    }
}
