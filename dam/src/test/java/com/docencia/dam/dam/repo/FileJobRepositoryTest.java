package com.docencia.dam.dam.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.docencia.dam.repositories.file.FileJobRepository;


class FileJobRepositoryTest {
    static FileJobRepository fileRepository;

    @BeforeAll
    static void beforeall(){
        fileRepository= new FileJobRepository();
        fileRepository.setFileName("fichero-test.txt");
    }
    @Test
    void addContenidoTest(){
        boolean resultado =fileRepository.add("texto");
        Assertions.assertTrue(resultado, "No se ha obtenido el resultado");
    }
}
