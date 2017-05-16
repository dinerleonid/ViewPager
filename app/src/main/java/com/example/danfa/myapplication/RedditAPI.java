package com.example.danfa.myapplication;

import com.example.danfa.myapplication.model.Flower;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RedditAPI {

    @GET("users/octocat/repos")
    Call<ArrayList<Flower>> getChannelData();
}