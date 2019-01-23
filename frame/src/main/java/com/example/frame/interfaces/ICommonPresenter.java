package com.example.frame.interfaces;
//todo p 层接口
public interface ICommonPresenter<T> {

    void getData(int apiconfig,T... t);
}
