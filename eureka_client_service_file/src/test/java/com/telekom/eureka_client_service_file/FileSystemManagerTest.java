package com.telekom.eureka_client_service_file;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.telekom.eureka_client_service_file.exception.BusinessLogicException;
import com.telekom.eureka_client_service_file.model.FileModel;
import com.telekom.eureka_client_service_file.model.FileModelDTO;
import com.telekom.eureka_client_service_file.repository.FileRepository;
import com.telekom.eureka_client_service_file.service.FileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FileSystemManagerTest {
    private final static String FILENAME = "test.txt";

    FileModelDTO fileModelDTO;


    @Autowired
    private FileService fileSystemService;

    @Autowired
    private FileRepository fileRepository;

    @Before
    public void init() throws IOException {
        fileModelDTO = new FileModelDTO();
        File file = ResourceUtils.getFile("classpath:test.txt");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "text/plain", IOUtils.toByteArray(input));
        fileModelDTO.setFileName("test");
        fileModelDTO.setDateDurationDescription("2018-12-30T20:00:00");
        fileModelDTO.setMultipartFile(multipartFile);
    }

    @Test
    public void upload() throws BusinessLogicException, ParseException, IOException {
        FileModel fileModel = fileSystemService.uploadFile(fileModelDTO);
        Assert.assertNotNull(fileModel);
    }

    /**
     * check file repository
     */
    @Test
    public void findModelByName() throws BusinessLogicException, ParseException, IOException {
        fileSystemService.uploadFile(fileModelDTO);
        FileModel fileModel = fileRepository.findByName(FILENAME);
        Assert.assertNotNull(fileModel);
    }

    /**
     * download file by token
     * @throws IOException
     * @throws ParseException
     * @throws BusinessLogicException
     */
    @Test
    public void download() throws IOException, BusinessLogicException, ParseException {
        fileSystemService.uploadFile(fileModelDTO);
        FileModel fileModel = fileRepository.findByName(FILENAME);
        Resource resource = fileSystemService.downloadFile(fileModel.getToken());
        Assert.assertNotNull(resource);
    }
    /**
     * check count files after removing
     * @throws IOException
     * @throws BusinessLogicException
     */
    @Test
    public void deleteFile() throws IOException, BusinessLogicException, ParseException {
        fileSystemService.uploadFile(fileModelDTO);
        List<FileModel> fileModels = (List<FileModel>) fileRepository.findAll();
        FileModel fileModel = fileRepository.findByName(FILENAME);
        fileSystemService.deleteFile(fileModel.getToken());
        List<FileModel> newFileModels = (List<FileModel>) fileRepository.findAll();
        Assert.assertTrue(fileModels.size() - newFileModels.size() == 1);
    }

}