package com.example.usuario.inventorydatabase.data.db.repository;

import com.example.usuario.inventorydatabase.data.db.dao.DependencyDao;
import com.example.usuario.inventorydatabase.data.db.model.Dependency;

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
    //Si hubiera una conexión, habría un dependencyWebService
    private DependencyDao dependencyDao;

    static {
        dependencyRepository = new DependencyRepository();
    }

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


    public void addDependency(Dependency dependency) {

    }

    //ROMPEMOS LA LÓGICA PARA VER AMBAS OPCIONES
    public ArrayList<Dependency> getDependencies() {
        return dependencyDao.loadAll();
    }

    public boolean exists(Dependency dependency) {
        return false; //dependencyDao.dependencies.contains(dependency);
    }

    public void editDependency(Dependency dependency, String description) {

    }

    /**
     * Devuelve el id del elemento o -1.
     * @param dependency
     * @return
     */
    public long saveDependency(Dependency dependency) {
        return dependencyDao.save(dependency);
    }

    public void deleteDependency(Dependency dependency) {
        dependencyDao.delete(dependency);
    }

    public boolean exists(String name, String shortname) {
        return dependencyDao.exists(name, shortname);
    }

}
