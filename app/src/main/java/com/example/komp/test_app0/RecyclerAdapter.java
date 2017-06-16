package com.example.komp.test_app0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by komp on 13.06.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> items = new ArrayList<>();
    List<String> num = new ArrayList<>();


    public void addText(String text) {
        items.add(text);
        notifyDataSetChanged();
    }

    public void addText2(String text) {
        num.add(text);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView m2TextView;
        public Button button;


        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            m2TextView = (TextView) v.findViewById(R.id.tv2_recycler_item);
            button = (Button) v.findViewById(R.id.button);
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(items.get(position));
        holder.m2TextView.setText(num.get(position));
    }

    @Override
    public int getItemCount() {
        if (items.size() == 0) {
            empty.setVisibility(TextView.INVISIBLE);
        } else {
            empty.setVisibility(TextView.VISIBLE);
        }
        return items.size();

    }
}