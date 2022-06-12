package com.live.myinstaclone.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.live.myinstaclone.Activities.MainActivity;
import com.live.myinstaclone.Adapters.StoryAdapter;
import com.live.myinstaclone.Adapters.TimelinePostAdapter;
import com.live.myinstaclone.Model.Story;
import com.live.myinstaclone.Model.TimelinePost;
import com.live.myinstaclone.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
	
	private RecyclerView rvPosts;
	private TimelinePostAdapter postAdapter;
	private ArrayList<TimelinePost> posts;
	private ArrayList<Story> stories;
	private RecyclerView rvStories;
	private StoryAdapter storyAdapter;


	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_layout, container, false);
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		

		posts = new ArrayList<>();
		stories = new ArrayList<>();
		rvStories = view.findViewById(R.id.rvStories);
		rvPosts = view.findViewById(R.id.rvPosts);

		populateStories();
		storyAdapter = new StoryAdapter(getContext(), stories);
		//Populating posts
		posts.add(new TimelinePost(MainActivity.images[0], "Sidd", MainActivity.images[0],112, "How is that, Boy?", "10 min ago"));
		posts.add(new TimelinePost(MainActivity.images[1], "Ravi", MainActivity.images[4],240, "Hello world!", "2 hr ago"));
		posts.add(new TimelinePost(MainActivity.images[2], "Mohit", MainActivity.images[2],110, "World Champion!", "20 min ago"));
		posts.add(new TimelinePost(MainActivity.images[0], "Rohit", MainActivity.images[5],220, "Championship! 2022", "1 hr ago"));
		posts.add(new TimelinePost(MainActivity.images[2], "Akash", MainActivity.images[4],230, "World War 2!!!", "2 days ago"));
		posts.add(new TimelinePost(MainActivity.images[1], "Sidd", MainActivity.images[1],500, "World Peace!", "2 week ago"));


		rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
		
		postAdapter = new TimelinePostAdapter(getContext(), posts);
		rvPosts.setAdapter(postAdapter);

		LinearLayoutManager storiesLayoutManager = new LinearLayoutManager(getContext());
		storiesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		rvStories.setLayoutManager(storiesLayoutManager);

		rvStories.setAdapter(storyAdapter);
		
	}
	private void populateStories() {
		//Population logic goes here

		stories.add(new Story(MainActivity.images[7], "Your Story", false));
		stories.add(new Story(MainActivity.images[1],"Ravi", true));
		stories.add(new Story(MainActivity.images[2], "Sidd",true));
		stories.add(new Story(MainActivity.images[3],"Vikas" ,false));
		stories.add(new Story(MainActivity.images[4], "Ankur",false));
		stories.add(new Story(MainActivity.images[1], "Rohit",true));
		stories.add(new Story(MainActivity.images[2], "Ankit",true));
		stories.add(new Story(MainActivity.images[3], "Sumit",false));
		stories.add(new Story(MainActivity.images[4], "Prateek",false));

	}
}
