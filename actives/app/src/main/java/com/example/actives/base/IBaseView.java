package com.example.actives.base;

import android.content.Context;

/**
 * Created by Angelina Fedorova
 */

public interface IBaseView {

    Context getContext();

    /**
     * Выводит на экран сообщение пользователю
     * @param message строка с текстом
     */
    void showMessage(String message);
}
