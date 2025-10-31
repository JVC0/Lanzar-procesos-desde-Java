package com.docencia.dam.dam.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.dam.services.impl.PsHeadServiceImpl;

public class ComandoPsServiceTest {
    PsHeadServiceImpl psHeadServiceImpl;

    @BeforeEach
    void before() {
        psHeadServiceImpl = new PsHeadServiceImpl();
        psHeadServiceImpl.setComando("ps");
    }

    @Test
    void validarTest() {
        String[] arrayComando = { "ps", "-xa" };
        boolean valida = psHeadServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida, "Se a producido un error de validacion");
    }

    @Test
    void validarvacioTest() {
        String[] arrayComando = { "ps", " " };
        boolean valida = psHeadServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida, "Se a producido un error de validacion");
    }

    @Test
    void validarvmenosTest() {
        String[] arrayComando = { "ps", "-" };
        boolean valida = psHeadServiceImpl.validar(arrayComando);
        Assertions.assertFalse(valida, "Se a producido un error de validacion");
    }
    void validarheadTest() {
        String[] arrayComando = { "ps", "aux | head" };
        boolean valida = psHeadServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida, "Se a producido un error de validacion");
    }

    @Test
    void validarfalseTest() {
        String[] arrayComando = { "ps", "-lalalala" };
        boolean valida = psHeadServiceImpl.validar(arrayComando);
        Assertions.assertFalse(valida, "hola esto");
    }
    
    

}
