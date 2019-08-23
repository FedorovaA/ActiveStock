package com.example.actives.base;

import android.os.Bundle;

/**
 * Created by Angelina Fedorova
 */

public interface ILifePresenter {
    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onStop();

    /**
     * Вызывается перед уничтожением активности
     */
    void onDestroy();
}
