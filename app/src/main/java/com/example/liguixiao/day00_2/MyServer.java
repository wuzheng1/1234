package com.example.liguixiao.day00_2;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by liguixiao on 2019/9/18.
 */

public interface MyServer {
    @GET("api/data/福利/10/1")
    Observable<RootBeans> getData();
}
