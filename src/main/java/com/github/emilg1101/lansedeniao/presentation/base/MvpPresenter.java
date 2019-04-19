package com.github.emilg1101.lansedeniao.presentation.base;

public abstract class MvpPresenter<T extends MvpView> {

    private T mView;

    public void bind(T view) {
        mView = view;
        onFirstAttach();
    }

    protected T getView() {
        return mView;
    }

    public void onFirstAttach() {

    }

    public void onDestroy() {

    }
}
