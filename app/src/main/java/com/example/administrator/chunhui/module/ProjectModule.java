package com.example.administrator.chunhui.module;

import com.example.administrator.chunhui.bean.ProjectContent;
import com.example.administrator.chunhui.bean.ProjectTab;
import com.example.administrator.chunhui.utils.OkhttpUtils;
import com.example.frame.configs.ApiConfig;
import com.example.frame.interfaces.ICommonModule;
import com.example.frame.interfaces.ICommonView;

public class ProjectModule implements ICommonModule {
    @Override
    public void getData(int apiconfig, ICommonView mainView, Object... t) {
        switch (apiconfig) {
            case ApiConfig.GET_PROJECT_TAB:
                OkhttpUtils.getInstance().httpData(mainView, apiconfig, ProjectTab.class, null, null, "project/tree/json");
                break;
            case ApiConfig.GET_PROJECT_CONTENT:
                int tab = (int) t[0];
                int page = (int) t[1];
                OkhttpUtils.getInstance().httpData(mainView,apiconfig, ProjectContent.class,null,null,"project/list/"+page+"/json?cid="+tab);
                break;
            case ApiConfig.GET_PROJECT_LOADING:

                break;
        }
    }
}
