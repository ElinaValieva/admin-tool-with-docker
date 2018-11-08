package com.telekom.eureka_client_service_file.service;

import com.telekom.eureka_client_service_file.exception.BusinessLogicException;
import com.telekom.eureka_client_service_file.model.FileModel;
import com.telekom.eureka_client_service_file.model.FileModelDTO;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;

/**
 * Service for working with files
 * - save file
 * - load file
 * - delete file
 * - delete all files
 */
public interface FileManager {

    void saveFile(FileModelDTO fileModelDTO) throws IOException, BusinessLogicException;

    String generateToken(FileModelDTO fileModelDTO) throws UnsupportedEncodingException;

    void deleteAll() throws IOException;

    void deleteFile(String fileName) throws IOException;

    void deleteFile(FileModel fileModel) throws IOException;

    Resource loadFile(FileModel fileModel) throws IOException, BusinessLogicException;

    Path getFileDirectory(String fileName) throws IOException;
}
