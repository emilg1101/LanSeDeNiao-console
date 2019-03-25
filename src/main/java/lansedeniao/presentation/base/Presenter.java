package lansedeniao.presentation.base;

public abstract class Presenter<T extends View> {

    private T mView;

    public void bind(T view) {
        mView = view;
    }

    public T getView() {
        return mView;
    }
}
