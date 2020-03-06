package com.example.myapplication;

public interface GetPostsContract {

    interface View {
        void showLoadingProgress(boolean state);
        void showPosts(String posts);
    }

    interface Presenter {
        void onViewCreated();
        void onViewDestroyed();
    }
}
