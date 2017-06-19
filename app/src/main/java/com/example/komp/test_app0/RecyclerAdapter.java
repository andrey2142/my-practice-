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

    private static final int TYPE_EMPTY = 2;
    private static final int TYPE_ALL = 1;

    List<String> items = new ArrayList<>();
    //List<String> empxx = new ArrayList<>();


    public void addText(String text) {
        items.add(text);
        notifyDataSetChanged();
    }

    public void delete(int pos) {
        items.remove(pos);
        notifyItemRemoved(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        public TextView m2TextView;
        //public TextView m3TextView;
        public Button button;
        private int pos;


        public ViewHolder (View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            m2TextView = (TextView) v.findViewById(R.id.tv2_recycler_item);
            //m3TextView = (TextView) v.findViewById(R.id.empty);
            //m3TextView.setText("Empty");
            button = (Button) v.findViewById(R.id.button);
            if(button!=null) {
                button.setOnClickListener(this);
            }


        }

        public void bindInfo(String str, int pos) {
            this.pos = pos;
            mTextView.setText(str);
            m2TextView.setText(String.valueOf(pos+1));
            //m3TextView.setText(str);
        }

        @Override
        public void onClick(View v) {
            delete(pos);
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resLayout = 0;
        switch (viewType) {
            case TYPE_ALL:
                resLayout = R.layout.recycler_item;
                break;
            case TYPE_EMPTY:
                resLayout = R.layout.empty_item;
                break;
        }
        View v = LayoutInflater.from(parent.getContext()).inflate(resLayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.bindInfo(items.get(position), position);
    }
    @Override
    public int getItemViewType(int position) {
        return items.isEmpty() ? TYPE_EMPTY : TYPE_ALL;
    }
    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
