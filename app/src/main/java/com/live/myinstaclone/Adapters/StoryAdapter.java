package com.live.myinstaclone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.live.myinstaclone.Model.Story;
import com.live.myinstaclone.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder>{
	private Context context;
	private ArrayList<Story> stories;
	
	public StoryAdapter(Context context, ArrayList<Story> stories) {
		this.context = context;
		this.stories = stories;
	}
	
	@NonNull
	@Override
	public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new StoryViewHolder(LayoutInflater.from(context)
		.inflate(R.layout.story_layout, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull StoryViewHolder storyViewHolder, int i) {
		Story story = stories.get(i);
		
		Glide.with(context)
			.load(story.getImageUrl())
			.into(storyViewHolder.storyImage);
		storyViewHolder.name.setText(story.getName());
		
		if (story.isOutline()) {
			storyViewHolder.storyImage.setBorderColor(context.getResources().getColor(R.color.pink));
		} else {
			storyViewHolder.storyImage.setBorderColor(context.getResources().getColor(R.color.transparent));
		}
		
		
	}
	
	@Override
	public int getItemCount() {
		if (stories != null) {
			return stories.size();
		}
		return 0;
	}
	
	class StoryViewHolder extends RecyclerView.ViewHolder {
		
		CircleImageView storyImage;
		TextView name;
		
		StoryViewHolder(@NonNull View itemView) {
			super(itemView);
			
			storyImage = itemView.findViewById(R.id.storyImage);
			name=itemView.findViewById(R.id.storyName);
		
		}
	}
}
