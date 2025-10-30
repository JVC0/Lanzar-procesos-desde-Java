package com.docencia.dam.repositories.file;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;

import com.docencia.dam.repositories.interfaces.JobRepository;

@Repository
public class FileJobRepository implements JobRepository {
    private static Logger logger = LoggerFactory.getLogger(JobRepository.class);
    static String fileName;
    static Path path;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileJobRepository() {
        if (fileName == null) {
            fileName = "mis_procesos.txt";
        }
        URL resources = getClass().getClassLoader().getResource(fileName);
        path = Paths.get(resources.getPath());
    }

    @Override
    public boolean add(String text) {
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (Exception e) {
            logger.error("Se ha produciodo un error almacenamido en el fichero");
        }
        return false;
    }
}
