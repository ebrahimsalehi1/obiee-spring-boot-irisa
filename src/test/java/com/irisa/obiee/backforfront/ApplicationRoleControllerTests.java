package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.obieeservices.ApplicationRoleController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationRoleController.class)
public class ApplicationRoleControllerTests {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    public void controllerHasAdminRole() throws Exception{
        String url = "/obiee-bff/hasAdminRole/z.omidvar";
        RequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE,"application/json");

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                ;

        //MvcResult mvcResult = mockMvc.perform(request).andReturn();

//        MvcResult mvcResult1 = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().json("Hello World"))
//                .andReturn();

        Assert.assertEquals("false",mvcResult.getResponse().getContentAsString());
    }
}
