package com.tt1.test;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Raul_515
 */
public class ServicioIT {
    
    @Test
    public void testFlujoCompletoCrearYConsultarTarea() {
        // 1. ARRANGE: Integración completa con DBStub y MailerStub reales (sin usar Mocks)
        DBStub baseDeDatos = new DBStub();
        Repositorio repositorio = new Repositorio(baseDeDatos);
        MailerStub mailer = new MailerStub();
        
        Servicio servicio = new Servicio(repositorio, mailer);
        
        // 2. ACT
        servicio.agregarEmail("profesor@unirioja.es");
        servicio.crearToDo("Tarea de Integración", LocalDate.now().plusDays(2));
        
        // Obtenemos la lista de pendientes para ver si se guardó todo bien
        int cantidadPendientes = servicio.consultarPendientes().size();

        // 3. ASSERT
        assertEquals(1, cantidadPendientes, "Debería haber 1 tarea pendiente en la base de datos");
        assertEquals("Tarea de Integración", servicio.consultarPendientes().get(0).getNombre());
    }

    
}
