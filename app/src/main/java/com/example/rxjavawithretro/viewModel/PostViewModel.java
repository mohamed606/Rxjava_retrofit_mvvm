package com.example.rxjavawithretro.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavawithretro.models.PostModel;
import com.example.rxjavawithretro.repository.PostsRepository;

import java.util.List;

public class PostViewModel extends ViewModel {
    private PostsRepository postsRepository;

    @ViewModelInject
    public PostViewModel(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public MutableLiveData<List<PostModel>> getPosts(){
        return postsRepository.getPosts();
    }
}
