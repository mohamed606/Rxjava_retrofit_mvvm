package com.example.rxjavawithretro.data;

import com.example.rxjavawithretro.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<PostModel>> getPosts();
}
