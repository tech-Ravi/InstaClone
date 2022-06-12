package com.live.myinstaclone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.live.myinstaclone.Model.Post;
import com.live.myinstaclone.R;

import java.util.ArrayList;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
	private Context context;
	private ArrayList<Post> posts;
	
	public PostAdapter(Context context, ArrayList<Post> posts) {
		this.context = context;
		this.posts = posts;
	}
	
	@NonNull
	@Override
	public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new PostViewHolder(LayoutInflater.from(context)
		.inflate(R.layout.post_layout, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
		Post post = posts.get(i);
		
		Glide.with(context)
			.load(post.getImageUrl())
			.into(postViewHolder.post);
		
	}
	
	@Override
	public int getItemCount() {
		if (posts != null) {
			return posts.size();
		}
		return 0;
	}
	
	class PostViewHolder extends RecyclerView.ViewHolder {
		
		ImageView post;
		
		PostViewHolder(@NonNull View itemView) {
			super(itemView);
			post = itemView.findViewById(R.id.imgPost);
		}
	}
}
