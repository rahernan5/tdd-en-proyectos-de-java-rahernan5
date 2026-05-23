package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul_515
 */
public class DBStub {
    
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    
    public boolean insertarTarea(ToDo tarea) { return tareas.add(tarea); }
    public boolean insertarEmail(String email) { return emails.add(email); }
    public List<ToDo> obtenerTodasLasTareas() { return tareas; }
    public List<String> obtenerTodosLosEmails() { return emails; }
}
