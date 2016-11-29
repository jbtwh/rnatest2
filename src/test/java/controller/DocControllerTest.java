package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.rnatest.conf.MainConfig;
import me.rnatest.controller.MainController;
import me.rnatest.entity.Cd;
import me.rnatest.service.DocService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by DEN
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class})
@WebAppConfiguration
public class DocControllerTest {

    MockMvc mockMvc;

    @Autowired
    private MainController mycontroller;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(mycontroller).build();
    }

    @Test
    public void testAddDoc()  throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource("test.xml").getFile());
        File file2 = new File(classLoader.getResource("test2.xml").getFile());

        FileInputStream fi1 = new FileInputStream(file1);
        FileInputStream fi2 = new FileInputStream(file2);

        MockMultipartFile mmf1 = new MockMultipartFile("file", file1.getName(), "multipart/form-data",fi1);
        MockMultipartFile mmf2 = new MockMultipartFile("file", file2.getName(), "multipart/form-data",fi2);

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload")
                .file(mmf1))
                //.andDo(print())
                .andExpect(status().isOk());


        MvcResult result=mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        List<Cd> cds = mapper.readValue(content, new TypeReference<List<Cd>>(){});
        assertEquals(cds.size(), 12);
        assertEquals(cds.get(0).title, "Empire Burlesque3");

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload")
                .file(mmf2))
                //.andDo(print())
                .andExpect(status().isOk());

        result=mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andReturn();

        content = result.getResponse().getContentAsString();
        cds = mapper.readValue(content, new TypeReference<List<Cd>>(){});
        assertEquals(cds.size(), 13);
        assertEquals(cds.get(12).title, "Empire Burlesque2");

    }

}
