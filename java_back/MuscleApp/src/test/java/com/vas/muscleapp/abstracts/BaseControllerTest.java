/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.abstracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vas.muscleapp.Application;
import com.vas.muscleapp.JpaConfigTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.springframework.test.context.ActiveProfiles;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 *
 * @author vinicius
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, JpaConfigTest.class})
//@WebAppConfiguration
@ActiveProfiles("test")
public abstract class BaseControllerTest {

    protected final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    protected MockMvc mockMvc;
    protected HttpMessageConverter httpMessageConverter;

    @Autowired
    protected WebApplicationContext webApplicationContext;
    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    public void setConverters(HttpMessageConverter<?>[] converters) {
        this.httpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
        assertNotNull("JSON message converter must not be null", this.httpMessageConverter);
    }

    @Before
    public void initMock() {        
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    protected String json(Object obj) throws IOException {
        MockHttpOutputMessage httpOutputMessage = new MockHttpOutputMessage();
        this.httpMessageConverter.write(obj, MediaType.APPLICATION_JSON, httpOutputMessage);
        return httpOutputMessage.getBodyAsString();
    }
}
