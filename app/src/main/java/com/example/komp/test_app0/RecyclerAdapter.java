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
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_EMPTY = 2;
    private static final int TYPE_ALL = 1;
    List<String> items = new ArrayList<>();
    List<String> num = new ArrayList<>();
    List<String> emp = new ArrayList<>();

    public void addText(String text) {
        items.add(text);
        notifyDataSetChanged();
    }

    public void delete(int pos) {
        items.remove(pos);
        notifyItemRemoved(pos);
    }

    public class AllViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView;
        public TextView m2TextView;
        public Button button;
        private int pos;

        public AllViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            m2TextView = (TextView) v.findViewById(R.id.tv2_recycler_item);
            button = (Button) v.findViewById(R.id.button);
            if(button!=null) {
                button.setOnClickListener(this);
            }
        }

        public void bindInfo(String str, int pos) {
            this.pos = pos;
            mTextView.setText(str);
            m2TextView.setText(String.valueOf(pos + 1));
        }
        @Override
        public void onClick(View v) {
            delete(pos);
        }
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public TextView empty;

        public EmptyViewHolder(View a) {
            super(a);
            empty = (TextView) a.findViewById(R.id.empty);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case TYPE_ALL:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
                return new AllViewHolder(v);
            case TYPE_EMPTY:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_item, parent, false);
                return new EmptyViewHolder(v);
            default:
                throw new IllegalArgumentException("Bad recycler params type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_ALL:
                holder.bindInfo(items.get(position), position);
                break;
            case TYPE_EMPTY:
                holder.bindInfo(emp.get(position), position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return items.isEmpty() ? TYPE_EMPTY : TYPE_ALL;
    }

    @Override
    public int getItemCount() {
        return items == null ? 1 : items.size();
    }
}
