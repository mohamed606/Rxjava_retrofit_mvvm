package com.example.rxjavawithretro.data;

import com.example.rxjavawithretro.models.PostModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PostApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Single<List<PostModel>> getPosts();
}
