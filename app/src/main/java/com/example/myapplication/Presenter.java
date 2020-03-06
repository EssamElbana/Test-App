package com.example.myapplication;

public class Presenter implements GetPostsContract.Presenter {
    GetPostsContract.View mView;
    GetMethodDemo getMethodDemo;
    CustomAsyncTask customAsyncTask;

    public Presenter(GetPostsContract.View view) {
        mView = view;
    }

    @Override
    public void onViewCreated() {
        getMethodDemo = new GetMethodDemo();
         customAsyncTask
                = new CustomAsyncTask(new AsyncContract() {
            @Override
            public void onPreExecute() {
                mView.showLoadingProgress(true);
            }

            @Override
            public String doInBackGround() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String response = getMethodDemo.getServer_response("https://jsonplaceholder.typicode.com/posts");
                return response;
            }

            @Override
            public void onPostExecute(String response) {
                if (mView != null && response != null) {
                    mView.showLoadingProgress(false);
                    mView.showPosts(response);
                }
            }
            @Override
            public void onCancelled() {

            }
        });

        customAsyncTask.execute();

    }

    @Override
    public void onViewDestroyed() {
        if(!customAsyncTask.isCancelled())
            customAsyncTask.cancel(true);
        mView = null;
    }
}
