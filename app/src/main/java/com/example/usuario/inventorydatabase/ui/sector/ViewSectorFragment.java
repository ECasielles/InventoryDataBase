package com.example.usuario.inventorydatabase.ui.sector;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by icenri on 2/1/18.
 */

public class ViewSectorFragment extends Fragment implements ViewSectorContract.View {
    public static final String TAG = "ViewSectorFragment";
    ViewSectorFragment.OnSectorsUpdatedListener callback;
    private ViewSectorContract.Presenter presenter;


    public static ViewSectorFragment newInstance(Bundle bundle) {
        ViewSectorFragment viewSectorFragment = new ViewSectorFragment();
        if (bundle != null)
            viewSectorFragment.setArguments(bundle);
        return viewSectorFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (OnSectorsUpdatedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity + "must implement OnSectorsUpdatedListener interface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setPresenter(new ViewSectorPresenter(this));
    }

    @Override
    public void setPresenter(ViewSectorContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onSectorsUpdated() {
        callback.onSectorsUpdated();
    }

    public interface OnSectorsUpdatedListener {
        void onSectorsUpdated();
    }

}
