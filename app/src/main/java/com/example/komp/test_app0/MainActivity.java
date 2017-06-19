package com.example.komp.test_app0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by komp on 13.06.2017.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new RecyclerAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final EditText editTex = (EditText) findViewById(R.id.editText);
        final EditText editTex2 = (EditText) findViewById(R.id.editText2);
        final Button button1 = (Button) findViewById(R.id.okbutt1);

        //final Button button2 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = editTex.getText().toString();
                String nums = editTex2.getText().toString();
                if (null != input && input.length() > 0) {
                    mAdapter.addText(input);
                    mAdapter.addText2(nums);
                    editTex.setText("");
                    editTex2.setText("");

                }
                    else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Напиши что нибудь!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
     /*  button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mAdapter.delete(1);
            }
        });*/
    }

}
