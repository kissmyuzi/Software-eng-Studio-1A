package com.example.loginactivity;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AdaptorEvent extends RecyclerView.Adapter<AdaptorEvent.MyViewHolder> {
    private ArrayList<Event> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public AdaptorEvent(ArrayList<Event> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public AdaptorEvent.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        //LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).getEventName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
