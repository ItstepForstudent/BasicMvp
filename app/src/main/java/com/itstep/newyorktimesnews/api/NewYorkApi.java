package com.itstep.newyorktimesnews.api;

import com.itstep.newyorktimesnews.entities.ApiResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewYorkApi {
    @GET("mostemailed/{category}/30.json?api-key=fe637befa8b443de9de681711f77f001")
    public Observable<ApiResponse> getMostemailedNews(@Path("category") String cat);

    @GET("mostshared/{category}/30.json?api-key=fe637befa8b443de9de681711f77f001")
    public Observable<ApiResponse> getMostsharedNews(@Path("category") String cat);

    @GET("mostviewed/{category}/30.json?api-key=fe637befa8b443de9de681711f77f001")
    public Observable<ApiResponse> getMostviewedNews(@Path("category") String cat);
}
