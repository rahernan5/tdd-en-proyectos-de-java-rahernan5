package com.tt1.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Raul_515
 */
public class Repositorio {
    
    private DBStub db;
    public Repositorio(DBStub db) {
        this.db = db;
    }
    
    public ToDo encontrarToDo(String nombre) {
        return db.obtenerTodasLasTareas().stream()
                 .filter(t -> t.getNombre().equals(nombre))
                 .findFirst().orElse(null);
    }

    public boolean marcarCompletado(String nombre) {
        ToDo t = encontrarToDo(nombre);
        if (t != null) {
            t.setCompletado(true);
            return true;
        }
        return false;
    }

    public boolean guardarToDo(ToDo todo) { return db.insertarTarea(todo); }
    public boolean guardarEmail(String email) { return db.insertarEmail(email); }
    
    public List<ToDo> obtenerPendientes() {
        return db.obtenerTodasLasTareas().stream()
                 .filter(t -> !t.isCompletado())
                 .collect(Collectors.toList());
    }

    public List<String> obtenerAgenda() { return db.obtenerTodosLosEmails(); }
}
