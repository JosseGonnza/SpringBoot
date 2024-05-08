package com.jossegonnza.applicationrest.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatoTests {

    @Test
    public void checkConstructorSinParametro() {

        Dato dato = new Dato();
        assertNotNull(dato);
        assertEquals(dato.getId(), 0, "El id debería ser 0");
        assertEquals(dato.getCadena(), "", "La cadena debería ser ''");
    }

    @Test
    public void checkConstructorConParametro() {

        Dato dato = new Dato(1L, "Twitch");
        assertNotNull(dato);
        assertEquals(dato.getId(), 1L, "El id debería ser 1L");
        assertEquals(dato.getCadena(), "Twitch", "La cadena debería ser \"Twitch\"");
    }
}
