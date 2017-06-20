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
        final EditText editTex0 = (EditText) findViewById(R.id.editText);
        final EditText editTex1 = (EditText) findViewById(R.id.editText2);
        final Button button1 = (Button) findViewById(R.id.okbutt1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = editTex0.getText().toString();
                //String input2 = editTex1.getText().toString();
                if (null != input && input.length() > 0) {
                    mAdapter.addText(input);
                    editTex0.setText("");
                    editTex1.setText("");
                }
                    else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Напиши что нибудь!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}
