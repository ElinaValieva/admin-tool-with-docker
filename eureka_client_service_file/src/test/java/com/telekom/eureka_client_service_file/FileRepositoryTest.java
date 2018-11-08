package com.telekom.eureka_client_service_file;

import com.telekom.eureka_client_service_file.model.*;
import com.telekom.eureka_client_service_file.repository.FileRepository;
import com.telekom.eureka_client_service_file.service.FileManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileRepositoryTest {

    private final static String FILENAME = "jUnitTest.java";

    @Before
    public void init() throws UnsupportedEncodingException {
        FileModelDTO fileModelDTO = new FileModelDTO();
        fileModelDTO.setFileName(FILENAME);
        FileModel fileModel = new FileModel();
        fileModel.setName(FILENAME);
        fileModel.setToken(fileManager.generateToken(fileModelDTO));
        fileRepository.save(fileModel);
    }

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileManager fileManager;

    @Test
    public void findModelByToken() throws UnsupportedEncodingException {
        FileModelDTO fileModelDTO = new FileModelDTO();
        fileModelDTO.setFileName(FILENAME);
        String token = fileManager.generateToken(fileModelDTO);
        FileModel fileModel = fileRepository.findByToken(token);
        Assert.assertNotNull(fileModel);
    }

    @After
    public void after() {
        FileModel fileModel = fileRepository.findByName(FILENAME);
        fileRepository.delete(fileModel);
    }
}