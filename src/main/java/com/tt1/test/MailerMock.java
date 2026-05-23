package com.tt1.test;

/**
 *
 * @author Raul_515
 */
public class MailerMock extends MailerStub {
    
    public int correosEnviados = 0; 

    @Override
    public boolean enviarCorreo(String direccion, String mensaje) {
        correosEnviados++;
        return true;
    }
    
}
