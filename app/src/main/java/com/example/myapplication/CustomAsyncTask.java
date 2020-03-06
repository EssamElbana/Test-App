package com.example.myapplication;

import android.os.AsyncTask;


public class CustomAsyncTask extends AsyncTask<Void, Void, String> {

    AsyncContract asyncContract;

    public CustomAsyncTask(AsyncContract asyncContract) {
        this.asyncContract = asyncContract;
    }

    @Override
    protected void onPreExecute() {
        asyncContract.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... voids) {
        String response = asyncContract.doInBackGround();
        return response;
    }

    @Override
    protected void onPostExecute(String arg) {
        asyncContract.onPostExecute(arg);

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        asyncContract.onCancelled();
    }
}
