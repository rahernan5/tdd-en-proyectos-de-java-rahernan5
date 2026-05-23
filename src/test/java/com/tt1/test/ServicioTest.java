package com.tt1.test;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Raul_515
 */
public class ServicioTest {
    
    private Servicio servicio;
    private Repositorio repo; 
    private MailerMock mailerMock;
    private DBStub db;
    
    public ServicioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        db = new DBStub();
        repo = new Repositorio(db);
        mailerMock = new MailerMock();
        servicio = new Servicio(repo, mailerMock);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of crearToDo method, of class Servicio.
     */
    @Test
    public void testCrearToDo() {
        System.out.println("crearToDo");
        String nombre = "Comprar pan";
        LocalDate fechaLimite = LocalDate.now().plusDays(1);
        boolean expResult = true;
        boolean result = servicio.crearToDo(nombre, fechaLimite);
        assertEquals(expResult, result);
        assertEquals(1, repo.obtenerPendientes().size());
    }

    /**
     * Test of agregarEmail method, of class Servicio.
     */
    @Test
    public void testAgregarEmail() {
        System.out.println("agregarEmail");
        String email = "alumno@unirioja.es";
        boolean expResult = true;
        boolean result = servicio.agregarEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of marcarFinalizada method, of class Servicio.
     */
    @Test
    public void testMarcarFinalizada() {
        System.out.println("marcarFinalizada");
        String nombre = "Tarea Activa";
        servicio.crearToDo(nombre, LocalDate.now().plusDays(2));
        
        boolean expResult = true;
        boolean result = servicio.marcarFinalizada(nombre);
        assertEquals(expResult, result);
        assertEquals(0, servicio.consultarPendientes().size());
    }

    /**
     * Test of consultarPendientes method, of class Servicio.
     */
    @Test
    public void testConsultarPendientes() {
        System.out.println("consultarPendientes");
        servicio.crearToDo("Tarea 1", LocalDate.now().plusDays(2));
        servicio.crearToDo("Tarea 2", LocalDate.now().plusDays(2));
        
        List<ToDo> result = servicio.consultarPendientes();
        assertEquals(2, result.size());
    }
    
}
