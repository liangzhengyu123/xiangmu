package com.example.frame.interfaces;
//todo v 层接口
public interface ICommonView<T> {

    void showResponse(int apiconfig, T o, T... t);
    void showError(int apiconfig, Throwable throwable);
}
