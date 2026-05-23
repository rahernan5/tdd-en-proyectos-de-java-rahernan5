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
public class RepositorioTest {
    
    private Repositorio repositorio;
    private DBStub db;
    
    public RepositorioTest() {
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
        repositorio = new Repositorio(db);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of encontrarToDo method, of class Repositorio.
     */
    @Test
    public void testEncontrarToDo() {
        System.out.println("encontrarToDo");
        String nombre = "Mi Tarea";
        repositorio.guardarToDo(new ToDo(nombre, "Desc", LocalDate.now()));
        
        ToDo result = repositorio.encontrarToDo(nombre);
        assertNotNull(result);
        assertEquals(nombre, result.getNombre());
    }

    /**
     * Test of marcarCompletado method, of class Repositorio.
     */
    @Test
    public void testMarcarCompletado() {
        System.out.println("marcarCompletado");
        String nombre = "Aprender JUnit";
        repositorio.guardarToDo(new ToDo(nombre, "Desc", LocalDate.now()));
        
        boolean expResult = true;
        boolean result = repositorio.marcarCompletado(nombre);
        assertEquals(expResult, result);
        assertEquals(0, repositorio.obtenerPendientes().size());
    }

    /**
     * Test of guardarToDo method, of class Repositorio.
     */
    @Test
    public void testGuardarToDo() {
        System.out.println("guardarToDo");
        ToDo todo = new ToDo("Nueva", "Desc", LocalDate.now());
        boolean expResult = true;
        boolean result = repositorio.guardarToDo(todo);
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarEmail method, of class Repositorio.
     */
    @Test
    public void testGuardarEmail() {
        System.out.println("guardarEmail");
        String email = "alumno@unirioja.es";
        boolean expResult = true;
        boolean result = repositorio.guardarEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerPendientes method, of class Repositorio.
     */
    @Test
    public void testObtenerPendientes() {
        System.out.println("obtenerPendientes");
        repositorio.guardarToDo(new ToDo("Tarea Pendiente", "Desc", LocalDate.now()));
        List<ToDo> result = repositorio.obtenerPendientes();
        assertEquals(1, result.size());
    }

    /**
     * Test of obtenerAgenda method, of class Repositorio.
     */
    @Test
    public void testObtenerAgenda() {
        System.out.println("obtenerAgenda");
        repositorio.guardarEmail("correo@prueba.com");
        List<String> result = repositorio.obtenerAgenda();
        assertEquals(1, result.size());
    }
}
