package com.tt1.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Raul_515
 * Clase encargada de la persistencia y recuperación de los datos.
 * Actúa como intermediario entre la lógica de negocio y la base de datos subyacente.
 */
public class Repositorio {
    
    private DBStub db;
    
    /**
     * Constructor del repositorio.
     * @param db La base de datos simulada (Stub) donde se almacenan las colecciones de datos.
     */
    public Repositorio(DBStub db) {
        this.db = db;
    }
    
    /**
     * Busca una tarea específica en la base de datos por su nombre.
     * @param nombre El nombre exacto de la tarea a buscar.
     * @return El objeto ToDo si se encuentra, o null si no existe.
     */
    public ToDo encontrarToDo(String nombre) {
        return db.obtenerTodasLasTareas().stream()
                 .filter(t -> t.getNombre().equals(nombre))
                 .findFirst().orElse(null);
    }

    /**
     * Marca una tarea existente en la base de datos como completada.
     * @param nombre El nombre de la tarea que se desea finalizar.
     * @return true si la tarea se encontró y se marcó correctamente, false en caso contrario.
     */
    public boolean marcarCompletado(String nombre) {
        ToDo t = encontrarToDo(nombre);
        if (t != null) {
            t.setCompletado(true);
            return true;
        }
        return false;
    }

    /**
     * Inserta un nuevo objeto ToDo en la base de datos.
     * @param todo La tarea previamente instanciada que se desea guardar.
     * @return true si la operación de inserción fue exitosa.
     */
    public boolean guardarToDo(ToDo todo) { return db.insertarTarea(todo); }
    
    /**
     * Inserta un nuevo correo electrónico en la agenda de la base de datos.
     * @param email La cadena de texto con el correo.
     * @return true si se añadió correctamente a la lista.
     */
    public boolean guardarEmail(String email) { return db.insertarEmail(email); }
    
    /**
     * Recupera todas las tareas registradas y filtra las que aún no están acabadas.
     * @return Una lista que contiene únicamente las tareas pendientes (completado = false).
     */
    public List<ToDo> obtenerPendientes() {
        return db.obtenerTodasLasTareas().stream()
                 .filter(t -> !t.isCompletado())
                 .collect(Collectors.toList());
    }

    /**
     * Obtiene el listado completo de los correos electrónicos registrados para enviar alertas.
     * @return Una lista de cadenas de texto (emails).
     */
    public List<String> obtenerAgenda() { return db.obtenerTodosLosEmails(); }
}
