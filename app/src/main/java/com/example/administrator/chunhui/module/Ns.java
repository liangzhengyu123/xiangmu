package com.example.administrator.chunhui.module;

import com.example.administrator.chunhui.bean.News;
import com.example.administrator.chunhui.entity.System_entity;
import com.example.administrator.chunhui.utils.OkhttpUtils;
import com.example.frame.interfaces.ICommonModule;
import com.example.frame.interfaces.ICommonView;

import okhttp3.RequestBody;

import static com.example.frame.configs.ApiConfig.GET_ERYE_DATA;
import static com.example.frame.configs.ApiConfig.GET_NEWS_DATA;
import static com.example.frame.configs.ApiConfig.GET_SYSTEM_DATA;

/**
 * Song Shuyu
 * Created by Administrator on 2019/1/20 0020 17:26
 * Created Sheepss
 * package is com.example.administrator.chunhui.module
 * TODO
 */
public class Ns implements ICommonModule {

    @Override
    public void getData(int apiconfig, ICommonView view, Object... t) {
        switch (apiconfig) {
            case GET_NEWS_DATA:
                OkhttpUtils.getInstance().httpData(view, apiconfig, News.class, null, null, "list?appKey=f589e269863044b09f78ad235fa1d2e1&category=娱乐&page=1");
                break;

            //体系首页
            case GET_SYSTEM_DATA:
                OkhttpUtils.getInstance().httpData(view, apiconfig, System_entity.class, null, null, "tree/json");
                break;

            //体系第二页
            case GET_ERYE_DATA:

                break;
        }
    }
}
