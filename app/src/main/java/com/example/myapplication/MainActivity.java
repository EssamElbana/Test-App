package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GetPostsContract.View {

    ProgressDialog progressDialog;
    TextView textView;
    GetPostsContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        textView =  findViewById(R.id.textView);
        mPresenter = new Presenter(this);
        mPresenter.onViewCreated();


    }


    @Override
    public void showLoadingProgress(boolean state) {
        if(progressDialog != null)
            if(state)
                progressDialog.show();
            else
                progressDialog.hide();
    }

    @Override
    public void showPosts(String posts) {
        if(textView!=null)
            textView.setText(posts);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
