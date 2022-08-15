package com.example.a592j;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    void initView(){
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        getAdapter(getAll(), recyclerView);
    }

    void getAdapter(ArrayList<Feed> list, RecyclerView recyclerView) {
        FeedAdapter storyAdapter = new FeedAdapter(this, list);
        recyclerView.setAdapter(storyAdapter);
    }

    ArrayList<Feed> getAll(){
        ArrayList<Feed> feeds = new ArrayList<>();

        feeds.add(new Feed(R.drawable.mac, R.drawable.nissan, "Anna"));
        feeds.add(new Feed(R.drawable.mac, R.drawable.nissan, "Anna"));
        feeds.add(new Feed(R.drawable.mac, R.drawable.nissan, "Anna"));
        feeds.add(new Feed(R.drawable.mac, R.drawable.nissan, "Anna"));

        return feeds;
    }
}