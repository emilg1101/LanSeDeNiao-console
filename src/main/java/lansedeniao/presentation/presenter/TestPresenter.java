package lansedeniao.presentation.presenter;

import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.view.TestView;

public class TestPresenter extends Presenter<TestView> {

    private int count = 0;

    public void onTest2Command() {
        getView().test2("test2");
    }

    public void onTest3Command() {
        getView().test3(count);
        count++;
    }
}
