package com.example.frame.configs;

public class NetConfig {
    public static int apiType = 4;
    public static String BASE_URL;
    static {
        if (apiType == 1){
            BASE_URL = "http://39.107.224.233/firstga/app/";
        } else if (apiType == 2){
            BASE_URL = "http://api.shujuzhihui.cn/api/news/";
        } else if(apiType == 3){
            BASE_URL = "https://www.firstgainfo.com/firstga/app/";
        }else if (apiType == 4){
            BASE_URL = "http://www.wanandroid.com/";
        }
    }

    //public static final String TENCENT_ID = "1804rxl";
    //public static final String TENCENT_CONSIG = "eJx1kEFPgzAUgO-8iqZXjaxQQLxtYyx1zMWM6dylaWjnmim0UBbA*N9H0EQuvuv3vXwv78sCAMA02d6xLCvq3FDTKgHBA4BB6MDbP6yU5JQZ6pZ8wAhP*kGe644s0ShZCsqORpSD5Xih02sjRXKRG3mUvwK6n*Cy*RgJFT-TofZ-ppLvA1wv3ubkOXJzTQrdyUbP7DS*2I9InoNDHAuy0nt-Hz0pf8mX81O-Rk7TTZJN-bS77ArWbkJG1gtBZp2o9c3hJYlXdlhXkdi9BqrFo6SRnz9vQR4O*oMcH0Pr27oC7vNXew__";

}
