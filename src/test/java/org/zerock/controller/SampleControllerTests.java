package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { org.zerock.config.ServletConfig.class, org.zerock.config.WebConfig.class })
@Log4j
public class SampleControllerTests {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testDoA() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sample/doA"));
    }

    @Test
    public void testLogin()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/sample/login")
                .param("id","user00")
                .param("pw","password"));

    }

    @Test
    public void testDateEx()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/sample/dateEx")
                .param("date","2018/05/21"));

    }

    @Test
    public void testDateEx2()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/sample/dateEx2")
                .param("name","Meeting Plack")
                .param("lat","127.123")
                .param("lng","32.112")
                .param("visitDate","2018/05/21")
        );

    }

    @Test
    public void testArrayEx()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/sample/arrayEx")
                .param("text","AAAA")
                .param("text","BBBB")
                .param("text","CCCC")
                .param("text","DDDD")
        );

    }


    @Test
    public void testListEx()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/sample/listEx")
                .param("text","AAAA")
                .param("text","BBBB")
                .param("text","CCCC")
                .param("text","DDDD")
        );

    }

    @Test
    public void testModelEx1()throws Exception{

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/sample/modelEx1")).andReturn();

        ModelAndView mav = result.getModelAndView();

        Assert.assertNotNull(mav.getModelMap().get("product"));

        log.info(mav);
    }

    @Test
    public void testWithoutModel()throws Exception{

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/sample/withoutModel")
                        .param("id","USERID")
                        .param("pw","PASSWORD")).andReturn();

        ModelAndView mav = result.getModelAndView();

        Assert.assertNotNull(mav.getModelMap());

        log.info(mav);
    }

    @Test
    public void testUploadEx()throws Exception {

        MockMultipartFile firstFile = new MockMultipartFile(
                "files", "sampleText.txt", "text/plain", "Hello World!!!".getBytes());
        MockMultipartFile secondFile = new MockMultipartFile(
                "files", "otherFile.data", "text/plain", "Other File Test".getBytes());

        MvcResult result = mockMvc.perform( MockMvcRequestBuilders.multipart("/sample/uploadEx")
                .file(firstFile).file(secondFile)).andReturn();

        ModelAndView mav = result.getModelAndView();

        Assert.assertNotNull(mav.getModelMap());

        log.info(mav);
    }

    @Test
    public void testJSON()throws Exception{

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/sample/getJSON")).andReturn();

        log.info(result.getResponse().getContentAsString());
    }

}

























