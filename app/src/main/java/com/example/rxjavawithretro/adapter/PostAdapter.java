package com.example.rxjavawithretro.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavawithretro.databinding.PostItemBinding;
import com.example.rxjavawithretro.models.PostModel;
import com.example.rxjavawithretro.viewHolder.PostViewHolder;

public class PostAdapter extends ListAdapter<PostModel, PostViewHolder> {
    private static final DiffUtil.ItemCallback<PostModel> diffCallback = new DiffUtil.ItemCallback<PostModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull PostModel oldItem, @NonNull PostModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull PostModel oldItem, @NonNull PostModel newItem) {
            return oldItem.equals(newItem);
        }
    };

    public PostAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding postItemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(postItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel post = getItem(position);
        if (post != null) {
            holder.bindData(post);
        }
    }
}
