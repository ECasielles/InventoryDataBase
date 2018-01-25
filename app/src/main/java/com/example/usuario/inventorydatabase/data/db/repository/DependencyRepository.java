package com.example.usuario.inventorydatabase.data.db.repository;

import com.example.usuario.inventorydatabase.data.db.dao.DependencyDao;
import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.ui.dependency.interactor.DependencyCallback;
import com.example.usuario.inventorydatabase.utils.Error;

import java.util.ArrayList;

/**
 * Caché de datos de Dependency. Extrae los datos de conexión con BD
 * y con servicio web.
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see ArrayList
 * @see Dependency
 */

//Falta una interfaz común a todos los interactor
public class DependencyRepository {

    private static DependencyRepository dependencyRepository;

    static {
        dependencyRepository = new DependencyRepository();
    }

    //Si hubiera una conexión, habría un dependencyWebService
    private DependencyDao dependencyDao;

    private DependencyRepository() {
        dependencyDao = new DependencyDao();
    }

    /**
     * Accesor de la clase DependencyRepository
     * @return Devuelve la instancia de la clase como objeto DependencyRepository
     */
    public static DependencyRepository getInstance(){
        //Nunca va a valer null si no se hace inicialización estática
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }

    public ArrayList<Dependency> getDependencies() {
        return dependencyDao.loadAll();
    }

    public void updateDependency(Dependency dependency, DependencyCallback callback) {
        int result = dependencyDao.update(dependency);
        if (result == 0) {
            callback.onError(new Error(Error.NOT_FOUND));
        } else
            callback.onSuccess();
    }

    /**
     * Devuelve el id del elemento añadido o -1.
     * @param dependency
     * @return
     */
    public void addDependency(Dependency dependency, DependencyCallback callback) {
        long id = dependencyDao.add(dependency);
        if (id == -1)
            callback.onError(new Error(Error.NOT_FOUND));
        else
            callback.onSuccess();
    }

    public void deleteDependency(Dependency dependency, DependencyCallback callback) {
        dependencyDao.delete(dependency);
        int result = dependencyDao.delete(dependency);
        if (result == 0)
            callback.onError(new Error(Error.NOT_FOUND));
        else
            callback.onSuccess();
    }

    public boolean exists(String name, String shortname) {
        return dependencyDao.exists(name, shortname);
    }

}
