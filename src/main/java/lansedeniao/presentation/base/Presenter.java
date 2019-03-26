package lansedeniao.presentation.base;

public abstract class Presenter<T extends View> {

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
