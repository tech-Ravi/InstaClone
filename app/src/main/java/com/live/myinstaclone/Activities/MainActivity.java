package com.live.myinstaclone.Activities;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.live.myinstaclone.Fragments.HomeFragment;
import com.live.myinstaclone.Fragments.NotificationsFragment;
import com.live.myinstaclone.Fragments.ProfileFragment;
import com.live.myinstaclone.Fragments.SearchFragment;
import com.live.myinstaclone.R;


public class MainActivity extends AppCompatActivity {
	
	//Random image urls below
	public static final String profilePicUrl = "https://media.istockphoto.com/photos/silhouette-of-profile-guy-in-shirt-with-white-button-in-aqua-menthe-picture-id1206439390?k=20&m=1206439390&s=170667a&w=0&h=wDX4xov95UOzjOgOkTqRurDiTepjhqAA7Q2iFofrO5c=";
	public static final String images[] = {profilePicUrl,
			"https://bestprofilepictures.com/wp-content/uploads/2021/04/Cool-Profile-Picture.jpg",
			"https://play-lh.googleusercontent.com/I-Yd5tJnxw7Ks8FUhUiFr8I4kohd9phv5sRFHG_-nSX9AAD6Rcy570NBZVFJBKpepmc=w240-h480-rw",
		"https://miro.medium.com/max/1400/0*xMaFF2hSXpf_kIfG.jpg",
		"https://image.shutterstock.com/image-photo/young-boy-taking-notes-class-260nw-310987217.jpg",
		"https://miro.medium.com/max/1400/0*xMaFF2hSXpf_kIfG.jpg",
		"https://optinmonster.com/wp-content/uploads/2017/08/How-to-Create-a-Split-Test-and-Why-You-Should.jpg",
			"https://eschoolz.in/schoolz/backup/app/users/img/mystory.jpg"
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		initialize();
	}
	
	
	private void initialize() {
		ActionBar actionBar;
		actionBar = getSupportActionBar();
		ColorDrawable colorDrawable
				= new ColorDrawable(Color.parseColor("#ffffff"));
		TextView tv = new TextView(getApplicationContext());
		Typeface typeface = ResourcesCompat.getFont(this, R.font.bilbo_swash_caps);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
				RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
		tv.setLayoutParams(lp);
		tv.setText(getString(R.string.app_name)); // ActionBar title text
		tv.setTextSize(30);
		tv.setTextColor(Color.BLACK);
		tv.setLetterSpacing(0.2F);
		tv.setTypeface(typeface, typeface.BOLD);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(tv);



		//actionBar.setTitle(s);

		//actionBar.setTitle(Html.fromHtml("<font color=\"black\" >" + getString(R.string.app_name) + "</font>"));

		// Set BackgroundDrawable
		actionBar.setBackgroundDrawable(colorDrawable);
		BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
		
		loadFragment(new HomeFragment());               //Default is home fragment
		
		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				
				switch (menuItem.getItemId()) {
					case R.id.home:
						return loadFragment(new HomeFragment());
					case R.id.search:
						return loadFragment(new SearchFragment());
					case R.id.reels:
						return loadFragment(new SearchFragment());
					case R.id.notifications:
						return loadFragment(new NotificationsFragment());
					case R.id.profile:
						return loadFragment(new ProfileFragment());
				}
				
				return false;
			}
		});
	}
	
	
	private boolean loadFragment(Fragment fragment){
		
		if (fragment != null) {
			FragmentManager fm  = getSupportFragmentManager();
			fm.beginTransaction()
				.replace(R.id.container, fragment)
				.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
}
