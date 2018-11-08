package com.telekom.eureka_client_service_file.service;

import com.telekom.eureka_client_service_file.exception.BusinessLogicException;
import com.telekom.eureka_client_service_file.model.FileModel;
import com.telekom.eureka_client_service_file.model.FileModelDTO;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.text.ParseException;


/**
 * Main service to upload/download files
 * use FileManager to works with files
 */
public interface FileService {

    FileModel uploadFile(FileModelDTO fileModelDTO) throws IOException, BusinessLogicException, ParseException;

    Resource downloadFile(String token) throws BusinessLogicException, IOException;

    void deleteFile(String fileName) throws IOException, BusinessLogicException;

    void deleteFiles() throws BusinessLogicException, IOException;
}
