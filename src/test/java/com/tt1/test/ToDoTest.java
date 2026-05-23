package com.tt1.test;

import java.time.LocalDate;
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
public class ToDoTest {
    
    public ToDoTest() {
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
     * Test of getNombre method, of class ToDo.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        LocalDate fecha = LocalDate.of(2023, 12, 31); 
        ToDo instance = new ToDo("Estudiar Java", "Repasar JUnit", fecha);
        String expResult = "Estudiar Java";
        String result = instance.getNombre();
        assertEquals(expResult, result, "El nombre devuelto no coincide con el esperado");
    }

    /**
     * Test of setNombre method, of class ToDo.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        ToDo instance = new ToDo("Inicial", "Desc", LocalDate.now());
        String nombre = "Nuevo Nombre";
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    /**
     * Test of getDescripcion method, of class ToDo.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        ToDo instance = new ToDo("Nombre", "Una descripcion", LocalDate.now());
        String expResult = "Una descripcion";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescripcion method, of class ToDo.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        ToDo instance = new ToDo("Nombre", "Inicial", LocalDate.now());
        String descripcion = "Nueva descripcion";
        instance.setDescripcion(descripcion);
        assertEquals(descripcion, instance.getDescripcion());
    }

    /**
     * Test of getFechaLimite method, of class ToDo.
     */
    @Test
    public void testGetFechaLimite() {
        System.out.println("getFechaLimite");
        LocalDate expResult = LocalDate.of(2024, 10, 10);
        ToDo instance = new ToDo("Nombre", "Desc", expResult);
        LocalDate result = instance.getFechaLimite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaLimite method, of class ToDo.
     */
    @Test
    public void testSetFechaLimite() {
        System.out.println("setFechaLimite");
        ToDo instance = new ToDo("Nombre", "Desc", LocalDate.now());
        LocalDate fechaLimite = LocalDate.of(2025, 1, 1);
        instance.setFechaLimite(fechaLimite);
        assertEquals(fechaLimite, instance.getFechaLimite());
    }

    /**
     * Test of isCompletado method, of class ToDo.
     */
    @Test
    public void testIsCompletado() {
        System.out.println("isCompletado");
        ToDo instance = new ToDo("Nombre", "Desc", LocalDate.now());
        boolean expResult = false; // Por defecto se inicializa en false
        boolean result = instance.isCompletado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompletado method, of class ToDo.
     */
    @Test
    public void testSetCompletado() {
        System.out.println("setCompletado");
        ToDo instance = new ToDo("Nombre", "Desc", LocalDate.now());
        boolean completado = true;
        instance.setCompletado(completado);
        assertTrue(instance.isCompletado());
    }
    
}
