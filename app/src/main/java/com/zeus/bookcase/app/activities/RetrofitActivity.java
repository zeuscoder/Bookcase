package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.api.MyAPI;
import com.zeus.bookcase.app.model.GitModel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by zeus_coder on 2015/10/2.
 */
public class RetrofitActivity extends Activity {

    private Button btn;
    private EditText et;
    private TextView tv;
    ProgressBar bar;
    String API = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);

        btn = (Button) findViewById(R.id.retro);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.retro_tv);
        bar = (ProgressBar) findViewById(R.id.pb);
        bar.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = et.getText().toString();
                bar.setVisibility(View.VISIBLE);
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).build();
                MyAPI git = restAdapter.create(MyAPI.class);

                git.getFeed(user,new Callback<GitModel>() {
                    @Override
                    public void success(GitModel gitmodel, Response response) {
                        // we get json object from github server to our POJO or model class
                        tv.setText("Github Name :" + gitmodel.getLogin());

                        bar.setVisibility(View.INVISIBLE); // disable progressbar
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        tv.setText(error.getMessage());
                        bar.setVisibility(View.INVISIBLE); // disable progressbar
                    }
                });
            }
        });
    }
}
