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
public class DBStubTest {
    
    public DBStubTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of insertarTarea method, of class DBStub.
     */
    @Test
    public void testInsertarTarea() {
        System.out.println("insertarTarea");
        ToDo tarea = new ToDo("Tarea 1", "Desc", LocalDate.now());
        DBStub instance = new DBStub();
        boolean expResult = true;
        boolean result = instance.insertarTarea(tarea);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertarEmail method, of class DBStub.
     */
    @Test
    public void testInsertarEmail() {
        System.out.println("insertarEmail");
        String email = "correo@prueba.com";
        DBStub instance = new DBStub();
        boolean expResult = true;
        boolean result = instance.insertarEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasLasTareas method, of class DBStub.
     */
    @Test
    public void testObtenerTodasLasTareas() {
        System.out.println("obtenerTodasLasTareas");
        DBStub instance = new DBStub();
        instance.insertarTarea(new ToDo("Tarea", "Desc", LocalDate.now()));
        List<ToDo> result = instance.obtenerTodasLasTareas();
        assertEquals(1, result.size());
    }

    /**
     * Test of obtenerTodosLosEmails method, of class DBStub.
     */
    @Test
    public void testObtenerTodosLosEmails() {
        System.out.println("obtenerTodosLosEmails");
        DBStub instance = new DBStub();
        instance.insertarEmail("correo@prueba.com");
        List<String> result = instance.obtenerTodosLosEmails();
        assertEquals(1, result.size());
    }
    
}
