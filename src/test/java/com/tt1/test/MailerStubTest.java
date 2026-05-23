package com.tt1.test;

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
public class MailerStubTest {
    
    public MailerStubTest() {
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
     * Test of enviarCorreo method, of class MailerStub.
     */
    @Test
    public void testEnviarCorreo() {
        System.out.println("enviarCorreo");
        String direccion = "test@unirioja.es";
        String mensaje = "Mensaje de prueba";
        MailerStub instance = new MailerStub();
        boolean expResult = true;
        boolean result = instance.enviarCorreo(direccion, mensaje);
        assertEquals(expResult, result);
    }
    
}
