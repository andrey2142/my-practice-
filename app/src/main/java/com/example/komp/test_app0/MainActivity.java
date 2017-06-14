package com.example.komp.test_app0;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by komp on 13.06.2017.
 */

public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //Button okbutt1;
    //EditText editText;
    // EditText editText2;

    List<String> items = new ArrayList<>();
    // List<String> num = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myDataset = new String[100];

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        setContentView(R.layout.activity_main);
        final EditText editTex = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.okbutt1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = editTex.getText().toString();
                //String num = editText2.getText().toString();
                if (null != input && input.length() > 0) {
                    items.add(input);
                    mAdapter.notifyDataSetChanged();
                }
                //if (null != input && input.length() > 0) {
                //    items.add(num);
                //}
            }
        });
    }
}

