package com.example.rxjavawithretro.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rxjavawithretro.data.PostApi;
import com.example.rxjavawithretro.models.PostModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {
    private static final String TAG = "PostsRepository";
    private PostApi postApi;
    private static MutableLiveData<List<PostModel>> posts = new MutableLiveData<>();
    private static Callback<List<PostModel>> callback = new Callback<List<PostModel>>() {
        @Override
        public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
            if (response.isSuccessful()) {
                Log.d(TAG, "onResponse: ");
                posts.setValue(response.body());
            }
        }

        @Override
        public void onFailure(Call<List<PostModel>> call, Throwable t) {
            Log.d(TAG, t.getMessage());
        }
    };

    @Inject
    public PostsRepository(PostApi postApi) {
        this.postApi = postApi;
    }

    private void getPostsFromApi() {
        Call<List<PostModel>> call = postApi.getPosts();
        call.enqueue(callback);
    }

    public MutableLiveData<List<PostModel>> getPosts() {
        getPostsFromApi();
        return posts;
    }
}
