package com.example.myapplication;

public interface AsyncContract {
    void onPreExecute();
    String doInBackGround();
    void onPostExecute(String response);
    void onCancelled();
}
