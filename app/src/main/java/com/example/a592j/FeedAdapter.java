package com.example.a592j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Feed> stories;

    int ADDSTORY = 0;
    int STORY = 1;

    public FeedAdapter(Context context, ArrayList<Feed> stories) {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)){
            return ADDSTORY;
        }else {
            return STORY;
        }
    }

    Boolean isHeader(int position){
        return position ==0;
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ADDSTORY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post, parent, false);
            return new CreateViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post1, parent, false);
            return new StoryViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Feed story = stories.get(position);

        if (holder instanceof CreateViewHolder){

        }

        if (holder instanceof StoryViewHolder){
            ImageView  iv_background = ((StoryViewHolder) holder).iv_background;
            iv_background.setImageResource(story.photo);
            ShapeableImageView iv_profile = ((StoryViewHolder) holder).iv_profile;
            iv_profile.setImageResource(story.profile);
            TextView tv_fullname = ((StoryViewHolder) holder).tv_fullname;
            tv_fullname.setText(story.text);
        }
    }

    class CreateViewHolder extends RecyclerView.ViewHolder{

        public CreateViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class StoryViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_background;
        ShapeableImageView iv_profile;
        TextView tv_fullname;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_background = itemView.findViewById(R.id.iv_photo);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
}
