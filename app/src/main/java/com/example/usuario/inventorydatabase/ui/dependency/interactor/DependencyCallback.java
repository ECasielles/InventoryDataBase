package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.utils.Error;

/**
 * Created by usuario on 25/01/18.
 */

public interface DependencyCallback {

    void onSuccess();

    void onError(Error error);

}
