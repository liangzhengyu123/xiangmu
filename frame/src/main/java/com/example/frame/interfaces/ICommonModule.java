package com.example.frame.interfaces;

//todo m 层接口
public interface ICommonModule<T> {
    void getData(int apiconfig, ICommonView mainView, T... t);
}
