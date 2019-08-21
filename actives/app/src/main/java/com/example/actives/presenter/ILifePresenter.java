package com.example.actives.presenter;

import android.os.Bundle;

public interface ILifePresenter {
    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onStop();

    void onDestroy();
}
