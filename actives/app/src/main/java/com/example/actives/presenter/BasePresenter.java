package com.example.actives.presenter;

import com.example.actives.view.IBaseView;

public abstract class BasePresenter<T extends IBaseView> implements ILifePresenter {
    protected T view;

   // protected CompositeDisposable compositeDisposable;

    public BasePresenter() {

        //compositeDisposable = new CompositeDisposable();
    }

    public void setView(T view) {

        this.view = view;
    }

//    public void addSubscription(Disposable disposable) {
//        compositeDisposable.add(disposable);
//    }

//    public void unSubscription() {
//
//        compositeDisposable.dispose();
//    }

//    @Override
//    public void onDestroy() {
//        unSubscription();
//    }
}
