package com.example.usuario.inventorydatabase.data.db.repository;

import android.database.Cursor;

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

public class DependencyRepository {

    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;
    //Si hubiera una conexión, habría un dependencyWebService
    private static DependencyDao dependencyDao;

    static {
        dependencyRepository = new DependencyRepository();
    }

    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
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
    /**
     * OPCION 1: El repositorio devuelve un ArrayList.
     */
    public ArrayList<Dependency> getDependencies() {
        dependencies.clear();
        Cursor cursor = getDependenciesCursor();
        //El cursor siempre se coloca antes del primer elemento.
        if(cursor.moveToFirst())
            do {
                //Acceder a las columnas en el mismo orden
                Dependency dependency = new Dependency(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4)
                );
                dependencies.add(dependency);
            } while (cursor.moveToNext());
        return dependencies;
    }
    /**
     * OPCION 2: El repositorio devuelve un Cursor.
     */
    public Cursor getDependenciesCursor() {
        return dependencyDao.loadAll();
    }

    public boolean exists(Dependency dependency) {
        return false;
    }

    public void editDependency(Dependency dependency, String description) {

    }

    public boolean deleteDependency(Dependency dependency) {
        return false;
    }

    public boolean exists(String name, String shortname) {
        return false;
    }

}
