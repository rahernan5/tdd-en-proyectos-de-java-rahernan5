package com.tt1.test;

/**
 *
 * @author Raul_515
 */
public class MailerStub {
    
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando EMAIL a " + direccion + ": " + mensaje);
        return true; 
    }
}
