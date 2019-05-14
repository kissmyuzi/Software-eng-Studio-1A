package com.example.loginactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AdaptorEvent extends RecyclerView.Adapter<AdaptorEvent.MyViewHolder> {
    private ArrayList<Event> mDataset;
    private Context mContext;

    public AdaptorEvent(ArrayList<Event> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName;
        public TextView eventLocation;
        public TextView eventDate;
        public GridLayout parentLayout;
        public MyViewHolder(GridLayout v) {
            super(v);
            eventName = v.findViewById(R.id.tvEventName);
            eventLocation = v.findViewById(R.id.tvEventLocation);
            eventDate = v.findViewById(R.id.tvEventDate);
            parentLayout = (GridLayout) v.findViewById(R.id.parent_layout);
        }
    }

    public AdaptorEvent(ArrayList<Event> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public AdaptorEvent.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        Log.d(TAG, "onCreateViewHolder");
        //LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        MyViewHolder vh = new MyViewHolder((GridLayout) v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.eventName.setText(mDataset.get(position).getEventName());
        holder.eventLocation.setText(mDataset.get(position).getLocation());
        holder.eventDate.setText(mDataset.get(position).getDate());

        holder.parentLayout.setOnClickListener((view) -> {
            Intent intent = new Intent(mContext, EventActivity.class);
            intent.putExtra("eventDate", mDataset.get(position).getDate());
            intent.putExtra("eventName", mDataset.get(position).getEventName());
            intent.putExtra("eventDescription", mDataset.get(position).getDescription());
            intent.putExtra("eventLocation", mDataset.get(position).getLocation());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
