package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raul_515
 */
public class Servicio {
    
    private Repositorio repo;
    private MailerStub mailer;
    
    public Servicio(Repositorio repo, MailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }
    
    public boolean crearToDo(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty() || fechaLimite == null) return false;
        
        boolean exito = repo.guardarToDo(new ToDo(nombre, "", fechaLimite));
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    public boolean agregarEmail(String email) {
        if (email == null || !email.contains("@")) return false;
        boolean exito = repo.guardarEmail(email);
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    public boolean marcarFinalizada(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) return false;
        boolean exito = repo.marcarCompletado(nombre);
        revisarExpiradasYEnviarAlertas();
        return exito;
    }

    public List<ToDo> consultarPendientes() {
        revisarExpiradasYEnviarAlertas();
        return repo.obtenerPendientes();
    }

    // Este método es interno para cumplir el requisito de revisar expiradas en cada acción
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
