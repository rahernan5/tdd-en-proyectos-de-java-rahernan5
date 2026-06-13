package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raul_515
 * Clase principal de la lógica de negocio del sistema de tareas.
 * Se encarga de gestionar la creación de tareas, validación de datos, 
 * control de usuarios y envío de alertas por tareas expiradas.
 */
public class Servicio {
    
    private Repositorio repo;
    private MailerStub mailer;
    
    /**
     * Constructor del Servicio que inyecta las dependencias necesarias.
     * @param repo El repositorio donde se guardarán y consultarán los datos.
     * @param mailer El servicio encargado de simular el envío de correos electrónicos.
     */
    public Servicio(Repositorio repo, MailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }
    
    /**
     * Valida los datos y crea una nueva tarea en el sistema.
     * Además, comprueba si hay tareas caducadas para enviar alertas.
     * @param nombre El nombre descriptivo de la tarea (no puede estar vacío).
     * @param fechaLimite La fecha tope de la tarea (no puede ser null).
     * @return true si la tarea se creó y guardó con éxito, false si los datos son inválidos.
     */
    public boolean crearToDo(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty() || fechaLimite == null) return false;
        
        boolean exito = repo.guardarToDo(new ToDo(nombre, "", fechaLimite));
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    /**
     * Valida y añade un nuevo correo electrónico a la agenda del sistema para recibir alertas.
     * @param email La dirección de correo electrónico a registrar.
     * @return true si el email es válido (contiene '@') y se guardó, false en caso contrario.
     */
    public boolean agregarEmail(String email) {
        if (email == null || !email.contains("@")) return false;
        boolean exito = repo.guardarEmail(email);
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    /**
     * Marca una tarea específica como completada buscando por su nombre.
     * @param nombre El nombre de la tarea que se ha terminado.
     * @return true si se actualizó correctamente, false si el nombre es inválido o no existe.
     */
    public boolean marcarFinalizada(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) return false;
        boolean exito = repo.marcarCompletado(nombre);
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    /**
     * Consulta la lista de todas las tareas que aún no han sido finalizadas.
     * Dispara automáticamente la revisión de tareas expiradas.
     * @return Una lista con los objetos ToDo que tienen el estado de completado en false.
     */
    public List<ToDo> consultarPendientes() {
        revisarExpiradasYEnviarAlertas();
        return repo.obtenerPendientes();
    }

    /**
     * Método interno para cumplir el requisito de revisar expiradas en cada acción.
     * Si encuentra alguna tarea cuya fecha límite sea anterior a hoy, envía un email
     * a todas las direcciones guardadas en la agenda.
     */
    private void revisarExpiradasYEnviarAlertas() {
        List<ToDo> pendientes = repo.obtenerPendientes();
        boolean expiradas = pendientes.stream().anyMatch(t -> t.getFechaLimite().isBefore(LocalDate.now()));
        
        if (expiradas) {
            for (String email : repo.obtenerAgenda()) {
                mailer.enviarCorreo(email, "¡ATENCIÓN! Tienes tareas pendientes que han expirado.");
            }
        }
    }
}
