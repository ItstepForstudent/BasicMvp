package com.itstep.newyorktimesnews.api;

import com.itstep.newyorktimesnews.entities.ApiResponse;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewYorkApi {
    @GET("{type}/{category}/30.json?api-key=fe637befa8b443de9de681711f77f001")
    public Observable<ApiResponse> getNews(@Path("category") String cat,@Path("type") String type);

}
