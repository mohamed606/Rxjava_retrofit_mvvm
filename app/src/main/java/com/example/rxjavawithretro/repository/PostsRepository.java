package com.example.rxjavawithretro.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.rxjavawithretro.data.PostApi;
import com.example.rxjavawithretro.models.PostModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostsRepository {
    private static final String TAG = "PostsRepository";
    private PostApi postApi;
    private static MutableLiveData<List<PostModel>> posts = new MutableLiveData<>();
    private static SingleObserver<List<PostModel>> observer = new SingleObserver<List<PostModel>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(List<PostModel> value) {
            posts.postValue(value);
        }

        @Override
        public void onError(Throwable e) {

        }
    };

    @Inject
    public PostsRepository(PostApi postApi) {
        this.postApi = postApi;
    }

    private void getPostsFromApi() {
        Single<List<PostModel>> observable = postApi.getPosts()
                .subscribeOn(Schedulers.io());
        observable.subscribe(observer);
    }

    public MutableLiveData<List<PostModel>> getPosts() {
        getPostsFromApi();
        return posts;
    }
}
