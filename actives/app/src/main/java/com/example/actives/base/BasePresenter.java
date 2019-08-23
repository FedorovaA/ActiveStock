package com.example.actives.base;

/**
 * Created by Angelina Fedorova
 */
public abstract class BasePresenter<T extends IBaseView> implements ILifePresenter {
    protected T view;


    public BasePresenter() {

    }

    /**
     * Вызывается при создании Activity
     * @param view
     */
    public void setView(T view) {
        this.view = view;
    }


}
