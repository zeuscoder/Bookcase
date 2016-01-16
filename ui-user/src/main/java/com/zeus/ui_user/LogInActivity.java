package com.zeus.ui_user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeus.ui_user.activity.RegisterActivity;

/**
 * Created by zeus_coder on 2016/1/14.
 */
public class LogInActivity extends Activity{

    private ImageView close;
    private Button login;
    private TextView register;
    private TextView look;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_log_in);

        close = (ImageView) findViewById(R.id.log_in_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogInActivity.this.finish();
            }
        });

        register = (TextView) findViewById(R.id.user_log_in_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this, RegisterActivity.class));
            }
        });
    }
}
