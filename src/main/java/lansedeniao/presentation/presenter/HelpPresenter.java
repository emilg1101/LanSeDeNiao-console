package lansedeniao.presentation.presenter;

import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.view.HelpView;

public class HelpPresenter extends Presenter<HelpView> {

    @Override
    public void onFirstAttach() {
        getView().show();
    }
}
