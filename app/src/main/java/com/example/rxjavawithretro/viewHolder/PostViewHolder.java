package com.example.rxjavawithretro.viewHolder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavawithretro.databinding.PostItemBinding;
import com.example.rxjavawithretro.models.PostModel;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private PostItemBinding binding;

    public PostViewHolder(@NonNull PostItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindData(PostModel post) {
        binding.userIDTV.setText(String.valueOf(post.getUserId()));
        binding.bodyTV.setText(post.getBody());
        binding.titleTV.setText(post.getTitle());
    }
}
