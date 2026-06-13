package com.tt1.test;

import java.time.LocalDate;
/**
 *
 * @author Raul_515
 * Representa una tarea (ToDo) dentro del sistema de gestión.
 * Almacena la información fundamental de una actividad, incluyendo su nombre,
 * descripción, límite de entrega y si ha sido completada.
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Constructor principal para crear una nueva tarea.
     * El estado inicial de la tarea siempre será 'no completado' (false).
     * @param nombre El título o nombre corto de la tarea.
     * @param descripcion Los detalles extendidos de la tarea.
     * @param fechaLimite La fecha tope en la que la tarea debe ser finalizada.
     */
    public ToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }
    
    // Getters y Setters
    
    /** @return El nombre de la tarea. */
    public String getNombre() { return nombre; }
    /** @param nombre El nuevo nombre para la tarea. */
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    /** @return La descripción detallada de la tarea. */
    public String getDescripcion() { return descripcion; }
    /** @param descripcion La nueva descripción para la tarea. */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    /** @return La fecha límite establecida. */
    public LocalDate getFechaLimite() { return fechaLimite; }
    /** @param fechaLimite La nueva fecha límite de entrega. */
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    
    /** @return true si la tarea está completada, false si sigue pendiente. */
    public boolean isCompletado() { return completado; }
    /** @param completado El estado de finalización de la tarea. */
    public void setCompletado(boolean completado) { this.completado = completado; }
    
}
