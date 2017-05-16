package com.example.danfa.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.danfa.myapplication.model.Flower;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private ArrayList<Flower> data = new ArrayList<>();

    /**
     * Homework:
     * <p>
     * -  show all repositories in recycler view + check if api has photo url, if so display using picasso
     * -  add search and change api accordingly
     *
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        final FlowerAdapter adapter = new FlowerAdapter(getSupportFragmentManager(), data);
        viewPager.setAdapter(adapter);


//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if (position > size) {
//                    viewPager.setCurrentItem(pos );
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RedditAPI redditAPI = retrofit.create(RedditAPI.class);

        redditAPI.getChannelData().enqueue(new Callback<ArrayList<Flower>>() {
            @Override
            public void onResponse(Call<ArrayList<Flower>> call, Response<ArrayList<Flower>> response) {
                Log.d("a", "got response!");
                List<Flower> body = response.body();
                data.addAll(body);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Flower>> call, Throwable t) {
                Log.e("a", "got error!");
            }
        });
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //TODO add ProgressBar widget
//        setContentView(R.layout.activity_main);
//
//        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
//
//        redditAPI.getChannelData().enqueue(new Callback<ArrayList<Flower>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Flower>> call, Response<ArrayList<Flower>> response) {
//                Log.d("a", "got response!");
//                final FlowerAdapter adapter = new FlowerAdapter(getSupportFragmentManager(), response.body());
//                viewPager.setAdapter(adapter);
//
//                //TODO hide loader
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Flower>> call, Throwable t) {
//                Log.e("a", "got error!");
//            }
//        });
//    }


}
