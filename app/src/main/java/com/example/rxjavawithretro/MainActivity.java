package com.example.rxjavawithretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.rxjavawithretro.adapter.PostAdapter;
import com.example.rxjavawithretro.databinding.ActivityMainBinding;
import com.example.rxjavawithretro.models.PostModel;
import com.example.rxjavawithretro.viewModel.PostViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private PostViewModel postViewModel;
    private ActivityMainBinding mainBinding;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        adapter = new PostAdapter();
        postViewModel.getPosts().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.submitList(postModels);
            }
        });
        setRecycler();
    }

    private void setRecycler() {
        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recycler.setHasFixedSize(true);
        mainBinding.recycler.setAdapter(adapter);
    }
}