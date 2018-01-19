package com.example.usuario.inventorydatabase.ui.dependency.fragment;

import android.app.Fragment;

import com.example.usuario.inventorydatabase.ui.base.BasePresenter;
import com.example.usuario.inventorydatabase.ui.dependency.contract.DetailDependencyContract;

public class DetailDependencyFragment extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detaildependency";
    private DetailDependencyContract.Presenter presenter;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (DetailDependencyContract.Presenter) presenter;
    }

}
