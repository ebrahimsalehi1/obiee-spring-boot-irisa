package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.obieeservices.ApplicationRoleController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationRoleController.class)
public class ApplicationRoleControllerTests {

    private MockMvc mockMvc ;

    @Test
    public boolean hasAdminRole(String userName) throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/obiee-bff/hasAdminRole/{userName}").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();

//        MvcResult mvcResult1 = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().json("Hello World"))
//                .andReturn();

        Assert.assertEquals("true",mvcResult.getResponse().toString());
    }
}
