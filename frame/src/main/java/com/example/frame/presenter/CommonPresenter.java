package com.example.frame.presenter;

import com.example.frame.base.BasePresenter;
import com.example.frame.interfaces.ICommonPresenter;
import com.example.frame.interfaces.ICommonView;

//todo p 层实体类
public class CommonPresenter<T> extends BasePresenter implements ICommonPresenter<T>, ICommonView {

    @Override
    public void getData(int apiconfig, T... t) {
      if(getModel()!=null) getModel().getData(apiconfig,this,t);
    }

    @Override
    public void showResponse(int apiconfig, Object o, Object... t) {
       if(getView()!=null) getView().showResponse(apiconfig,o,t);
    }

    @Override
    public void showError(int apiconfig,Throwable e) {
       if(getView()!=null) getView().showError(apiconfig,e);
    }
}
