package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.view.HelpView;
import org.springframework.stereotype.Component;

@Component
public class HelpPresenter extends MvpPresenter<HelpView> {

    @Override
    public void onFirstAttach() {
        getView().show();
    }
}
